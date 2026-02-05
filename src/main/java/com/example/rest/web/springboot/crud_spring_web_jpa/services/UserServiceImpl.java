package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.User;
import com.example.rest.web.springboot.crud_spring_web_jpa.exceptions.ResourceNotFoundException;
import com.example.rest.web.springboot.crud_spring_web_jpa.mapper.UserMapper;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserResponse create(UserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    @Transactional
    public UserResponse update(Integer id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        userMapper.updateFromRequest(request, user);
        return userMapper.toResponse(userRepository.save(user));
    }
}
