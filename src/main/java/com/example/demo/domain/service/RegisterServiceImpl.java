package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import com.example.demo.domain.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{

    private final UserDAO userDAO;

    @Override
    public RegistResponseDto regist(RegistRequestDto registRequestDto) {
        RegistResponseDto responseDto = userDAO.register(registRequestDto);

        return responseDto;
    }
}
