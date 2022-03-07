package com.site.backbrickbook.repository;

import com.site.backbrickbook.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository  extends JpaRepository<Product, Long> {
        List<Product> findByNumberSet(String numberSet);
}
