package com.site.backbrickbook.service;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDto addProduct(Product product) {

        productRepository.save(product);

        return product.converte();
    }

}
