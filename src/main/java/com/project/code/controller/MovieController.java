package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies/{slug}")
    public String getMovie(@PathVariable String slug, Model model) {

        Movie movie = movieRepository.findBySlug(slug);
        if (movie == null) return "error";

        model.addAttribute("movie", movie);

        return "movie";
    }
}
