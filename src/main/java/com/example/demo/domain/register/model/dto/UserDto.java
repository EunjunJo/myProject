package com.example.demo.domain.register.model.dto;


import com.example.demo.global.common.CommonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String name;

    private CommonDto commonDto;
}
