package com.it.sun.controller;

import com.it.sun.config.BaseConfig;
import com.it.sun.entity.User;
import com.it.sun.service.UserService;
import com.it.sun.task.AnsyncTask;
import com.it.common.uitl.ErrorCode;
import com.it.sun.vo.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
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

//    public SampleController() {
//        super();
//    }

    @Autowired
    private UserService userService;//这里会出现编译器红线提示报错，但是不影响程序的运行和使用，请忽略。
    //【如果看不下去报错，IDEA中设置“Settings→Inspections→搜索spring core→在Code的下面有个Autowiring Bean Class→Severity→将换成Warring”】

//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;//直接操作redis的类，进行字符串的存取


//    @Autowired
//    private RedisTemplate<String, User> redisTemplateUser;//使用User对象的方式去操作redis

//    @Autowired
//    private RedisTemplate<String, Messages> redisTemplateMessages;//使用Messages对象的方式去操作redis

//    @Autowired
//    private MongoDbUser mongoDbUser;//使用User对象的方式去操作MongoDb

    @Autowired
    private AnsyncTask ansyncTask;

    @ApiOperation(value="返回字符串", notes="返回字符串")
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        return "{\"name\":\"sunshuai\"}";
    }

    @ApiOperation(value="返回json", notes="返回json")
    @RequestMapping(value="/getUser", method= RequestMethod.GET)
    public User getUser(HttpServletRequest request, HttpServletResponse response,
                        @ApiParam(name = "userId", value = "用户id", required = true) @RequestParam(required = true) String userId) {
        User user = new User();
        user.setName("sunshuai");
        return user;
    }



//    @ApiOperation(value="将键值对存储到redis", notes="将键值对存储到redis")
//    @RequestMapping(value="/redisPlay", method=RequestMethod.POST)
//    public String redisPlay() {
//        // 保存字符串
//        stringRedisTemplate.opsForValue().set("aaa", "111");
//        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));//查询
//        return "success";
//    }

//    @ApiOperation(value="将键值对存储到redis", notes="将键值对存储到redis")
//    @RequestMapping(value="/redisPlay2", method=RequestMethod.POST)
//    public String redisPlay2() {
//        User u = new User();
//        u.setName("小明");
//        u.setAge(28);
//        redisTemplateUser.opsForValue().set(u.getName(), u);
//        System.out.println(redisTemplateUser.opsForValue().get("小明").getAge().longValue());//查询

//        Messages m=new Messages();
//        m.setCode("测试测试");
//        m.setAuth("发送人");
//        redisTemplateMessages.opsForValue().set(m.getAuth(), m);
//        System.out.println(redisTemplateMessages.opsForValue().get("发送人").getCode());//查询
//        return "success";
//    }

//    @ApiOperation(value="将对象存储到MongoDb", notes="将对象存储到MongoDb")
//    @RequestMapping(value="/MongoDbPlay", method=RequestMethod.POST)
//    public String MongoDbPlay() {
//        mongoDbUser.deleteAll();//清空
//        User u = new User();
//        u.setName("小明");
//        u.setAge(28);
//        mongoDbUser.save(u);
//
//        System.out.println(mongoDbUser.findAll().size());//查询
//        return "success";
//    }

    @ApiOperation(value="调用异步执行方法", notes="调用异步执行方法")
    @RequestMapping(value="/AnsyncPlay", method=RequestMethod.POST)
    public ApiResult AnsyncPlay() {
        ApiResult apiResult = new ApiResult(ErrorCode.ERROR.getStatus(),ErrorCode.ERROR.getMsg(),"执行失败");
        try {
            ansyncTask.Task1();
            ansyncTask.Task2();
            ansyncTask.Task3();

            return new ApiResult(ErrorCode.SUCCESS.getStatus(),ErrorCode.SUCCESS.getMsg(),"success");
        }catch (Exception e){
            apiResult.setData(e.getMessage());
            return apiResult;
        }
    }


    @ApiOperation(value="返回字符串", notes="返回字符串")
    @RequestMapping(value="/getCall", method= RequestMethod.GET)
    public ApiResult getCall(HttpServletRequest request, HttpServletResponse response) {
        ApiResult apiResult = new ApiResult(ErrorCode.ERROR.getStatus(),ErrorCode.ERROR.getMsg(),"查询失败");
        try {
            List<Map<String, String>> queryBas = userService.queryBa("33,42");
            return new ApiResult(ErrorCode.SUCCESS.getStatus(),ErrorCode.SUCCESS.getMsg(),queryBas);
        }catch (Exception e){
            apiResult.setData(e.getMessage());
            return apiResult;
        }
    }


}
