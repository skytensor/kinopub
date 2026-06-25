package com.project.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterForm {

    @Size(min = 4, max = 10)
    private String login;

    @Email
    private String email;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,20}$", message = "Password must be alphanumeric and 8-20 characters long")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
