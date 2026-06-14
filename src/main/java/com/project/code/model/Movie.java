package com.project.code.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Main
    private String title;
    private String slug;
    private String description;

    // URL
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

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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
        if (tagline == null) {
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
