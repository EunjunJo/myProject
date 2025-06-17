package com.example.demo.domain.repository;

import com.example.demo.domain.Exception.CommonDtoFactory;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import com.example.demo.domain.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDAOImpl implements UserDAO {

    private final UserMapper userMapper;

    @Override
    public RegistResponseDto register(RegistRequestDto registRequestDto) {
        int result = userMapper.Register(registRequestDto);
        
        RegistResponseDto responseDto = new RegistResponseDto();
        
        if (result > 0) {
            // 성공
            responseDto.setRegistRequestDto(registRequestDto);
            responseDto.setCommonDto(CommonDtoFactory.success()); // 성공 메시지 생성 필요
        } else {
            // 실패
            responseDto.setRegistRequestDto(null);
            responseDto.setCommonDto(CommonDtoFactory.dbAccessDenied());
        }
        
        return responseDto;
    }

}
