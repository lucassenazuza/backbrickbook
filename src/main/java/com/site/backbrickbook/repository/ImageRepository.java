package com.site.backbrickbook.repository;


import com.site.backbrickbook.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, Long> {
}
