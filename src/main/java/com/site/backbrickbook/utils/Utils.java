package com.site.backbrickbook.utils;


import com.site.backbrickbook.config.BatchConfiguration;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;


public class Utils {

//    private  Logger logger = LogManager.getLogger(Utils.class);


    public void checkDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    public void deleteImage(String nameFile) throws IOException {
        Path folder = Paths.get(System.getProperty("user.dir"), "images_to_upload");
        Path path = Paths.get(folder.toString(), nameFile);
        File deleteFile = new File(path.toString());
        deleteFile.delete();
//        logger.info("Imagem Deletada");
    }
    public Path saveImage(MultipartFile imageFile, String nameFile) throws IOException, InterruptedException, TimeoutException {


//        String folder = BatchConfiguration.getProperty("app.path-images");
        Path folder = Paths.get(System.getProperty("user.dir"), "images_to_upload");
        checkDir(folder.toString());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder.toString(), nameFile);
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(path))) {
            out.write(bytes, 0, bytes.length);
            out.close();
            out.flush();

        } catch (IOException x) {
            System.err.println(x);
        }
        List listFiles = new ArrayList();
        listFiles = Arrays.asList(new File(folder.toString()).list());
        int count = 0;
        while(!listFiles.contains(nameFile)){
            Thread.sleep(1000);
            System.out.println("Aguardando escrever arquivos");
            if(count++ > 5){
                throw new TimeoutException("Não conseguiu gravar");
            }
        }
//        Path path = Paths.get(folder + "\\" + nameFile);
//        File newFile = new File(path.toString());
//        Files.write(bytes, newFile);
//        while(!newFile.exists()){
//            Thread.sleep(2000);
//            System.out.println("Esperando arquivo ser gravado");
//        }
//        logger.info("Imagem Salva");
            return path;
    }

}
