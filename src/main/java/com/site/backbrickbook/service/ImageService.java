package com.site.backbrickbook.service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.FileList;
import com.site.backbrickbook.drive.GoogleDriveUtils;
import com.site.backbrickbook.model.Image;
import com.site.backbrickbook.repository.ImageRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;

    public ResponseEntity<?> saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/home/lucas/Documents/legos/images";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
        return ResponseEntity.ok().build();
    }

    public Object getImage(String image_drive_id) throws IOException{
        String pageToken = null;
        Drive driveService = GoogleDriveUtils.getDriveService();
        do {
            FileList result = driveService.files().list()
                    .setQ("mimeType='image/jpeg'")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            result.getFiles().stream().map( file -> {
                return System.out.printf("Found file: %s (%s)\n",
                        file.getName(), file.getId());
            });
            pageToken = result.getNextPageToken();
        } while (pageToken != null);

    return null;
    }
}
