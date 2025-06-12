package com.example.demo.global.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonDto {

    private String ResultCode;

    private String ReturnCode;

    private String ResultMessage;
}
