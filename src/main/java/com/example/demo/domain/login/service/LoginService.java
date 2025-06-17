package com.example.demo.domain.login.service;

import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    User login(RegistRequestDto registRequestDto);
}
