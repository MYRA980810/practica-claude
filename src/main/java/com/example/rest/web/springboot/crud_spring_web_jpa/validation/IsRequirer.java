package com.example.rest.web.springboot.crud_spring_web_jpa.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//Esta representa a que camppo se va a poder aplicar en este caso a un campo o a un metodo
@Target({ElementType.FIELD, ElementType.METHOD})
//Esta indica que la anotacion va a estar disponible en tiempo de ejecucion
@Retention(RetentionPolicy.RUNTIME)
//Esta indica que esta anotacion es una restriccion de validacion 
// y se especifica el validador que se va a usar
@Constraint(validatedBy = UniqueProductNameValidator.class)
public @interface IsRequirer {
    String message() default "{IsRequirer.product.description}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
