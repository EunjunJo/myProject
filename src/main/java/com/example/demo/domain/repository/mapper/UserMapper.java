package com.example.demo.domain.repository.mapper;


import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    User login(String email, String password);
    RegistResponseDto Register(RegistRequestDto registRequestDto);

}

