package com.project.code.dto;

public class MovieForm {
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

    public MovieForm() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenplay() {
        return screenplay;
    }

    public void setScreenplay(String screenplay) {
        this.screenplay = screenplay;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCinematographer() {
        return cinematographer;
    }

    public void setCinematographer(String cinematographer) {
        this.cinematographer = cinematographer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getProductionDesigner() {
        return productionDesigner;
    }

    public void setProductionDesigner(String productionDesigner) {
        this.productionDesigner = productionDesigner;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getUsaBoxOffice() {
        return usaBoxOffice;
    }

    public void setUsaBoxOffice(long usaBoxOffice) {
        this.usaBoxOffice = usaBoxOffice;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @SuppressWarnings("unused")
    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("unused")
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
            MovieForm f = new MovieForm();
            f.setTitle(this.title);
            f.setSlug(this.slug);
            f.setDescription(this.description);
            f.setPosterUrl(this.posterUrl);
            f.setBackdropUrl(this.backdropUrl);
            f.setTrailerUrl(this.trailerUrl);
            f.setYear(this.year);
            f.setCountry(this.country);
            f.setGenre(this.genre);
            f.setTagline(this.tagline);
            f.setDirector(this.director);
            f.setScreenplay(this.screenplay);
            f.setProducer(this.producer);
            f.setCinematographer(this.cinematographer);
            f.setComposer(this.composer);
            f.setProductionDesigner(this.productionDesigner);
            f.setEditor(this.editor);
            f.setBudget(this.budget);
            f.setUsaBoxOffice(this.usaBoxOffice);
            f.setAgeRating(this.ageRating);
            f.setRuntime(this.runtime);

            return f;
        }
    }
}