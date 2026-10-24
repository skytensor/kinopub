package com.project.code.repository;

import com.project.code.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findBySlug(String slug);
    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    boolean existsBySlug(String slug);
    boolean existsBySlugAndIdNot(String slug, Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "DELETE FROM user_bookmarks WHERE movie_id = :movieId", nativeQuery = true)
    void deleteBookmarksByMovieId(@Param("movieId") Long id);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "DELETE FROM user_watched_movies WHERE movie_id = :movieId", nativeQuery = true)
    void deleteWatchedByMovieId(@Param("movieId") Long id);

}
