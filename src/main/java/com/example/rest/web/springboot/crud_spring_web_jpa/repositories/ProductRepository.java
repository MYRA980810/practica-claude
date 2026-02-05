package com.example.rest.web.springboot.crud_spring_web_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
    boolean existsBySku(String sku);
}
