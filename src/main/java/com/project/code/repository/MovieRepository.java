package com.project.code.repository;

import com.project.code.model.Movie;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findBySlug(String slug);

    public List<Movie> findByYear(int year);

    public Page<Movie> findByTitleContainingIgnoreCase(String title,
                                                       Pageable pageable);

    public void deleteBySlug(String slug);

}
