package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import java.util.List;


import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductUpdateResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Product;

public interface ServicesRepositoty {

    List<Product> findAll();
    ProductResponse finfById(Long id);
    Product save(Product product);
    ProductResponse delete(Long id);
    ProductResponse update(Long id, ProductUpdateResponse request);
    ProductResponse create(ProductRequest productRequest);
    boolean existsBySku(String sku);
}
