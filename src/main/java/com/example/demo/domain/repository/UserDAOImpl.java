package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO{

    private final UserMapper userMapper;

    @Override
    public User login(String email, String password) {
        return userMapper.login(email, password);
    }
}
