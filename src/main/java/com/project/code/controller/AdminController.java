package com.project.code.controller;

import com.project.code.dto.MovieForm;
import com.project.code.mapper.MovieMapper;
import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import com.project.code.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MovieRepository movieRepository;
    private final MovieService service;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("movies", movieRepository.findAll());

        return "admin/index";
    }

    @GetMapping("/movies/new")
    public String createPage(Model model) {
        model.addAttribute("movieForm", new MovieForm());
        return "admin/create";
    }

    @PostMapping("/movies/new")
    public String create(@Valid @ModelAttribute("movieForm") MovieForm form, BindingResult result) {
        if (!result.hasFieldErrors("slug") && movieRepository.existsBySlug(form.getSlug())) {
            result.rejectValue("slug", "duplicate", "Фильм с таким slug уже существует");
        }

        if (result.hasErrors()) {
            return "admin/create";
        }

        movieRepository.save(MovieMapper.toNewMovie(form));
        return "redirect:/admin";
    }

    @GetMapping("/movies/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        Movie movie = findOr404(id);

        model.addAttribute("movieId", id);
        model.addAttribute("movieForm", MovieMapper.toForm(movie));

        return "admin/edit";
    }

    @PostMapping("/movies/edit/{id}")
    public String edit(@PathVariable Long id,
                       @Valid @ModelAttribute("movieForm") MovieForm form,
                       BindingResult result,
                       Model model) {

        Movie movie = findOr404(id);

        if (!result.hasFieldErrors("slug") && movieRepository.existsBySlugAndIdNot(form.getSlug(), id)) {
            result.rejectValue("slug", "duplicate", "Фильм с таким slug уже существует");
        }
        if (result.hasErrors()) {
            model.addAttribute("movieId", id);
            return "admin/edit";
        }

        MovieMapper.applyForm(movie, form);
        movieRepository.save(movie);

        return "redirect:/admin";
    }

    @PostMapping("/movies/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);

        return "redirect:/admin";
    }

    private Movie findOr404(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм не найден"));
    }
}
