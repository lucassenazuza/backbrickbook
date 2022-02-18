package com.site.backbrickbook.model.dto;


import com.site.backbrickbook.model.UserSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAutheticatedDTO {

    private String email;
    private String name;
    private String token;
    private String type;
    public static UserAutheticatedDTO toDTO(UserSystem userSystem, String type) {


        return new UserAutheticatedDTO(userSystem.getEmail(), userSystem.getName(), userSystem.getToken(), type);
    }
}
