package com.site.backbrickbook.controller;


import com.site.backbrickbook.model.Image;
import com.site.backbrickbook.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/image")
@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestParam("imageFile") MultipartFile imageFile) {
        try{
            imageService.saveImage(imageFile);
        }catch (Exception exception) {
            System.out.println(exception.toString());
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{image_drive_id}")
    public ResponseEntity<?> getImage(@PathVariable String image_drive_id){

        return ResponseEntity.ok(imageService.getImage(image_drive_id));
    }

}
