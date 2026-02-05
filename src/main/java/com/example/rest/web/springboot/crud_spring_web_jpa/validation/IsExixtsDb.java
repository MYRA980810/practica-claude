package com.example.rest.web.springboot.crud_spring_web_jpa.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { SkuProductValidation.class })
public @interface IsExixtsDb {
    String message() default "{IsExixtsDb.sku.id}";

    Class<?>[] groups() default { };

    Class<? extends jakarta.validation.Payload>[] payload() default { };

}
