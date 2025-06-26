package com.example.demo.domain.register.controller;


import com.example.demo.domain.login.model.LoginResponseDto;
import com.example.demo.domain.login.service.LoginService;
import com.example.demo.domain.register.model.User;
import com.example.demo.domain.register.model.dto.UserDto;
import com.example.demo.domain.register.service.RegisterService;
import com.example.demo.global.Exception.CommonDtoFactory;
import com.example.demo.global.common.CommonDto;
import com.example.demo.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/getMember")
public class MemberController {

    private final JwtUtil jwtUtil;
    private final RegisterService registerService;

    @GetMapping
    public UserDto getMember(@RequestHeader("Authorization") String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            UserDto userDto = new UserDto();
            userDto.setEmail(null);
            userDto.setPassword(null);
            userDto.setName(null);
            userDto.setCommonDto(CommonDtoFactory.authorizationError());
            return userDto;
        }

        String token = authHeader.replace("Bearer ", "").trim();

        if (!jwtUtil.validateToken(token)) {
            UserDto userDto = new UserDto();
            userDto.setEmail(null);
            userDto.setPassword(null);
            userDto.setName(null);
            userDto.setCommonDto(CommonDtoFactory.authorizationError());
            return userDto;
        }
        String email = jwtUtil.extractUsername(token);

        UserDto member = registerService.findByEmail(email);

        if (member == null) {
            UserDto userdto = new UserDto();
            userdto.setCommonDto(CommonDtoFactory.existUser());
            return userdto;
        }
        member.setCommonDto(CommonDtoFactory.success());
        return member;
    }
}
