package com.project.code.controller;

import com.project.code.dto.RegisterForm;
import com.project.code.model.User;
import com.project.code.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @Valid
            @ModelAttribute("registerForm") RegisterForm form,
            BindingResult result) {

        if (!result.hasFieldErrors("password")
                && form.getPassword().getBytes(StandardCharsets.UTF_8).length > 72) {
            result.rejectValue("password", "tooLong", "Пароль слишком длинный (до 72 байт, кириллица — по 2)");
        }

        if (!result.hasFieldErrors("password") && !result.hasFieldErrors("confirmPassword") &&
            !form.getPassword().equals(form.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "mismatch", "Пароли не совпадают");
        }

        if (!result.hasFieldErrors("login") && userRepository.existsByLogin(form.getLogin().strip())) {
            result.rejectValue("login", "duplicate", "Этот логин уже занят");
        }

        String email = form.getEmail() == null ? null : form.getEmail().strip().toLowerCase(Locale.ROOT);
        if (!result.hasFieldErrors("email") && userRepository.existsByEmail(email)) {
            result.rejectValue("email", "duplicate", "Эта почта уже зарегистрирована");
        }

        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setLogin(form.getLogin().strip());
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setRole("USER");

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            result.reject("duplicate", "Логин или почта уже заняты");
            return "register";
        }

        return "redirect:/login";
    }

}
