package com.example.demo.domain.login.repository.dao;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.register.model.User;

public interface LoginDao {
    User login(LoginRequestDto loginRequestDto);
}
