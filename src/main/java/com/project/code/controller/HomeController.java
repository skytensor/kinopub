package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final MovieRepository movieRepository;

    public HomeController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Movie> movies = movieRepository.findAll();

        model.addAttribute("movies", movies);

        return "index";
    }
}
