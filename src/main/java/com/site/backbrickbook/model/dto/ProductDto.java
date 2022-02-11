package com.site.backbrickbook.model.dto;

import com.site.backbrickbook.model.Product;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

public class ProductDto {

    private long id;
    private String nameSet;

    public ProductDto(Product product){
        this.id = product.getId();
        this.nameSet = product.getNameSet();
    }
}


