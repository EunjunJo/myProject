package com.example.demo.domain.model.dto;


import com.example.demo.global.config.CommonDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistRequestDto {
    private String email;
    private String password;
    private String name;
    private int admin;
}
