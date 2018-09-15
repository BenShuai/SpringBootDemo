package com.zuul.geteway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author SunShuai
 * @date 2018/9/3
 */
@FeignClient("py-oauth-center")
public interface Oauth2Client {

    /**
     * 获取access_token<br>
     * 这是spring-security-oauth2底层的接口，类TokenEndpoint<br>
     *
     * @param parameters
     * @return
     * @see org.springframework.security.oauth2.provider.endpoint.TokenEndpoint
     */
    @RequestMapping(path = "/oauth/token",method = RequestMethod.POST)
    Map<String, Object> postAccessToken(@RequestParam Map<String, String> parameters);

    /**
     * 删除access_token和refresh_token<br>
     * 认证中心的OAuth2Controller方法removeToken
     *
     * @param access_token
     */
    @RequestMapping(value = "/remove_token", method = RequestMethod.POST)
    void removeToken(@RequestParam("access_token") String access_token);

}
