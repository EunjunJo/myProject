package com.example.demo.global.Exception;

import com.example.demo.domain.register.model.dto.RegistRequestDto;
import com.example.demo.global.common.CommonDto;
import com.example.demo.global.common.ResultCode;
import com.example.demo.global.common.ResultMessage;
import com.example.demo.global.common.ReturnCode;


public class CommonDtoFactory {

    public static CommonDto nameValidationError() {
        CommonDto commonDto = new CommonDto();
        commonDto.setResultCode(ResultCode.RESULT_CODE_101);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_01);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_101_01);

        return commonDto;
    }

    public static CommonDto passwordValidationError() {
        CommonDto commonDto = new CommonDto();
        commonDto.setResultCode(ResultCode.RESULT_CODE_104);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_04);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_104_04);

        return commonDto;
    }

    public static CommonDto dbAccessDenied() {
        CommonDto commonDto = new CommonDto();
        commonDto.setResultCode(ResultCode.RESULT_CODE_103);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_03);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_103_03);

        return commonDto;
    }

    public static CommonDto authorizationError() {
        CommonDto commonDto = new CommonDto();

        commonDto.setResultCode(ResultCode.RESULT_CODE_102);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_02);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_102_02);

        return commonDto;
    }

    public static CommonDto emailValidationCheck() {
        CommonDto commonDto = new CommonDto();

        commonDto.setReturnCode(ReturnCode.RETURN_CODE_05);
        commonDto.setResultCode(ResultCode.RESULT_CODE_105);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_105_05);

        return commonDto;
    }

    public static CommonDto success() {
        CommonDto commonDto = new CommonDto();

        commonDto.setReturnCode(ReturnCode.RETURN_CODE_00);
        commonDto.setResultCode(ResultCode.RESULT_CODE_100);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_100_00);

        return commonDto;
    }

    public static CommonDto existUser() {
        CommonDto commonDto = new CommonDto();
        commonDto.setResultCode(ResultCode.RESULT_CODE_106);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_106_06);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_06);

        return commonDto;
    }

    public static CommonDto validationCheck() {
        CommonDto commonDto = new CommonDto();
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_07);
        commonDto.setResultCode(ResultCode.RESULT_CODE_107);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_107_07);
        return commonDto;
    }

    public static CommonDto valiEmailCheck() {
        CommonDto commonDto = new CommonDto();
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_07);
        commonDto.setResultCode(ResultCode.RESULT_CODE_108);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_108_07);
        return commonDto;
    }

    public boolean validationSpecialCharCheck(RegistRequestDto registRequestDto) {
        String regex = "^[0-9a-zA-Z]+$";
        return registRequestDto.getPassword().matches(regex);
    }

    public boolean validEmailSpecialCharCheck(RegistRequestDto registRequestDto) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
        return registRequestDto.getEmail().matches(regex);
    }

    public String validationCheck(RegistRequestDto registRequestDto) {

        if (validationSpecialCharCheck(registRequestDto)) {

            if (registRequestDto.getName() == null || registRequestDto.getName().length() > 4
                || registRequestDto.getName().length() < 2) {
                return "name";
            }
            if (registRequestDto.getPassword() == null
                || registRequestDto.getPassword().length() > 25
                || registRequestDto.getPassword().length() < 8) {
                return "password";
            }
            if (registRequestDto.getEmail() == null || registRequestDto.getEmail().length() > 30
                || registRequestDto.getEmail().length() < 12) {
                return "email";
            }
        }
        return null;
    }
}