package com.example.demo.global.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

            .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (개발용)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register/**" ).permitAll() // 공개 경로
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/") // 커스텀 로그인 페이지
                .defaultSuccessUrl("/") // 로그인 성공 시 리디렉션
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

            return http.build();
    }

}