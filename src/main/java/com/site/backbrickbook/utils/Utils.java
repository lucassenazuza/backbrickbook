package com.site.backbrickbook.utils;


import com.site.backbrickbook.config.BatchConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Utils {

    public void checkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public Path saveImage(MultipartFile imageFile, String nameFile) throws IOException {


//        String folder = BatchConfiguration.getProperty("app.path-images");
        Path folder = Paths.get(System.getProperty("user.dir"), "images_to_upload");
        checkDir(folder.toString());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + "\\" + nameFile +".jpg");
        Files.write(path, bytes);
        return path;
    }

}
