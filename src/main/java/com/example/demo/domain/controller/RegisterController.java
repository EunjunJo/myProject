package com.example.demo.domain.controller;


import com.example.demo.domain.Exception.CommonDtoFactory;
import com.example.demo.domain.model.dto.RegistRequestDto;
import com.example.demo.domain.model.dto.RegistResponseDto;
import com.example.demo.domain.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
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
            return registerService.regist(registRequestDto);
        }
        catch (DataAccessException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.dbAccessDenied());
            return rrd;
        }


    }

}
