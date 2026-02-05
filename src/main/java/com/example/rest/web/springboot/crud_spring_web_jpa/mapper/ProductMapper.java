package com.example.rest.web.springboot.crud_spring_web_jpa.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductUpdateResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    
    //Con esto le indicamos que no mapee el id ya que este es generado automaticamente
    //se pueden ignoarar las propiedades que sean necesarias usando la misma sintaxis
    @Mapping(target = "id", ignore = true)
     Product toEntity(ProductRequest request);

     @Mapping(target = "id", ignore = true)
     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
     void updateFromUpdateResponse(ProductUpdateResponse request, @MappingTarget Product entity);

     ProductResponse toResponse(Product entity);

     List<ProductResponse> toResponseList(List<Product> entities);
}
