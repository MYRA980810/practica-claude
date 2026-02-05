package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserResponse;

public interface UserService {
    UserResponse create(UserRequest request);
    UserResponse update(Integer id, UserRequest request);
}
