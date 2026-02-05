package com.example.rest.web.springboot.crud_spring_web_jpa.dto;

public class UserResponse {
    private String username;
    private Boolean enable;
    
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

    
}
