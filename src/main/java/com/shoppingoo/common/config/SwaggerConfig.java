package com.shoppingoo.common.config;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info; // 올바른 Info 클래스 import
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        String jwt = "JWT";
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);
        Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
                .name(jwt)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
        );
        return new OpenAPI()
                .components(new Components())  // 중복된 components는 제거 가능
                .info(apiInfo()) // Info 클래스를 반환하는 메서드 호출
                .addSecurityItem(securityRequirement)
                .components(components);
    }

    // 올바른 Info 객체를 반환하는 메서드
    private Info apiInfo() {
        return new Info()
                .title("API Test") // API 제목
                .description("Let's practice Swagger UI") // API 설명
                .version("1.0.0"); // API 버전
    }
}