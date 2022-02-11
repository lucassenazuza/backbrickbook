package com.site.backbrickbook.model.dto.auth;


import com.site.backbrickbook.model.User;
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
    public static UserAutheticatedDTO toDTO(User user, String type) {


        return new UserAutheticatedDTO(user.getEmail(), user.getName(), user.getToken(), type);
    }
}
