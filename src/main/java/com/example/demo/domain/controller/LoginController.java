package com.example.demo.domain.controller;


import com.example.demo.domain.Exception.HandleCommonDtoException;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import com.example.demo.domain.service.LoginService;
import com.example.demo.domain.service.RegisterService;
import com.example.demo.global.config.CommonDto;
import com.example.demo.global.config.ResultCode;
import com.example.demo.global.config.ResultMessage;
import com.example.demo.global.config.ReturnCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final RegisterService registerService;

    @PostMapping("/register")
    public RegistResponseDto RegistController(@RequestBody RegistRequestDto registRequestDto) {

        try {
            RegistResponseDto re = registerService.regist(registRequestDto);
            return re;
        }
        catch (Exception e) {
             HandleCommonDtoException h = new HandleCommonDtoException();



            return null;
        }
    }

}
