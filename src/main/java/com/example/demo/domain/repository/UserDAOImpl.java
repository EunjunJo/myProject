package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO{

    private final UserMapper userMapper;

    @Override
    public User register(RegistRequestDto registRequestDto) {
        return userMapper.Register(registRequestDto);
    }
}
