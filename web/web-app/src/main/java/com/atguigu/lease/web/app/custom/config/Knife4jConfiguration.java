package com.atguigu.lease.web.app.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 囍崽
 * version 1.0
 */
@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("APP接口") // 文档标题
                        .version("1.0") // 文档版本
                        .description("用户端APP接口") // 文档描述
                        .termsOfService("http://doc.xiaominfo.com") //  API 服务器
                        .license(new License().name("Apache 2.0")
                                .url("http://doc.xiaominfo.com"))); // 基本 URL
    }

    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder().group("登录信息")
                .pathsToMatch("/app/login/**", "/app/info")
                .build();
    }

    @Bean
    public GroupedOpenApi lookForRoomAPI() {
        return GroupedOpenApi.builder().group("找房信息")
                .pathsToMatch(
                        "/app/apartment/**",
                        "/app/room/**",
                        "/app/payment/**",
                        "/app/region/**",
                        "/app/term/**"
                )
                .build();
    }
}