package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@ConfigurationProperties(prefix = "springdoc")
public class SwaggerConfig {

    private String host;
    private String title;
    private String version;

    @Bean
    public OpenAPI api() {
        return new OpenAPI().
                addServersItem(new Server().url(host)).
                info(new Info().title(title).version(version));
    }
}
