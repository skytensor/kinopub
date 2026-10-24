package com.project.code.service;

import com.project.code.model.Movie;
import com.project.code.model.User;
import com.project.code.repository.MovieRepository;
import com.project.code.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class UserMovieService {

    public record ProfileData(String email, int ratings, List<Movie> bookmarks, List<Movie> watched) {}

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public String addBookmark(Long userId, Long movieId) {
        User user = findUser(userId);
        Movie movie = findMovie(movieId);
        user.getBookmarks().add(movie);
        return movie.getSlug();
    }

    @Transactional
    public String markWatched(Long userId, Long movieId) {
        User user = findUser(userId);
        Movie movie = findMovie(movieId);
        user.getWatchedMovies().add(movie);
        return movie.getSlug();
    }

    @Transactional
    public ProfileData getProfile(Long userId) {
        User user = findUser(userId);
        Comparator<Movie> byTitle = Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER);

        return new ProfileData(
                user.getEmail(),
                user.getRatings(),
                user.getBookmarks().stream().sorted(byTitle).toList(),
                user.getWatchedMovies().stream().sorted(byTitle).toList()
        );
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
    }

    private Movie findMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Фильм не найден"));
    }

}
