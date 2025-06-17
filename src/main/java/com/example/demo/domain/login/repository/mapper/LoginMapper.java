package com.example.demo.domain.login.repository.mapper;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.register.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    User findByUsername(LoginRequestDto loginRequestDto);
}
