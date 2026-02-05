package com.example.rest.web.springboot.crud_spring_web_jpa.dto;

import com.example.rest.web.springboot.crud_spring_web_jpa.validation.IsExixtsDb;
import com.example.rest.web.springboot.crud_spring_web_jpa.validation.IsRequirer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Esta es una clase de DTO (Data Transfer Object) para manejar las solicitudes de 
// productos tiene que tener getter y setters para que funcione correctamente el Mapper
public class ProductRequest {

    @NotEmpty(message = "{NotEmpty.product.name}")
    @Size(min = 3, max = 20)
    private String name;

    @Min(value = 500, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @IsRequirer
    private String description;

    @IsExixtsDb
    private String sku;

    @NotEmpty
    private String category;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    

    

    
}
