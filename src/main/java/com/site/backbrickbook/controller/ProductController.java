package com.site.backbrickbook.controller;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.model.dto.ProductImageDTO;
import com.site.backbrickbook.model.form.ProductForm;
import com.site.backbrickbook.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(
            @RequestParam(value = "imageFile", required = false) MultipartFile imageFile, @RequestParam String nameSet,
            @RequestParam String numberSet,
            @RequestParam String complete,
            @RequestParam String description,
            @RequestParam String value) {
        ProductForm productForm = new ProductForm(nameSet, numberSet, Boolean.parseBoolean(complete), description, Double.parseDouble(value));

        return ResponseEntity.ok(productService.addProduct(imageFile, productForm));
    }

    @GetMapping("/{numberSet}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String numberSet){

        return ResponseEntity.ok(productService.getProduct(numberSet));
    }

}
