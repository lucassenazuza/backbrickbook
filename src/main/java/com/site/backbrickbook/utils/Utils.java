package com.site.backbrickbook.utils;


import com.site.backbrickbook.config.BatchConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



public class Utils {

    private  Logger logger = LogManager.getLogger(Utils.class);


    public void checkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    public void deleteImage(MultipartFile imageFile, String nameFile) throws IOException {
        Path folder = Paths.get(System.getProperty("user.dir"), "images_to_upload");
        Path path = Paths.get(folder + "\\" + nameFile);
        Files.delete(path);
        logger.info("Imagem Deletada");
    }
    public Path saveImage(MultipartFile imageFile, String nameFile) throws IOException {


//        String folder = BatchConfiguration.getProperty("app.path-images");
        Path folder = Paths.get(System.getProperty("user.dir"), "images_to_upload");
        checkDir(folder.toString());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + "\\" + nameFile);
        Files.write(path, bytes);
        logger.info("Imagem Salva");
        return path;
    }

}
