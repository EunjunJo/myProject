package com.example.demo.domain.repository;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import org.apache.ibatis.annotations.Mapper;

public interface UserDAO {
    User register(RegistRequestDto registRequestDto);

}
