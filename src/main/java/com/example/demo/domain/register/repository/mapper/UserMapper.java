package com.example.demo.domain.register.repository.mapper;


import com.example.demo.domain.register.model.dto.RegistRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int Register(RegistRequestDto registRequestDto);
    int existByEmail(String email);
}

