package com.example.rest.web.springboot.crud_spring_web_jpa.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.RoleResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "users", ignore = true)
    Role toEntity(RoleRequest request);

    RoleResponse toResponse(Role entity);

    List<RoleResponse> toResponseList(List<Role> entities);

    Set<RoleResponse> toResponseSet(Set<Role> entities);
}
