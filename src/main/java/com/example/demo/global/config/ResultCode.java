package com.example.demo.global.config;

import lombok.Data;

@Data
public class ResultCode {

    /**
     * Return Code 00 : success
     * */
    private final String RESULT_CODE_100 = "100";
    /**
     * Return Code 01 : Validation Error
     * */
    private final String RESULT_CODE_101 = "101";
    /**
     * Return Code 02 : Authorization - Login Failed
     * */
    private final String RESULT_CODE_102 = "102";
    /**
     * Return Code 03 : DB Error - DB Access denied
     * */
    private final String RESULT_CODE_103 = "103";
//    private final String RESULT_CODE_104 = "104";
//    private final String RESULT_CODE_105 = "105";
//    private final String RESULT_CODE_106 = "106";


}
