package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleResponse;

public interface RoleService {
    RoleResponse create(RoleRequest request);
    RoleResponse update(Integer id, RoleRequest request);
}
