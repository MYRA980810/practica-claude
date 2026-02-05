package com.example.rest.web.springboot.crud_spring_web_jpa.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.UserResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toEntity(UserRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(UserRequest request, @MappingTarget User entity);

    UserResponse toResponse(User entity);

    List<UserResponse> toResponseList(List<User> entities);
}
