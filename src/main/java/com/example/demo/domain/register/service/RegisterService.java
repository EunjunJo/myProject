package com.example.demo.domain.register.service;


import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.model.dto.UserDto;
import com.example.demo.global.Exception.DuplicateMemberException;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    RegistResponseDto regist(RegistRequestDto registRequestDto) throws DuplicateMemberException;

    UserDto findByEmail(String email);
}
