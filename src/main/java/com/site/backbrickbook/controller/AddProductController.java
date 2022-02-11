package com.site.backbrickbook.controller;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/addProduct")
@RestController
public class AddProductController {
    @Autowired
    private addProductService addProductService;



    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product){

            return addProductService.addProduct(product);

    }

}