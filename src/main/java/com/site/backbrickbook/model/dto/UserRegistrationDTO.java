package com.site.backbrickbook.model.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.common.hash.Hashing;
import com.site.backbrickbook.model.UserSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.util.text.AES256TextEncryptor;

import java.nio.charset.StandardCharsets;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserRegistrationDTO extends UserSystem {

    private Long id;

    private String name;
    private String email;
    private String password;

    public UserSystem converter() {
//        String passwordEncrypted = org.apache.commons.codec.digest.DigestUtils.sha256Hex(this.password);
        AES256TextEncryptor aesEncryptor = new AES256TextEncryptor();
        aesEncryptor.setPassword(this.password);
        String encryptedPassword = aesEncryptor.encrypt(this.password);
        UserSystem userSystem = new UserSystem();
        userSystem.setName(this.name);
        userSystem.setEmail(this.email);
        userSystem.setPassword(encryptedPassword);
        return userSystem;
    }
}
