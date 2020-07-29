package com.mdsol.raa.trustedticketgenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class OpenAPIConfig {

    @Bean
    public Docket protocolApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mdsol.raa.trustedticketgenerator"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo("Trusted-Ticket-Generator",
                "This is the service for generating the tableau trusted ticket. Service response to the GET/POST request will be a unique string (the ticket). If Tableau Server isn’t able to process the request, the return will be -1.",
                "1.0",
                "","Medidata Solutions","license",""
        );
    }
}
