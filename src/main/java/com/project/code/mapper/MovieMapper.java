package com.project.code.mapper;

import com.project.code.dto.MovieForm;
import com.project.code.model.Movie;

public class MovieMapper {

    private static String clean(String s) {
        return s == null ? "" : s.strip();
    }

    public static void applyForm(Movie movie, MovieForm form) {
        movie.setTitle(clean(form.getTitle()));
        movie.setSlug(clean(form.getSlug()));
        movie.setDescription(clean(form.getDescription()));
        movie.setPosterUrl(clean(form.getPosterUrl()));
        movie.setBackdropUrl(clean(form.getBackdropUrl()));
        movie.setTrailerUrl(clean(form.getTrailerUrl()));
        movie.setYear(form.getYear());
        movie.setCountry(clean(form.getCountry()));
        movie.setGenre(clean(form.getGenre()));
        movie.setTagline(clean(form.getTagline()));
        movie.setDirector(clean(form.getDirector()));
        movie.setScreenplay(clean(form.getScreenplay()));
        movie.setProducer(clean(form.getProducer()));
        movie.setCinematographer(clean(form.getCinematographer()));
        movie.setComposer(clean(form.getComposer()));
        movie.setProductionDesigner(clean(form.getProductionDesigner()));
        movie.setEditor(clean(form.getEditor()));
        movie.setBudget(form.getBudget());
        movie.setUsaBoxOffice(form.getUsaBoxOffice());
        movie.setAgeRating(clean(form.getAgeRating()));
        movie.setRuntime(form.getRuntime());
    }

    public static Movie toNewMovie(MovieForm form) {
        Movie movie = new Movie();
        applyForm(movie, form);
        return movie;
    }

    public static MovieForm toForm(Movie m) {
        return MovieForm.builder()
                .title(m.getTitle()).slug(m.getSlug()).description(m.getDescription())
                .posterUrl(m.getPosterUrl()).backdropUrl(m.getBackdropUrl()).trailerUrl(m.getTrailerUrl())
                .year(m.getYear()).country(m.getCountry()).genre(m.getGenre()).tagline(m.getTagline())
                .director(m.getDirector()).screenplay(m.getScreenplay()).producer(m.getProducer())
                .cinematographer(m.getCinematographer()).composer(m.getComposer())
                .productionDesigner(m.getProductionDesigner()).editor(m.getEditor())
                .budget(m.getBudget()).usaBoxOffice(m.getUsaBoxOffice())
                .ageRating(m.getAgeRating()).runtime(m.getRuntime())
                .build();
    }
}