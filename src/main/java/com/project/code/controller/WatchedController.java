package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.model.User;
import com.project.code.repository.MovieRepository;
import com.project.code.repository.UserRepository;
import com.project.code.service.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WatchedController {

    private final MovieRepository movieRepository;
    private final UserRepository userRepository;

    public WatchedController(
            MovieRepository movieRepository,
            UserRepository userRepository
    ) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/movies/watch/{movieId}")
    public String watch(@PathVariable Long movieId, Authentication authentication) {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        User user = userRepository.findById(userDetails.getUser().getId()).orElseThrow();
        Movie movie = movieRepository.findById(movieId).orElseThrow();

        user.getWatchedMovies().add(movie);
        userRepository.save(user);

        return "redirect:/movies/" + movie.getSlug();

    }

}
