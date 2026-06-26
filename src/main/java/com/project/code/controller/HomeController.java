package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final MovieRepository movieRepository;

    public HomeController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        Page<Movie> movies = movieRepository.findAll(PageRequest.of(0, 14, Sort.by("year").descending()));

        model.addAttribute("movies", movies);

        return "index";
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam String query,
            Model model) {

        Page<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(query, PageRequest.of(page, 20));

        model.addAttribute("movies", movies.getContent());
        model.addAttribute("query", query);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", movies.getTotalPages());

        return "search";
    }

    @GetMapping("/movies")
    public String movies(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Movie> moviesPage = movieRepository.findAll(PageRequest.of(page, 20, Sort.by("year").descending()));

        model.addAttribute("movies", moviesPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", moviesPage.getTotalPages());

        return "allMovies";
    }
}
