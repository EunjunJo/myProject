package com.example.demo.global.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDto {

    private String ResultCode;

    private String ReturnCode;

    private String ResultMessage;
}
