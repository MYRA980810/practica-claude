package com.example.rest.web.springboot.crud_spring_web_jpa.dto;

import java.util.Set;

public class UserResponse {
    private Integer id;
    private String username;
    private Boolean enable;
    private Set<RoleResponse> roles;
    private Boolean admin;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Boolean getEnable() {
        return enable;
    }
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Boolean getAdmin() {
        return admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    public Set<RoleResponse> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleResponse> roles) {
        this.roles = roles;
    }

    

    

    
}
