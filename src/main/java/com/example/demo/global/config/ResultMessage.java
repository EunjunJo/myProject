package com.example.demo.global.config;

import lombok.Data;

@Data
public class ResultMessage {

    /**
     * Return Code : 00
     * Result Code : 100
     * */
    public static final String RESULT_MESSAGE_100_00 = "성공";
    /**
     * Return Code : 01
     * Result Code : 101
     * */
    public static final String RESULT_MESSAGE_101_01 = "이름을 2~4자 사이로 작성해주세요.";

    /**
     * Return Code : 02
     * Result Code : 102
     * */
    public static final String RESULT_MESSAGE_102_02 = "권한 없음";

    /**
     * Return Code : 03
     * Result Code : 103
     * */
    public static final String RESULT_MESSAGE_103_03 = "DB 접근 거부";

    /**
     * Return Code : 04
     * Result Code : 104
     * */
    public static final String RESULT_MESSAGE_104_04 = "비밀번호는 최소 8자부터 최대 25자까지 입력해주세요.";

    /**
     * Return Code : 05
     * Result Code : 105
     * */
    public static final String RESULT_MESSAGE_105_05 = "이메일은 10자부터 30자 이내로 작성해주세요.";

}
