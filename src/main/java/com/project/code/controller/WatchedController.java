package com.project.code.controller;

import com.project.code.service.CustomUserDetails;
import com.project.code.service.UserMovieService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class WatchedController {

    private final UserMovieService userMovieService;

    @PostMapping("/movies/watch/{movieId}")
    public String watch(@PathVariable Long movieId,
                        @AuthenticationPrincipal CustomUserDetails principal) {

        String slug = userMovieService.markWatched(principal.getId(), movieId);
        return "redirect:/movies/" + slug;

    }

}
