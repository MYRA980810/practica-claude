package com.example.rest.web.springboot.crud_spring_web_jpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
    boolean existsByName(String name);
}
