package com.example.demo.domain.model.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private String email;
    private String password;
}
