package com.project.code.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Main
    @NotBlank(message = "Title cannot be empty or blank")
    private String title;

    private String slug;

    private String description;

    // URL
    @NotBlank(message = "PosterURL cannot be empty or blank")
    private String posterUrl;

    private String backdropUrl;

    private String trailerUrl;

    @Positive(message = "Year cannot be negative or zero")
    private int year;

    @NotBlank(message = "Country cannot be empty or blank")
    private String country;

    @NotBlank(message = "Genre cannot be empty or blank")
    private String genre;

    private String tagline;

    @NotBlank(message = "Director cannot be empty or blank")
    private String director;

    @NotBlank(message = "Screenplay cannot be empty or blank")
    private String screenplay;

    @NotBlank(message = "Producer cannot be empty or blank")
    private String producer;

    @NotBlank(message = "Cinematographer cannot be empty or blank")
    private String cinematographer;

    @NotBlank(message = "Composer cannot be empty or blank")
    private String composer;

    @NotBlank(message = "Production Designer cannot be empty or blank")
    private String productionDesigner;

    @NotBlank(message = "Editor cannot be empty or blank")
    private String editor;

    @PositiveOrZero(message = "Budget cannot be negative")
    private long budget;

    @PositiveOrZero(message = "USA Box Office cannot be negative")
    private long usaBoxOffice;

    @NotBlank(message = "Age Rating cannot be empty or blank")
    private String ageRating;

    @Positive(message = "Runtime cannot be negative or zero")
    private int runtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getFormattedTagline() {
        if (tagline == null || tagline.isBlank()) {
            return "—";
        }
        return "«" + tagline + "»";
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

    public String getFormattedBudget() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        return formatter.format(budget);
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getUsaBoxOffice() {
        return usaBoxOffice;
    }

    public String getFormattedUsaBoxOffice() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        return formatter.format(usaBoxOffice);
    }

    public void setUsaBoxOffice(long usaBoxOffice) {
        this.usaBoxOffice = usaBoxOffice;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String rating) {
        this.ageRating = rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getFormattedRuntime() {
        int hours = runtime / 60;
        int minutes = runtime % 60;

        return hours + " ч " + minutes + " мин";
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
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
}
