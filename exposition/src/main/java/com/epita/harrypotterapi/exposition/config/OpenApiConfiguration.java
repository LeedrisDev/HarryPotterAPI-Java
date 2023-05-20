package com.epita.harrypotterapi.exposition.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Harry Potter API")
                                .description("API to handle reservations of rooms in Hogwarts.")
                                .version("1.0.0")
                                .contact(new Contact()
                                        .name("Foenix Blondel Thomas")
                                        .email("thomas.foenix-blondel@epita.fr")
                                )
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local server")
                ));
    }
}
