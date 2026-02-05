package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Role;
import com.example.rest.web.springboot.crud_spring_web_jpa.exceptions.ResourceNotFoundException;
import com.example.rest.web.springboot.crud_spring_web_jpa.mapper.RoleMapper;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    @Transactional
    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toEntity(request);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toResponse(savedRole);
    }

    @Override
    @Transactional
    public RoleResponse update(Integer id, RoleRequest request) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        role.setName(request.getName());
        return roleMapper.toResponse(roleRepository.save(role));
    }
}
