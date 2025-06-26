package com.example.demo.domain.register.repository;

import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.UserDto;
import com.example.demo.global.Exception.CommonDtoFactory;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO {

    private final UserMapper userMapper;

    @Override
    public RegistResponseDto register(RegistRequestDto registRequestDto)
        throws DuplicateMemberException {

        if(userMapper.existByEmail(registRequestDto.getEmail()) > 0) {
            throw new DuplicateMemberException("이미 존재하는 아이디입니다.");
        }

        int result = userMapper.Register(registRequestDto);
        
        RegistResponseDto responseDto = new RegistResponseDto();
        
        if (result > 0) {
            // 성공
            responseDto.setRegistRequestDto(registRequestDto);
            responseDto.setCommonDto(CommonDtoFactory.success());
        } else {
            responseDto.setRegistRequestDto(null);
            responseDto.setCommonDto(CommonDtoFactory.dbAccessDenied());
        }
        
        return responseDto;
    }

    @Override
    public UserDto findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

}
