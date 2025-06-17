package com.example.demo.domain.register.controller;


import com.example.demo.domain.register.Exception.CommonDtoFactory;
import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.domain.register.model.dto.RegistResponseDto;
import com.example.demo.domain.register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.springframework.dao.DataAccessException;
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
            RegistResponseDto rrd = new RegistResponseDto();

            boolean validSpecialCheck =
                new CommonDtoFactory().validationSpecialCharCheck(registRequestDto);

            boolean validEmmailCheck =
                new CommonDtoFactory().validEmailSpecialCharCheck(registRequestDto);

            String validationError =
                new CommonDtoFactory().validationCheck(registRequestDto);

            if(!validEmmailCheck) {
                rrd.setRegistRequestDto(null);
                rrd.setCommonDto(CommonDtoFactory.valiEmailCheck());
                return rrd;
            }
            if (!validSpecialCheck) {
                rrd.setRegistRequestDto(null);
                rrd.setCommonDto(CommonDtoFactory.validationCheck());
                return rrd;
            }
            else if (validationError != null) {
                rrd.setRegistRequestDto(null);
                if (validationError.equals("validationError")) {
                    rrd.setCommonDto(CommonDtoFactory.validationCheck());
                }
                if (validationError.equals("name")) {
                    rrd.setCommonDto(CommonDtoFactory.nameValidationError());
                }
                else if (validationError.equals("password")) {
                    rrd.setCommonDto(CommonDtoFactory.passwordValidationError());
                }
                else if (validationError.equals("email")) {
                    rrd.setCommonDto(CommonDtoFactory.emailValidationCheck());
                }
                return rrd;
            } else {
                return registerService.regist(registRequestDto);
            }
        }
        catch (DataAccessException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.dbAccessDenied());
            return rrd;
        }
        catch (DuplicateMemberException e) {
            RegistResponseDto rrd = new RegistResponseDto();
            rrd.setRegistRequestDto(null);
            rrd.setCommonDto(CommonDtoFactory.existUser());
            return rrd;
        }
    }


}
