package org.example.jobportal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public UserDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    private Long id;
    private String username;
    private String email;
    private String password;

}
