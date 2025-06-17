package com.example.demo.domain.Exception;

import com.example.demo.global.config.CommonDto;
import com.example.demo.global.config.ResultCode;
import com.example.demo.global.config.ResultMessage;
import com.example.demo.global.config.ReturnCode;


public class CommonDtoFactory {

    public static CommonDto validationError() {
        CommonDto commonDto = new CommonDto();
        commonDto.setResultCode(ResultCode.RESULT_CODE_101);
        commonDto.setReturnCode(ReturnCode.RETURN_CODE_01);
        commonDto.setResultMessage(ResultMessage.RESULT_MESSAGE_101_01);

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

}