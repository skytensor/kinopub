package com.project.code.controller;

import com.project.code.service.CustomUserDetails;
import com.project.code.service.UserMovieService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class ProfileController {

    private final UserMovieService userMovieService;

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal CustomUserDetails principal,
                          Model model) {

        UserMovieService.ProfileData data = userMovieService.getProfile(principal.getId());

        model.addAttribute("email", data.email());
        model.addAttribute("ratings", data.ratings());
        model.addAttribute("bookmarks", data.bookmarks());
        model.addAttribute("watchedMovies", data.watched());

        return "profile";
    }
}
