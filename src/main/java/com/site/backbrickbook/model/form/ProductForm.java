package com.site.backbrickbook.model.form;

import com.google.api.services.drive.model.File;
import com.site.backbrickbook.config.BatchConfiguration;
import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.repository.ProductRepository;
import com.site.backbrickbook.service.ProductService;
import com.site.backbrickbook.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
//import java.util.logging.Logger;

import static com.site.backbrickbook.drive.CreateGoogleFile.createGoogleFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {

    @Nullable
    private String nameSet;
    private String numberSet;
    @Nullable
    private Boolean complete;
    @Nullable
    private String description;
    @Nullable
    private Double value;

//    private final Logger LOGGER = Logger.getLogger( ProductForm.class.getName() );

    public Product converter(MultipartFile imageFile, ProductRepository productRepository) {
        Product product = new Product();
        String nameFile;
        Path path_file;
        Utils util = new Utils();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        product.setNameSet(this.nameSet);
        product.setNumberSet(this.numberSet);
        product.setDescription(this.description);
        product.setComplete(this.complete);
        product.setValue(this.value);
        productRepository.save(product);

        nameFile = "id_" + product.getId() + "_" + timeStamp + ".jpg";
        try {
            if (imageFile != null) {
                path_file = util.saveImage(imageFile, nameFile);


        product.setFile_name(nameFile);

//        LOGGER.info("Fazendo upload");

        java.io.File uploadFile = new java.io.File(path_file.toString());

        String driver_image_folder = BatchConfiguration.getProperty("app.drive-folder");
        File googleFile = createGoogleFile(driver_image_folder, "image/jpg", nameFile, uploadFile);

        util.deleteImage(imageFile, nameFile);
            }
        } catch (Exception exception) {
            System.out.println("erro...");

        }

        return product;
    }
}
