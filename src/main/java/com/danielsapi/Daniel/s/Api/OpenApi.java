package com.danielsapi.Daniel.s.Api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI customOpenApi(@Value("$(Springdoc_version)") String appVersion){
        return new OpenAPI()
                .info(new Info()
                        .title("API of Employee")
                        .version(appVersion)
                        .description("API to manage employee")
                        .termsOfService("https://swagger.io/terms/")
                        .license(new License().name("MIT").url("https://mit-license.org/"))
                        .contact(new Contact().name("Name Label")
                                .url("name@email.com")
                        )
                );
    }
}
