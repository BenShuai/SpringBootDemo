package com.zuul.geteway.controller;

import com.alibaba.fastjson.JSONObject;
import com.zuul.geteway.feign.Oauth2Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SunShuai
 * @date 2018/9/3
 */
@Slf4j
@RestController
public class TokenController {

    @Autowired
    private Oauth2Client oauth2Client;

    /**
     * 系统登陆<br>
     * 根据用户名登录<br>
     * 采用oauth2密码模式获取access_token和refresh_token
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/sys/login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>(1);
        Map<String, String> parameters = new HashMap<>(1);
        parameters.put(OAuth2Utils.GRANT_TYPE, "password");
        parameters.put(OAuth2Utils.CLIENT_ID, "system");
        parameters.put("client_secret", "system");
        parameters.put(OAuth2Utils.SCOPE, "app");
        parameters.put("username", username);
        parameters.put("password", password);
        Map<String, Object> tokenInfo = null;
        try{
            tokenInfo = oauth2Client.postAccessToken(parameters);
            map.put("data",tokenInfo);
            map.put("flag",200);
        }catch (Exception e){
            map.put("msg","登录失败");
            if (e != null) {
                String msg = e.getCause().toString();
                if (!StringUtils.isEmpty(msg)) {
                    int index = msg.indexOf("\n");
                    if (index > 0) {
                        String string = msg.substring(index);
                        if (!StringUtils.isEmpty(string)) {
                            JSONObject json = JSONObject.parseObject(string.trim());
                            if("Bad credentials".equals(json.getString("error_description"))){
                                map.put("msg","密码不正确");
                            }else {
                                map.put("msg",json.getString("error_description"));
                            }
                        }
                    }
                }
            }
            map.put("flag",500);
        }

        return map;
    }

    /**
     * 系统刷新refresh_token
     *
     * @param refresh_token
     * @return
     */
    @PostMapping("/sys/refresh_token")
    public Map<String, Object> refresh_token(String refresh_token) {
        Map<String, Object> map = new HashMap<>(1);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(OAuth2Utils.GRANT_TYPE, "refresh_token");
        parameters.put(OAuth2Utils.CLIENT_ID, "system");
        parameters.put("client_secret", "system");
        parameters.put(OAuth2Utils.SCOPE, "app");
        parameters.put("refresh_token", refresh_token);
        map.put("data",oauth2Client.postAccessToken(parameters));
        map.put("flag",200);
        map.put("msg","");
        return map;
    }

    /**
     * 退出
     *
     * @param access_token
     */
    @GetMapping("/sys/logout")
    public Map<String, Object> logout(String access_token, @RequestHeader(required = false, value = "Authorization") String token) {
        Map<String, Object> map = new HashMap<>(1);
        if (StringUtils.isBlank(access_token)) {
            if (StringUtils.isNoneBlank(token)) {
                access_token = token.substring(OAuth2AccessToken.BEARER_TYPE.length() + 1);
            }
        }
        oauth2Client.removeToken(access_token);
        map.put("data","");
        map.put("flag",200);
        map.put("msg","");
        return map;
    }
}
