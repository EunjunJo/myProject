package com.example.demo.domain.controller;


import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.service.LoginService;
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

    private final LoginService loginService;

    @PostMapping("/register")
    public CommonDto RegistController(@RequestBody RegistRequestDto registRequestDto) {



        CommonDto commonDto = new CommonDto();

        commonDto.setResultCode(ResultCode.RESULT_CODE_100);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_00);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_100_00);

        return commonDto;
    }

//    @PostMapping
//    public CommonDto loginController(@RequestBody RegistRequestDto registRequestDto) throws Exception {
//        User re = loginService.login(registRequestDto);
//
//
//    }

}
