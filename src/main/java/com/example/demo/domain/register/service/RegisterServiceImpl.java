package com.example.demo.domain.register.service;

import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.model.dto.UserDto;
import com.example.demo.domain.register.repository.UserDAO;
import com.example.demo.global.Exception.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{

    private final UserDAO userDAO;

    @SneakyThrows
    @Override
    public RegistResponseDto regist(RegistRequestDto registRequestDto)
        throws DuplicateMemberException {

        RegistResponseDto responseDto = userDAO.register(registRequestDto);
        return responseDto;
    }

    public UserDto findByEmail(String email) {
        UserDto users = userDAO.findByEmail(email);

        return users;
    }
}
