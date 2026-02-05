package com.example.rest.web.springboot.crud_spring_web_jpa.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.ProductRepository;

import jakarta.validation.ConstraintValidator;

@Component
public class SkuProductValidation implements ConstraintValidator<IsExixtsDb, String> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public boolean isValid(String sku, jakarta.validation.ConstraintValidatorContext context) {
       return sku != null && !productRepository.existsBySku(sku);
    }

}
