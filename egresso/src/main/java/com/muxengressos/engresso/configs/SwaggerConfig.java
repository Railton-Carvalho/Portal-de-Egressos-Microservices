package com.muxengressos.engresso.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("Egresso Microservice")
                        .version("v1")
                        .description("microservice from Portal do Egresso")
                        .contact(new Contact()
                                .name("Egresso Microservice")
                                .email("railton@gmail.com")
                        )
                        .termsOfService("https://api.mux.com.br/egresso/terms")
                        .license(new License().name("Apache 2.0").url("https://api.mux.com.br/egresso"))

        );
    }

}
