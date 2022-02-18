package com.site.backbrickbook.model.dto;

import com.site.backbrickbook.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;
    private String nameSet;
    private long numberSet;
    private Boolean complete;

}


