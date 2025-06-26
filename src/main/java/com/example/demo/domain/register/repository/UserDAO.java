package com.example.demo.domain.register.repository;

import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.model.dto.UserDto;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;

public interface UserDAO {
    RegistResponseDto register(RegistRequestDto registRequestDto) throws DuplicateMemberException;
    UserDto findByEmail(String email);
}
