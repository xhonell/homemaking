package com.successTeam.cleaning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                //资源
                .globalResponses(HttpMethod.GET, new ArrayList<>())
                .globalResponses(HttpMethod.PUT, new ArrayList<>())
                .globalResponses(HttpMethod.POST, new ArrayList<>())
                .globalResponses(HttpMethod.DELETE, new ArrayList<>())
                //是否启动
                .enable(true)
                //头部信息
                .apiInfo(apiInfo())
                .select()
                /**
                 * RequestHandlerSelectors,配置要扫描接口的方式
                 * basePackage指定要扫描的包
                 * any()扫描所有，项目中的所有接口都会被扫描到
                 * none()不扫描
                 * withClassAnnotation()扫描类上的注解
                 * withMethodAnnotation()扫描方法上的注解
                 */
                .apis(RequestHandlerSelectors.basePackage("com.successTeam.cleaning"))
                //过滤某个路径
                .paths(PathSelectors.any())
                .build()
                //协议
                .protocols(newHashSet("https", "http"))
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }


    /**
     * API 页面上半部分展示信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("天鹅到家保洁微服务接口文档")
                .description("天鹅到家保洁微服务接口文档")
                .contact(new Contact("Linyy", null, "successTeam@qq.com"))
                .version("1.0")
                .build();
    }

    /**
     * 设置接口单独的授权信息
     */
    private List<SecurityScheme> securitySchemes() {
        return Collections.singletonList(new ApiKey("token", "token", "header"));
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(
                                Collections.singletonList(new SecurityReference("token",
                                        new AuthorizationScope[]{new AuthorizationScope("global", "")}
                                )))
                        //.forPaths(PathSelectors.any())
                        .build()
        );
    }

    @SafeVarargs
    private final <T> Set<T> newHashSet(T... ts) {
        if (ts.length > 0) {
            return new LinkedHashSet<>(Arrays.asList(ts));
        }
        return null;
    }
}
