package com.example.demo.domain.service;


import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    RegistResponseDto regist(RegistRequestDto registRequestDto);

}
