package com.example.demo.global.config;

import lombok.Data;

@Data
public class ReturnCode {

    /**
     * Return Code 01 : Register Validation Error - Input email, password, name Check
     * */
    private final String RETURN_CODE_01 = "01";

    /**
     * Return Code 02 : Authorization Error - Login failed
     * */
    private final String RETURN_CODE_02 = "02";

    /**
     * Return Code 03 : DB Error - DB access denied
     * */
    private final String RETURN_CODE_03 = "03";

//    /**
//     *
//     * */
//    private final String RETURN_CODE_04 = "04";
//    private final String RETURN_CODE_05 = "05";
//    private final String RETURN_CODE_06 = "06";
}
