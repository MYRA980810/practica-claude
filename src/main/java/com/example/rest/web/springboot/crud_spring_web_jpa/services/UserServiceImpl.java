package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Role;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.User;
import com.example.rest.web.springboot.crud_spring_web_jpa.exceptions.ResourceNotFoundException;
import com.example.rest.web.springboot.crud_spring_web_jpa.mapper.UserMapper;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.RoleRepository;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserResponse findAll(){
        return (UserResponse) userMapper.toResponseList((List<User>) userRepository.findAll());
    }

    @Override
    @Transactional
    public UserResponse create(UserRequest request) {
        
        Set<String> roleNames = new HashSet<>();
        roleNames.add("ROLE_USER");

        if (request.getAdmin()) {
           roleNames.add("ROLE_ADMIN");
        } 

        Set<Role> roles = new HashSet<Role>(roleRepository.findByNameIn(roleNames));

        if (roles.size() != roleNames.size()) {
            throw new IllegalStateException("Roles inválidos o inexistentes");
        }

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);

        return userMapper.toResponse(userRepository.save(user));
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
