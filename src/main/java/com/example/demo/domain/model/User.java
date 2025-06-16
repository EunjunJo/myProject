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

    private int admin;

    private boolean deleteFlag;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    public String getRole() {
        return this.admin == 1 ? String.valueOf(Role.ADMIN) : String.valueOf(Role.USER);
    }
}
