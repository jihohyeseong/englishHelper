package com.example.englishHelper.dto;

import com.example.englishHelper.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String role;

    public static UserDto toDto(User newUser) {

        return new UserDto(
                newUser.getId(),
                newUser.getUsername(),
                newUser.getPassword(),
                newUser.getRole()
        );
    }
}
