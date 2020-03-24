package com.it.sun;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Swagger插件的配置类，开发环境保留，正式生产的时候，去掉配置
 * @author sunshuai
 * 2016-10-20
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket api() {

        //添加全局响应状态码
        List<ResponseMessage> responseMessageList = new ArrayList<>();


        Arrays.stream(com.it.common.uitl.ErrorCode.values()).forEach(ErrorCode -> {
            responseMessageList.add(
                    new ResponseMessageBuilder().code(ErrorCode.getStatus()).message(ErrorCode.getMsg()).responseModel(
                            new ModelRef(ErrorCode.getMsg())).build()
            );
        });

        return new Docket(DocumentationType.SWAGGER_2)

                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)

                .apiInfo(apiInfo())
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))// 错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/loggers.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/service-registry.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/health.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/auditevents.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/env.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/refresh.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/heapdump.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/metrics.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/archaius.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/autoconfig.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/beans.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/configprops.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/consul.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/dump.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/features.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/info.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/mappings.*")))// consul注册相关的包不监控
                .paths(Predicates.not(PathSelectors.regex("/trace.*")))// consul注册相关的包不监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-API文档")
                .description("南方朗郎")
                .termsOfServiceUrl("https://openapi.123.com:8888/")
                .contact(new Contact("lenleicool#163.com", "https://github.com/BenShuai/", "lenleicool#163.com"))
                .version("1.2.18")
                .build();
    }
}