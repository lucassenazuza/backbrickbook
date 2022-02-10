package com.site.backbrickbook.model;


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
    @Nullable
    @Enumerated(EnumType.ORDINAL)
    private Theme theme;
    @Nullable
    private String setName;
    @Nullable
    private long setNumber;
    @Nullable
    private Boolean complete;
    @Nullable
    private String description;
    LocalDateTime dateInsertion = LocalDateTime.now();
    @Nullable
    LocalDateTime dateLastUpdate;
    @Nullable
    private Boolean available;
    @Nullable
    @Lob
    @Column(name="product_img")
    private byte[] productPic;

}
