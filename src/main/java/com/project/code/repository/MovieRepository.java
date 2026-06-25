package com.project.code.repository;

import com.project.code.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findBySlug(String slug);

    List<Movie> findByYear(int year);

    Page<Movie> findByTitleContainingIgnoreCase(String title,
                                                       Pageable pageable);

    void deleteBySlug(String slug);

}
