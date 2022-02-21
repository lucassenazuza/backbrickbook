package com.site.backbrickbook.model.form;

import com.site.backbrickbook.model.Product;
import com.site.backbrickbook.repository.ProductRepository;
import com.site.backbrickbook.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {
    @Nullable
    private String nameSet;
    private long numberSet;
    @Nullable
    private Boolean complete;
    @Nullable
    private String description;
    @Nullable
    private MultipartFile imageFile;
    @Nullable
    private Double value;

    public Product converter(MultipartFile imageFile, ProductRepository productRepository) {
        Product product = new Product();
        String nameFile;

        Utils util = new Utils();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        product.setNameSet(this.nameSet);
        product.setNumberSet(this.numberSet);
        product.setDescription(this.description);
        product.setComplete(this.complete);
        product.setValue(this.value);
        productRepository.save(product);

        nameFile = "id_" + product.getId() + "_" + timeStamp;
        try {
            if (imageFile != null) {
                util.saveImage(imageFile, nameFile);
            }
        } catch (Exception exception) {
            System.out.println("erro...");
        }
        product.setFile_name(nameFile);

        return product;
    }
}
