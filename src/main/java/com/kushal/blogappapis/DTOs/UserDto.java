package com.kushal.blogappapis.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 4, message = "Username must be greater than 4 characters")
    private String name;
    @Email(message = "email is not valid")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "password must be minimum of 3 chars and maximum of 10 chars")
    private String password;
    @NotEmpty
    private String about;

    public String getName() {
        return this.name;
    }

    public String getAbout() {
        return this.about;
    }

    public String getPassword() {
        return this.password;
    }

    public String  getEmail() {
        return this.email;
    }
}
