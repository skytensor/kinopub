package com.project.code.service;

import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class MovieService {

    private final MovieRepository repository;

    @Transactional
    public void deleteById(Long id) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм не найден"));

        repository.deleteBookmarksByMovieId(id);
        repository.deleteWatchedByMovieId(id);
        repository.delete(movie);
    }

    @Transactional
    public void deleteBySlug(String slug) {
        Movie movie = repository.findBySlug(slug);
        if (movie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм не найден");
        }

        deleteById(movie.getId());
    }

}
