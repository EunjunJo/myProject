package com.example.demo.domain.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistRequestDto {
    private String email;
    private String password;
}
