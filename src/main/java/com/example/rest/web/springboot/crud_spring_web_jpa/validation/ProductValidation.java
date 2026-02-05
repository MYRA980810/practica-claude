package com.example.rest.web.springboot.crud_spring_web_jpa.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.ProductRepository;

@Component
public class ProductValidation implements Validator{

    @Autowired
    private ProductRepository productRepository;

    // Validator for ProductRequest se declara la logica de validacion de la entidad
    // en este caso el dto ProductRequest a donde solo se aplicara la validacion
    // a el tipo que se asigna en este metodo
    @Override
    public boolean supports(Class<?> clazz) {
        return ProductRequest.class.isAssignableFrom(clazz);
    }

    //Dentro de el metodo validate se implementa la logica de validacion personalizada
    //en este caso el precio del producto debe ser mayor a cero
    //designando la logica de validacion en un metodo independiente como buena practica
    @Override
    public void validate(Object target, Errors errors) {
        ProductRequest productRequest = (ProductRequest) target;
        validatePrice(productRequest, errors);
    }

    private void validatePrice(ProductRequest productRequest, Errors errors){
        if(productRequest.getPrice() <= 0){
            errors.rejectValue("price", "product.price.invalid", "The price must be greater than zero.");
        }
    }

}
