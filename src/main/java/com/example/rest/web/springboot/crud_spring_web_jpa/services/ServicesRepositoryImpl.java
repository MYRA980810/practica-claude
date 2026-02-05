package com.example.rest.web.springboot.crud_spring_web_jpa.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductRequest;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.dto.ProductUpdateResponse;
import com.example.rest.web.springboot.crud_spring_web_jpa.entities.Product;
import com.example.rest.web.springboot.crud_spring_web_jpa.exceptions.ResourceNotFoundException;
import com.example.rest.web.springboot.crud_spring_web_jpa.mapper.ProductMapper;
import com.example.rest.web.springboot.crud_spring_web_jpa.repositories.ProductRepository;


@Service
public class ServicesRepositoryImpl implements ServicesRepositoty{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return (List<Product>) productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse finfById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id:" + id));
        return productMapper.toResponse(product);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public ProductResponse delete(Long id) {
      Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id:" + id));
      productRepository.delete(product);
      return productMapper.toResponse(product);

    }

    @Override
    @Transactional
    public ProductResponse create(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional
    public ProductResponse update(Long id, ProductUpdateResponse request){
       Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id:" + id));
       productMapper.updateFromUpdateResponse(request, product);
       return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku) {
        return productRepository.existsBySku(sku);
    }

}
