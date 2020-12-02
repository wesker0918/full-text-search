package com.yunli.ecology.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangyue
 * @date 2020/7/3 9:08 PM
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "ecology-fts", name = "show-swagger-ui", havingValue = "true")
public class SwaggerConfig {

    /**
     * 版本
     */
    @Value("${ecology-fts.version:0.0.1-SNAPSHOT}")
    private String version;

    /**
     * @return
     */
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yunli.ecology.search.controller"))
                .paths(PathSelectors.any())
                .build()
//                .globalOperationParameters(parameters)
                .groupName("api");
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("甘肃全文检索")
                .description("甘肃全文检索")
                .termsOfServiceUrl("")
                .version(version)
                .build();
    }

}
