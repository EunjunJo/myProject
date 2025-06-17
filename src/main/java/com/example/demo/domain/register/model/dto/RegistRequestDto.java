package com.example.demo.domain.register.model.dto;

import java.time.LocalDateTime;
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

    private int isAdmin;

    private boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

}
