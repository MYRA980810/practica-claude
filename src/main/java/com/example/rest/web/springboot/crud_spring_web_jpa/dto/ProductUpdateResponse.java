package com.example.rest.web.springboot.crud_spring_web_jpa.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ProductUpdateResponse {
    @Size(min = 3, max = 20)
    private String name;

    @Min(value = 500, message = "{Min.product.price}")
    private Integer price;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}
