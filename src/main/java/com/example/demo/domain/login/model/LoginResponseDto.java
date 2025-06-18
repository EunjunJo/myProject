package com.example.demo.domain.login.model;

import com.example.demo.global.common.CommonDto;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String email;
    private String password;
    private String username;
    private int seqNumber;
    private String token;
    @JsonUnwrapped
    private CommonDto commonDto;
}
