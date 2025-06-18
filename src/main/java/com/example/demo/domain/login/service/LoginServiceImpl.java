package com.example.demo.domain.login.service;

import com.example.demo.domain.login.model.LoginRequestDto;
import com.example.demo.domain.login.model.LoginResponseDto;
import com.example.demo.domain.login.repository.dao.LoginDao;
import com.example.demo.domain.register.model.User;
import com.example.demo.global.common.CommonDto;
import com.example.demo.global.common.ResultCode;
import com.example.demo.global.common.ResultMessage;
import com.example.demo.global.common.ReturnCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = loginDao.login(loginRequestDto);
        
        LoginResponseDto responseDto = new LoginResponseDto();
        
        if (user != null) {
            // 로그인 성공
            responseDto.setEmail(user.getEmail());
            responseDto.setPassword(user.getPassword());
            responseDto.setUsername(user.getName());
            responseDto.setSeqNumber(user.getSeqNumber());
            responseDto.setToken("dummy-token-" + System.currentTimeMillis()); // 임시 토큰 생성
            
            // 성공 CommonDto 생성
            CommonDto commonDto = new CommonDto();
            commonDto.setResultCode(ResultCode.RESULT_CODE_100);
            commonDto.setReturnCode(ReturnCode.RETURN_CODE_00);
            commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_100_00);
            responseDto.setCommonDto(commonDto);
        } else {
            // 로그인 실패
            responseDto.setEmail(null);
            responseDto.setPassword(null);
            responseDto.setUsername(null);
            responseDto.setSeqNumber(0);
            responseDto.setToken(null);
            
            // 실패 CommonDto 생성
            CommonDto commonDto = new CommonDto();
            commonDto.setResultCode(ResultCode.RESULT_CODE_102);
            commonDto.setReturnCode(ReturnCode.RETURN_CODE_02);
            commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_102_02);
            responseDto.setCommonDto(commonDto);
        }
        
        return responseDto;
    }
}
