package com.example.demo.domain.model;


import com.example.demo.domain.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String email;

    private String password;

    private String name;

    private boolean deleteFlag;

    private int admin;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public Role getRole(){
        return admin==1? Role.ADMIN : Role.USER;
    }
}
