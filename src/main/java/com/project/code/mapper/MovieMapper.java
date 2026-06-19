package com.project.code.mapper;

import com.project.code.dto.MovieForm;
import com.project.code.model.Movie;

public class MovieMapper {

    public static void applyForm(Movie movie, MovieForm form) {
        movie.setTitle(form.getTitle().strip());
        movie.setSlug(form.getSlug().strip());
        movie.setDescription(form.getDescription().strip());
        movie.setPosterUrl(form.getPosterUrl().strip());
        movie.setBackdropUrl(form.getBackdropUrl().strip());
        movie.setTrailerUrl(form.getTrailerUrl().strip());
        movie.setYear(form.getYear());
        movie.setCountry(form.getCountry().strip());
        movie.setGenre(form.getGenre().strip());
        movie.setTagline(form.getTagline().strip());
        movie.setDirector(form.getDirector().strip());
        movie.setScreenplay(form.getScreenplay().strip());
        movie.setProducer(form.getProducer().strip());
        movie.setCinematographer(form.getCinematographer().strip());
        movie.setComposer(form.getComposer().strip());
        movie.setProductionDesigner(form.getProductionDesigner().strip());
        movie.setEditor(form.getEditor().strip());
        movie.setBudget(form.getBudget());
        movie.setUsaBoxOffice(form.getUsaBoxOffice());
        movie.setAgeRating(form.getAgeRating().strip());
        movie.setRuntime(form.getRuntime());
    }

    public static Movie toNewMovie(MovieForm form) {
        Movie movie = new Movie();
        applyForm(movie, form);
        return movie;
    }
}