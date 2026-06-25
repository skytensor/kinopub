package com.project.code.controller;

import com.project.code.dto.MovieForm;
import com.project.code.mapper.MovieMapper;
import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieRepository movieRepository;

    public AdminController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("movies", movieRepository.findAll());

        return "admin/index";
    }

    @GetMapping("/movies/new")
    public String createPage() {
        return "admin/create";
    }

    @PostMapping("/movies/new")
    public String create(@Valid MovieForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/create";
        }

        Movie movie = MovieMapper.toNewMovie(form);
        movieRepository.save(movie);

        return "redirect:/admin";

    }

    @GetMapping("/movies/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).orElseThrow());

        return "admin/edit";
    }

    @PostMapping("/movies/edit/{id}")
    public String edit(@PathVariable Long id, MovieForm movieForm) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        MovieMapper.applyForm(movie, movieForm);
        movieRepository.save(movie);

        return "redirect:/admin";
    }

    @PostMapping("/movies/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieRepository.deleteById(id);

        return "redirect:/admin";
    }
}
