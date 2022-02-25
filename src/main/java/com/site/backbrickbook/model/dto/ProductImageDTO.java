package com.site.backbrickbook.model.dto;


import com.site.backbrickbook.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageDTO {

    private Product product;
    private MultipartFile multipartFile;

}
