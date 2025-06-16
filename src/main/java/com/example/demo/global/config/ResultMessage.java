package com.example.demo.global.config;

import lombok.Data;

@Data
public class ResultMessage {

    /**
     * Return Code : 00
     * Result Code : 100
     * */
    public static final String RESULT_MESSAGE_100_00 = "Success";
    /**
     * Return Code : 01
     * Result Code : 00
     * */
    public static final String RESULT_MESSAGE_101_01 = "Validation Error";

    /**
     * Return Code : 01
     * Result Code : 00
     * */
    public static final String RESULT_MESSAGE_102_02 = "Authorization Error";

    /**
     * Return Code : 01
     * Result Code : 00
     * */
    public static final String RESULT_MESSAGE_103_03 = "DB Access Denied";




}
