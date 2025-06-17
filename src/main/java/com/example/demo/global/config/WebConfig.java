package com.example.demo.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import com.example.demo.domain.register.Exception.CommonDtoFactory;
import com.example.demo.domain.register.model.dto.RegistResponseDto;

@Configuration
@ControllerAdvice
public class WebConfig implements WebMvcConfigurer {

    @Override
    // CORS 설정
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*") // 모든 origin 허용 (개발용)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }

}
