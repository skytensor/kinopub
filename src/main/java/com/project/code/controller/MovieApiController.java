package com.project.code.controller;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieApiController {
    private final MovieRepository movieRepository;

    public MovieApiController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Movie createMovie(@RequestBody Movie movie) {

        return movieRepository.save(movie);

    }

    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{slug}")
    public String deleteMovie(@PathVariable String slug) {
        movieRepository.deleteBySlug(slug);

        return "Movie deleted";
    }
}
