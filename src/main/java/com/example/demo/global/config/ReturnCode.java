package com.example.demo.global.config;

import lombok.Data;

@Data
public class ReturnCode {

    /**
     * Return Code 00 : Success
     * */
    public static final String RETURN_CODE_00 = "00";

    /**
     * Return Code 01 : Validation Error - name Check
     * */
    public static final String RETURN_CODE_01 = "01";

    /**
     * Return Code 02 : Authorization Error - Login failed
     * */
    public static final String RETURN_CODE_02 = "02";

    /**
     * Return Code 03 : DB Error - DB access denied
     * */
    public static final String RETURN_CODE_03 = "03";

    /**
     * Return Code 04 : Validation Error - password Check
     * */
    public static final String RETURN_CODE_04 = "04";

    /**
     * Return Code 05 : Validation Error - email Check
     * */
    public static final String RETURN_CODE_05 = "05";
//    private final String RETURN_CODE_06 = "06";
}
