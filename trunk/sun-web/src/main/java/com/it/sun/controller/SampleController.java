package com.it.sun.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.it.sun.config.BaseConfig;
import com.it.sun.entity.CkioskBrand;
import com.it.sun.service.CkioskBrandService;
import com.it.sun.task.AnsyncTask;
import com.it.common.uitl.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


@Api(value="/Sample",description="公共信息查询类")
@RestController
@RequestMapping(value="/Sample")
@EnableConfigurationProperties({BaseConfig.class})
public class SampleController {
    //http://localhost:8085/swagger-ui.html

    @Autowired
    CkioskBrandService ckioskBrandService;//这里会出现编译器红线提示报错，但是不影响程序的运行和使用，请忽略。
    //【如果看不下去报错，IDEA中设置“Settings→Inspections→搜索spring core→在Code的下面有个Autowiring Bean Class→Severity→将换成Warring”】

    @Autowired
    private AnsyncTask ansyncTask;

    @ApiOperation(value="返回字符串", notes="返回字符串")
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        return "{\"name\":\"sunshuai\"}";
    }

    @ApiOperation(value="返回json", notes="返回json")
    @RequestMapping(value="/getUser", method= RequestMethod.GET)
    public CkioskBrand getUser(HttpServletRequest request, HttpServletResponse response,
                               @ApiParam(name = "userId", value = "用户id", required = true) @RequestParam(required = true) String userId) {
        CkioskBrand user = new CkioskBrand();
        user.setName("sunshuai");
        return user;
    }



    @ApiOperation(value="调用异步执行方法", notes="调用异步执行方法")
    @RequestMapping(value="/AnsyncPlay", method=RequestMethod.POST)
    public String AnsyncPlay() {
        JSONObject jo = new JSONObject();
        jo.put("msg","查询成功");
        jo.put("code", ErrorCode.SUCCESS.getStatus());
        try {
            ansyncTask.Task1();
            ansyncTask.Task2();
            ansyncTask.Task3();

            jo.put("data", "异步任务执行");
        }catch (Exception e){
            jo.put("msg","查询失败");
            jo.put("code", ErrorCode.ERROR.getStatus());
        }
        return jo.toJSONString();
    }


    @ApiOperation(value="返回字符串", notes="返回字符串")
    @RequestMapping(value="/getCall", method= RequestMethod.GET)
    public String getCall(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jo = new JSONObject();
        jo.put("msg","查询成功");
        jo.put("code", ErrorCode.SUCCESS.getStatus());
        try {
            List<Map<String, String>> queryBas = ckioskBrandService.queryBa("33,42");
            jo.put("data", JSONArray.parseArray(queryBas.toString()));
        }catch (Exception e){
            jo.put("msg","查询失败");
            jo.put("code", ErrorCode.ERROR.getStatus());
        }
        return jo.toJSONString();
    }


}
