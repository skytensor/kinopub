package com.project.code.controller;

import com.project.code.service.CustomUserDetails;
import com.project.code.service.UserMovieService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

    private final UserMovieService userMovieService;

    @PostMapping("/add/{movieId}")
    public String addBookmark(@PathVariable Long movieId,
                              @AuthenticationPrincipal CustomUserDetails principal) {

        String slug = userMovieService.addBookmark(principal.getId(), movieId);
        return "redirect:/movies/" + slug;

    }
}

