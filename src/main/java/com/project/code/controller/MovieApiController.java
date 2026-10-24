package com.project.code.controller;

import com.project.code.dto.MovieForm;
import com.project.code.mapper.MovieMapper;
import com.project.code.model.Movie;
import com.project.code.repository.MovieRepository;
import com.project.code.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieApiController {
    private final MovieRepository repository;
    private final MovieService service;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Long>> createMovie(@Valid @RequestBody MovieForm form) {

        if (repository.existsBySlug(form.getSlug())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Фильм с таким slug уже существует");
        }

        Movie saved = repository.save(MovieMapper.toNewMovie(form));

        URI location = UriComponentsBuilder.fromPath("/movies/{slug}")
                .buildAndExpand(saved.getSlug())
                .encode()
                .toUri();

        return ResponseEntity.created(location).body(Map.of("id", saved.getId()));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{slug}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String slug) {
        service.deleteBySlug(slug);
        return ResponseEntity.noContent().build();
    }
}
