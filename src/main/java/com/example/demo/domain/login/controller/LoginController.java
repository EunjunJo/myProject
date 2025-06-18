package com.example.demo.domain.login.controller;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.model.LoginResponseDto;
import com.example.demo.domain.login.service.LoginService;
import com.example.demo.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final JwtUtil jwtUtil;
    private final LoginService loginService;
    
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = loginService.login(loginRequestDto);
        
        // 로그인 성공 시에만 JWT 토큰 생성
        if (loginResponseDto.getCommonDto().getResultCode().equals("100")) {
            String token = jwtUtil.generateToken(loginRequestDto.getEmail());
            loginResponseDto.setToken(token);
        }
        
        return loginResponseDto;
    }
}
