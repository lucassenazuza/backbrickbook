package com.site.backbrickbook.service;

import com.google.api.services.drive.model.File;
import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

import static com.site.backbrickbook.drive.CreateGoogleFile.createGoogleFile;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDto addProduct(Product product) {

        productRepository.save(product);

        return product.converte();
    }

    public byte[] getProductImage(long id) {

        String product_pic = productRepository.getById(id).getImage().toString();
        product_pic = product_pic.replaceFirst("^data:image/[^;]*;base64,?","");
        byte[] bytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(product_pic);
        return bytes;
    }

    public void upload() {
        java.io.File uploadFile = new java.io.File("C:\\Users\\Lucas\\Downloads\\lego_imperial.png");

        // Create Google File:
        try {
            File googleFile = createGoogleFile("1MrM8F9sZ6si3IDxEkSeMc-5AFxKh7tMB", "image/jpeg", "teste.png", uploadFile);

            System.out.println("Created Google file!");
            System.out.println("WebContentLink: " + googleFile.getWebContentLink());
            System.out.println("WebViewLink: " + googleFile.getWebViewLink());

            System.out.println("Done!");
        }catch (Exception ex){

        }
    }
}
