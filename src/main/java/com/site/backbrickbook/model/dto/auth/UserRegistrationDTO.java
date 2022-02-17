package com.site.backbrickbook.model.dto.auth;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.site.backbrickbook.model.User;
import com.site.backbrickbook.model.UserSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
        UserSystem userSystem = new UserSystem();
        userSystem.setName(this.name);
        userSystem.setEmail(this.email);
        userSystem.setPassword(this.password);
        return userSystem;
    }
}
