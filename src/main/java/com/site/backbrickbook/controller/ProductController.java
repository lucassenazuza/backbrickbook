package com.site.backbrickbook.controller;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody Product product)
    {

        return ResponseEntity.ok(productService.addProduct(product));

    }
    @GetMapping("/{id}")
    public byte [] productImage(@PathVariable long id){
        return productService.getProductImage(id);
    }
    @GetMapping("/upload")
    public void upload(){
         productService.upload();
    }
}