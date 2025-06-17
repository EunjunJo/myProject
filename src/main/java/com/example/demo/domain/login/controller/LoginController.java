package com.example.demo.domain.login.controller;


import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.model.LoginResponseDto;
import com.example.demo.domain.login.service.LoginService;
import com.example.demo.global.Exception.CommonDtoFactory;
import com.example.demo.global.common.CommonDto;
import com.example.demo.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final JwtUtil jwtUtil;

    private final LoginService loginService;
    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        if("user".equals(loginRequestDto.getEmail()) && "password".equals(loginRequestDto.getPassword())) {
            String token = jwtUtil.generateToken(loginRequestDto.getEmail());
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            CommonDto commonDto = CommonDtoFactory.success();
            loginResponseDto.setCommonDto(commonDto);
            loginResponseDto.setLoginRequestDto(loginRequestDto);
            return loginResponseDto;
        }

        loginService.login(loginRequestDto);
        return null;
    }
}
