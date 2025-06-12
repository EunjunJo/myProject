package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    User login(RegistRequestDto registRequestDto);
}
