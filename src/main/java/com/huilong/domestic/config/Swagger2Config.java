package com.huilong.domestic.config;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Optional;
import com.google.common.base.Function;


/**
 * @author yanxt
 * @Description: swagger接口文档配置类
 * @date 2020/12/24  8:40
 */
//swagger2的配置文件，在项目的启动类的同级文件建立
@Configuration
@EnableSwagger2
/**
 * 是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
 */
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class Swagger2Config {
    // 定义分隔符
    private static final String SPLIT = ";";
    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.huilong.domestic"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }
    /**
     * 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
               .title("使用 Swagger2 构建RESTful API")
                // 创建人信息
               // .contact(new Contact("MrCao",  "https://www.cnblogs.com/zs-notes/category/1258467.html",  "1729497919@qq.com"))
                // 版本号
              //  .version("1.0")
                // 描述
               // .description("API 描述")
                .build();
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function <Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(SPLIT)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

}
