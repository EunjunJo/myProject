package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import org.apache.ibatis.annotations.Mapper;

public interface UserDAO {
    RegistResponseDto register(RegistRequestDto registRequestDto);

}
