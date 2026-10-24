package com.project.code.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {

    @NotBlank(message = "Введите логин")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "Логин: латиница, цифры и _")
    @Size(min = 4, max = 10, message = "Логин: от 4 до 10 символов")
    private String login;

    @NotBlank(message = "Введите почту")
    @Email(message = "Некорректная почта")
    private String email;

    @NotBlank(message = "Введите пароль")
    @Size(min = 8, max = 64, message = "Пароль: от 8 до 64 символов")
    private String password;

    @NotBlank(message = "Повторите пароль")
    private String confirmPassword;

}
