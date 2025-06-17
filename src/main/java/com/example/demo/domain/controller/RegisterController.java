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
            String validationError = validationCheck(registRequestDto);
            if (validationError != null) {
                RegistResponseDto rrd = new RegistResponseDto();
                rrd.setRegistRequestDto(null);
                if (validationError.equals("name")) {
                    rrd.setCommonDto(CommonDtoFactory.nameValidationError()); // 임시로 name validation 에러 사용
                } else if (validationError.equals("password")) {
                    rrd.setCommonDto(CommonDtoFactory.passwordValidationError());
                } else if (validationError.equals("email")) {
                    rrd.setCommonDto(CommonDtoFactory.emailValidationCheck());
                }
                return rrd;
            } else {
                return registerService.regist(registRequestDto);
            }
        } catch (DataAccessException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.dbAccessDenied());
            return rrd;
        }
    }

    public String validationCheck(RegistRequestDto registRequestDto) {

        if (registRequestDto.getName() == null || registRequestDto.getName().length() > 4
            || registRequestDto.getName().length() < 2) {
            return "name";
        }
        if (registRequestDto.getPassword() == null || registRequestDto.getPassword().length() > 25
            || registRequestDto.getPassword().length() < 8) {
            return "password";
        }
        if (registRequestDto.getEmail() == null || registRequestDto.getEmail().length() > 30
            || registRequestDto.getEmail().length() < 12) {
            return "email";
        }

        return null; // validation 통과
    }

}
