package com.example.demo.domain.register.service;

import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class RegisterServiceImpl implements RegisterService{

    private final UserDAO userDAO;

    @Override
    public RegistResponseDto regist(RegistRequestDto registRequestDto)
        throws DuplicateMemberException {

        RegistResponseDto responseDto = userDAO.register(registRequestDto);
        return responseDto;
    }


}
