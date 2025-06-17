package com.example.demo.domain.login.repository.dao;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.repository.mapper.LoginMapper;
import com.example.demo.domain.register.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LoginDaoImpl implements LoginDao{

    private final LoginMapper loginMapper;

    @Override
    public User login(LoginRequestDto loginRequestDto) {
        return loginMapper.findByUsername(loginRequestDto);
    }
}
