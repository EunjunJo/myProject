package com.example.demo.domain.register.model;

import com.example.demo.domain.register.model.enums.Role;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private int seqNumber;

    private String email;

    private String password;

    private String name;

    private boolean deleteFlag;

    private int isAdmin;

    private LocalDate createDate;

    private LocalDate updateDate;

    public Role getRole(){
        return isAdmin==1? Role.ADMIN : Role.USER;
    }
}
