package com.site.backbrickbook.model;


import com.site.backbrickbook.model.dto.ProductDto;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product_set")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameSet;
    private long numberSet;
    private Boolean complete;
    private String description;
    LocalDateTime dateInsertion = LocalDateTime.now();
    @Nullable
    LocalDateTime dateLastUpdate;
    private Boolean available;
    @Nullable
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    public ProductDto converte(){
        return new ProductDto(this.id, this.nameSet, this.numberSet, this.complete);
    }


//    @Lob
//    @Column(name="product_img")
//    private byte[] productPic;

}
