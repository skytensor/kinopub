package com.project.code.dto;

public class MovieForm {
    private final String title;
    private final String slug;
    private final String description;
    private final String posterUrl;
    private final String backdropUrl;
    private final String trailerUrl;
    private final int year;
    private final String country;
    private final String genre;
    private final String tagline;
    private final String director;
    private final String screenplay;
    private final String producer;
    private final String cinematographer;
    private final String composer;
    private final String productionDesigner;
    private final String editor;
    private final long budget;
    private final long usaBoxOffice;
    private final String ageRating;
    private final int runtime;

    private MovieForm(Builder b) {
        this.title = b.title;
        this.slug = b.slug;
        this.description = b.description;
        this.posterUrl = b.posterUrl;
        this.backdropUrl = b.backdropUrl;
        this.trailerUrl = b.trailerUrl;
        this.year = b.year;
        this.country = b.country;
        this.genre = b.genre;
        this.tagline = b.tagline;
        this.director = b.director;
        this.screenplay = b.screenplay;
        this.producer = b.producer;
        this.cinematographer = b.cinematographer;
        this.composer = b.composer;
        this.productionDesigner = b.productionDesigner;
        this.editor = b.editor;
        this.budget = b.budget;
        this.usaBoxOffice = b.usaBoxOffice;
        this.ageRating = b.ageRating;
        this.runtime = b.runtime;
    }

    // геттеры — обязательны, без них Thymeleaf/Spring не сможет читать поля
    public String getTitle() { return title; }
    public String getSlug() { return slug; }
    public String getDescription() { return description; }
    public String getPosterUrl() { return posterUrl; }
    public String getBackdropUrl() { return backdropUrl; }
    public String getTrailerUrl() { return trailerUrl; }
    public int getYear() { return year; }
    public String getCountry() { return country; }
    public String getGenre() { return genre; }
    public String getTagline() { return tagline; }
    public String getDirector() { return director; }
    public String getScreenplay() { return screenplay; }
    public String getProducer() { return producer; }
    public String getCinematographer() { return cinematographer; }
    public String getComposer() { return composer; }
    public String getProductionDesigner() { return productionDesigner; }
    public String getEditor() { return editor; }
    public long getBudget() { return budget; }
    public long getUsaBoxOffice() { return usaBoxOffice; }
    public String getAgeRating() { return ageRating; }
    public int getRuntime() { return runtime; }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String title;
        private String slug;
        private String description;
        private String posterUrl;
        private String backdropUrl;
        private String trailerUrl;
        private int year;
        private String country;
        private String genre;
        private String tagline;
        private String director;
        private String screenplay;
        private String producer;
        private String cinematographer;
        private String composer;
        private String productionDesigner;
        private String editor;
        private long budget;
        private long usaBoxOffice;
        private String ageRating;
        private int runtime;

        public Builder title(String title) { this.title = title; return this; }
        public Builder slug(String slug) { this.slug = slug; return this; }
        public Builder description(String description) { this.description = description; return this; }
        public Builder posterUrl(String posterUrl) { this.posterUrl = posterUrl; return this; }
        public Builder backdropUrl(String backdropUrl) { this.backdropUrl = backdropUrl; return this; }
        public Builder trailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; return this; }
        public Builder year(int year) { this.year = year; return this; }
        public Builder country(String country) { this.country = country; return this; }
        public Builder genre(String genre) { this.genre = genre; return this; }
        public Builder tagline(String tagline) { this.tagline = tagline; return this; }
        public Builder director(String director) { this.director = director; return this; }
        public Builder screenplay(String screenplay) { this.screenplay = screenplay; return this; }
        public Builder producer(String producer) { this.producer = producer; return this; }
        public Builder cinematographer(String cinematographer) { this.cinematographer = cinematographer; return this; }
        public Builder composer(String composer) { this.composer = composer; return this; }
        public Builder productionDesigner(String productionDesigner) { this.productionDesigner = productionDesigner; return this; }
        public Builder editor(String editor) { this.editor = editor; return this; }
        public Builder budget(long budget) { this.budget = budget; return this; }
        public Builder usaBoxOffice(long usaBoxOffice) { this.usaBoxOffice = usaBoxOffice; return this; }
        public Builder ageRating(String ageRating) { this.ageRating = ageRating; return this; }
        public Builder runtime(int runtime) { this.runtime = runtime; return this; }

        public MovieForm build() {
            return new MovieForm(this);
        }
    }
}