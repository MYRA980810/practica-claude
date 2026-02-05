package com.example.rest.web.springboot.crud_spring_web_jpa.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductUpdateResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Product;
import com.example.rest.web.springboot.crud_spring_web_jpa.services.ServicesRepositoryImpl;
import com.example.rest.web.springboot.crud_spring_web_jpa.validation.ProductValidation;

import jakarta.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductValidation productValidation;

    ProductController(ProductValidation productValidation) {
        this.productValidation = productValidation;
    }

    @InitBinder("productRequest")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(productValidation);
    }

    @Autowired
    private ServicesRepositoryImpl produtServices;

    @GetMapping
    public List<Product> list() {
        return produtServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
      return ResponseEntity.ok(produtServices.finfById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create( @Valid @RequestBody ProductRequest product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtServices.create(product));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductUpdateResponse product) {
       return ResponseEntity.ok(produtServices.update(id, product));
    }
 
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(produtServices.delete(id));
    }

}
