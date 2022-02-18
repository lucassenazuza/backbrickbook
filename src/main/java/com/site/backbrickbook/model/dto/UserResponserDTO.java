package com.site.backbrickbook.model.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UserResponserDTO {

    private Long id;

    private String name;
    private String email;
    private String password;
}
