package com.project.code.controller;

import com.project.code.model.User;
import com.project.code.repository.UserRepository;
import com.project.code.service.CustomUserDetails;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserRepository userRepository;

    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow();

        model.addAttribute("email", user.getEmail());
        model.addAttribute("ratings", user.getRatings());
        model.addAttribute("bookmarks", user.getBookmarks());
        model.addAttribute("watchedMovies", user.getWatchedMovies());

        return "profile";

    }

}
