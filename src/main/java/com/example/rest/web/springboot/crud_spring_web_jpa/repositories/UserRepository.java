package com.example.rest.web.springboot.crud_spring_web_jpa.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.rest.web.springboot.crud_spring_web_jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
