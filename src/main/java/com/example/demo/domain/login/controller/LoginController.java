package com.example.demo.domain.login.controller;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.model.LoginResponseDto;
import com.example.demo.domain.login.service.LoginService;
import com.example.demo.global.common.CommonDto;
import com.example.demo.global.common.ResultCode;
import com.example.demo.global.common.ResultMessage;
import com.example.demo.global.common.ReturnCode;
import com.example.demo.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping("/logout")
    public ResponseEntity<CommonDto> logout(@RequestHeader("Authorization") String token) {
        // 토큰에서 "Bearer " 제거
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        // 토큰 유효성 검사
        if (jwtUtil.validateToken(token)) {
            // 블랙리스트에 토큰 추가
            jwtUtil.blacklistToken(token);
            log.info("User logged out successfully: {}", jwtUtil.extractUsername(token));
        }
        
        // 성공 응답
        CommonDto response = new CommonDto();
        response.setResultCode(ResultCode.RESULT_CODE_100);
        response.setReturnCode(ReturnCode.RETURN_CODE_00);
        response.setResultMessage(ResultMessage.RESULT_MESSAGE_100_00);
        
        return ResponseEntity.ok(response);
    }
}
