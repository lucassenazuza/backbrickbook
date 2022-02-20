package com.site.backbrickbook.service;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.model.form.ProductForm;
import com.site.backbrickbook.repository.ProductRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Environment environment;

    public ProductDto addProduct(MultipartFile imageFile, ProductForm productForm) {
        Product product = productForm.converter(imageFile);
        productRepository.save(product);

        return product.converte();
    }

}
