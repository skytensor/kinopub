package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.model.User;
import com.project.code.repository.MovieRepository;
import com.project.code.repository.UserRepository;
import com.project.code.service.CustomUserDetails;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public BookmarkController(
            MovieRepository movieRepository,
            UserRepository userRepository
    ) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @PostMapping("/add/{movieId}")
    public String addBookmark(@PathVariable Long movieId, Authentication authentication) {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();

        user.getBookmarks().add(movie);
        userRepository.save(user);

        return "redirect:/movies/" + movie.getSlug();

    }


}

