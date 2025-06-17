package com.example.demo.global.common;

import lombok.Data;
@Data
public class ResultCode {

    /**
     * Return Code 00 : success
     * */
    public static final String RESULT_CODE_100 = "100";
    /**
     * Return Code 01 : validation Error - name check
     * */
    public static final String RESULT_CODE_101 = "101";
    /**
     * Return Code 02 : Authorization - Login Failed
     * */
    public static final String RESULT_CODE_102 = "102";
    /**
     * Return Code 03 : DB Error - DB Access denied
     * */
    public static final String RESULT_CODE_103 = "103";

    /**
     * Return Code 04 : validation Error - password check
     * */
    public static final String RESULT_CODE_104 = "104";

    /**
     * Return Code 05 : validation Error - email check
     * */
    public static final String RESULT_CODE_105 = "105";

    /**
     * Return Code 06  duplicationError - exist Email
     * */
    public static final String RESULT_CODE_106 = "106";

    /**
     * Return Code 07  ValidationError - special Characters Check
     * */
    public static final String RESULT_CODE_107 = "107";

    /**
     * Return Code 07  ValidationError - special Characters Check
     * */
    public static final String RESULT_CODE_108 = "108";


}
