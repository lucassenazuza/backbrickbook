package com.site.backbrickbook.service;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    UserRepository userRepository;

    public ProductDto addProduct(Product product){
        userRepository.save(product);
        return ProductDto(product)d;
    }
}
