package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String create(Movie movie) {

        movieRepository.save(movie);

        return "redirect:/admin";

    }

    @GetMapping("/movies/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).orElseThrow());

        return "admin/edit";
    }

    @PostMapping("/movies/edit/{id}")
    public String edit(@PathVariable Long id, Movie updatedMovie) {
        Movie movie = movieRepository.findById(id).orElseThrow();

        movie.setTitle(updatedMovie.getTitle().strip());
        movie.setSlug(updatedMovie.getSlug().strip());
        movie.setDescription(updatedMovie.getDescription().strip());
        movie.setPosterUrl(updatedMovie.getPosterUrl().strip());
        movie.setBackdropUrl(updatedMovie.getBackdropUrl().strip());
        movie.setTrailerUrl(updatedMovie.getTrailerUrl().strip());
        movie.setYear(updatedMovie.getYear());
        movie.setCountry(updatedMovie.getCountry().strip());
        movie.setGenre(updatedMovie.getGenre().strip());
        movie.setTagline(updatedMovie.getTagline().strip());
        movie.setDirector(updatedMovie.getDirector().strip());
        movie.setScreenplay(updatedMovie.getScreenplay().strip());
        movie.setProducer(updatedMovie.getProducer().strip());
        movie.setCinematographer(updatedMovie.getCinematographer().strip());
        movie.setComposer(updatedMovie.getComposer().strip());
        movie.setProductionDesigner(updatedMovie.getProductionDesigner().strip());
        movie.setEditor(updatedMovie.getEditor().strip());
        movie.setBudget(updatedMovie.getBudget());
        movie.setUsaBoxOffice(updatedMovie.getUsaBoxOffice());
        movie.setAgeRating(updatedMovie.getAgeRating().strip());
        movie.setRuntime(updatedMovie.getRuntime());

        movieRepository.save(movie);

        return "redirect:/admin";
    }

    @PostMapping("/movies/delete/{id}")
    public String delete(@PathVariable Long id) {
        movieRepository.deleteById(id);

        return "redirect:/admin";
    }
}
