package com.site.backbrickbook.model.form;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    @Nullable
    private String nameSet;
    @Nullable
    private long numberSet;
    @Nullable
    private Boolean complete;
    @Nullable
    private String description;
    @Nullable
    private Boolean available;
    @Nullable
    private MultipartFile imageFile;



    public Product converter(MultipartFile imageFile) {
        Product product = new Product();
        String nameFile = imageFile.getName() + "-" + java.time.LocalDate.now().toString();
        Utils util = new Utils();
        try {
            if(imageFile != null) {
                util.saveImage(imageFile, nameFile);
            }
        } catch (Exception exception) {
            System.out.println("erro...");
        }
        product.setNameSet(this.nameSet);
        product.setNumberSet(this.numberSet);
        product.setAvailable(this.available);
        product.setDescription(this.description);
        product.setComplete(this.complete);
        product.setFile_name(nameFile);

        return product;
    }
}
