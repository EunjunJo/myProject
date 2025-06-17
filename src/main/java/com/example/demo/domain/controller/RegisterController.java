package com.example.demo.domain.controller;


import com.example.demo.domain.Exception.CommonDtoFactory;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import com.example.demo.domain.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public RegistResponseDto RegistController(@RequestBody RegistRequestDto registRequestDto) {

        try {
            validationCheck(registRequestDto);
            return registerService.regist(registRequestDto);
        }
        catch (DataAccessException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.dbAccessDenied());
            return rrd;
        }
        catch (AuthorizationDeniedException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.authorizationError());
            return rrd;
        }

    }

    public void validationCheck(RegistRequestDto registRequestDto) {

        if(registRequestDto.getName().length() > 4
            || registRequestDto.getName().length() < 2) {
            CommonDtoFactory.nameValidationError();
        }
        if(registRequestDto.getPassword().length() > 25
            || registRequestDto.getPassword().length() < 8) {
            CommonDtoFactory.passwordValidationError();
        }
        if(registRequestDto.getEmail().length() > 30
            || registRequestDto.getEmail().length() < 12) {
            CommonDtoFactory.emailValidationCheck();
        }

    }

}
