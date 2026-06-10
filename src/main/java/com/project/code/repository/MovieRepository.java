package com.project.code.repository;

import com.project.code.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findBySlug(String slug);

    public void deleteBySlug(String slug);
}
