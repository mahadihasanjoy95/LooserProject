package com.mylooserproject.joy.LooserProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        List<ResponseMessage> list = new java.util.ArrayList<>();
        list.add(new ResponseMessageBuilder().code(500).message("Internal Server Error!").build());
        list.add(new ResponseMessageBuilder().code(403).message("Unauthorized").build());
        list.add(new ResponseMessageBuilder().code(400).message("Bad Request").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .directModelSubstitute(Object.class, java.lang.Void.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mylooserproject.joy.LooserProject.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(generateApiInfo())
                .globalResponseMessage(RequestMethod.GET, list)
                .globalResponseMessage(RequestMethod.POST, list);

    }
    private ApiInfo generateApiInfo() {
        return new ApiInfoBuilder()
                .title("Looser Project")
                .description("Just Build This from My Frustation")
                .version("1.0.0")
                .build();
    }

}
