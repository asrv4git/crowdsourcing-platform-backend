package com.github.crowdsourcingplatformapi.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Internal Crowdsourcing Platform")
                .description("Crowdsourcing tool to post simple and moderately complex tasks and ideas; where qualified " +
                        "contacts from the company can pick the tasks and deliver them in a timely manner. " +
                        "The requestor can create the tasks on the tool and the worker can pick the tasks from the pool " +
                        "and deliver them.")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")

                .version("1.0.0")
                .contact(new Contact("Adarsh Srivastava", "", "adarshsrivastava125@gmail.com"))
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.not(RequestHandlerSelectors.withClassAnnotation(ControllerAdvice.class)))
                .apis(RequestHandlerSelectors.basePackage("com.github.crowdsourcingplatformapi"))
                .build()
                .apiInfo(apiInfo());
    }

}

