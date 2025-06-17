package com.example.demo.domain.register.service;


import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    RegistResponseDto regist(RegistRequestDto registRequestDto) throws DuplicateMemberException;

}
