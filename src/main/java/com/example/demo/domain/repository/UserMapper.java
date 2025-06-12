package com.example.demo.domain.repository;


import com.example.demo.domain.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User login(String email, String password);
}
