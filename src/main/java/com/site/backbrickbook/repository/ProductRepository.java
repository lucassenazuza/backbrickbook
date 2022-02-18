package com.site.backbrickbook.repository;

import com.site.backbrickbook.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository  extends JpaRepository<Product, Long> {
}
