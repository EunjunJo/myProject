package com.example.demo.domain.register.repository;

import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;

public interface UserDAO {
    RegistResponseDto register(RegistRequestDto registRequestDto) throws DuplicateMemberException;

}
