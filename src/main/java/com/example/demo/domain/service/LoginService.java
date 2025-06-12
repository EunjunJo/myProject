package com.example.demo.domain.service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.Request;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    User login(Request request);
}
