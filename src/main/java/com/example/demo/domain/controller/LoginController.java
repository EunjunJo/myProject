package com.example.demo.domain.controller;


import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.Request;
import com.example.demo.domain.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> loginController(@RequestBody Request request) throws Exception {
        User re = loginService.login(request);

        return ResponseEntity.ok(re);
    }

}
