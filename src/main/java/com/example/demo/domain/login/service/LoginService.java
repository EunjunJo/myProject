package com.example.demo.domain.login.service;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.model.LoginResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
