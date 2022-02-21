package com.site.backbrickbook.utils;


import com.site.backbrickbook.config.BatchConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Utils  {

    public  void checkDir(String path){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    public void saveImage(MultipartFile imageFile, String nameFile) throws IOException {



        String folder = BatchConfiguration.getProperty("app.path-images");
        checkDir(folder);
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + nameFile);
        Files.write(path, bytes);
    }

}
