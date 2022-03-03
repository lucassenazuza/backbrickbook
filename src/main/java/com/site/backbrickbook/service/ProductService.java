package com.site.backbrickbook.service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.site.backbrickbook.controller.AuthenticationController;
import com.site.backbrickbook.drive.GoogleDriveUtils;
import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.model.dto.ProductDto;
import com.site.backbrickbook.model.dto.ProductImageDTO;
import com.site.backbrickbook.model.form.ProductForm;
import com.site.backbrickbook.repository.ProductRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import java.awt.*;

import static com.site.backbrickbook.drive.CreateGoogleFile.createGoogleFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    Environment environment;

//    private final Logger LOGGER = Logger.getLogger( ProductService.class.getName() );


//    public ProductImageDTO getProduct(){
//        String numberSet= "234234";
//        Product product = productRepository.findbyNumberSet(numberSet);
//        ProductImageDTO productImageDTO = new ProductImageDTO();
//
//        try {
//            Drive driveService = GoogleDriveUtils.getDriveService();
//            String pageToken = null;
//            do {
//                FileList result = driveService.files().list()
//                        .setQ("mimeType='image/jpeg'")
//                        .setSpaces("drive")
//                        .setFields("nextPageToken, files(id, name)")
//                        .setPageToken(pageToken)
//                        .execute();
//                for (File file : result.getFiles()) {
//                    System.out.printf("Found file: %s (%s)\n",
//                            file.getName(), file.getId());
//                }
//                pageToken = result.getNextPageToken();
//            } while (pageToken != null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        MultipartFile multipartFile;
////        productImageDTO.create(product, multipartFile);
//
//        return null;
//    }
    public ProductDto addProduct(MultipartFile imageFile, ProductForm productForm) {

        Product product = productForm.converter(imageFile, productRepository);
        productRepository.save(product);

        return product.converte();
    }

    public byte[] getProductImage(long id) {

        String product_pic = productRepository.getById(id).getFile_name().toString();
        product_pic = product_pic.replaceFirst("^data:image/[^;]*;base64,?","");
        byte[] bytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(product_pic);
        return bytes;
    }

    public void upload() {
        java.io.File uploadFile = new java.io.File("C:\\Users\\Lucas\\Downloads\\lego_imperial.png");

        // Create Google File:
        try {
            File googleFile = createGoogleFile("1MrM8F9sZ6si3IDxEkSeMc-5AFxKh7tMB", "image/jpeg", "teste.png", uploadFile);

//            LOGGER.info("Created Google file!");
//            LOGGER.info("WebContentLink: " + googleFile.getWebContentLink());
//            LOGGER.info("WebViewLink: " + googleFile.getWebViewLink());

            System.out.println("Done!");
        }catch (Exception ex){
//            LOGGER.severe("Error...");

        }
    }
}
