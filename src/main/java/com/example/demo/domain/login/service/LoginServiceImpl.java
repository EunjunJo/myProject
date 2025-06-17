package com.example.demo.domain.login.service;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.repository.dao.LoginDao;
import com.example.demo.domain.register.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    @Override
    public User login(LoginRequestDto loginRequestDto) {
        return loginDao.login(loginRequestDto);
    }
}
