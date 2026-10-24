package com.project.code.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Getter
@Setter
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Main
    @NotBlank(message = "Title cannot be empty or blank")
    private String title;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(length = 2000)
    private String description;

    @Column(length = 1000)
    private String posterUrl;

    @Column(length = 1000)
    private String backdropUrl;

    @Column(length = 1000)
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

    public String getFormattedTagline() {
        if (tagline == null || tagline.isBlank()) {
            return "—";
        }
        return "«" + tagline + "»";
    }

    public String getFormattedBudget() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        return formatter.format(budget);
    }

    public String getFormattedUsaBoxOffice() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        return formatter.format(usaBoxOffice);
    }

    public String getFormattedRuntime() {
        int hours = runtime / 60;
        int minutes = runtime % 60;

        return hours + " ч " + minutes + " мин";
    }

    public String resize(String url, String size) {
        if (url == null || !url.endsWith("/orig")) {
            return url;
        }

        return url.substring(0, url.length() - "orig".length()) + size;
    }

    public String getPosterThumb() {
        return resize(posterUrl, "300x450");
    }

    public String getPosterMedium() {
        return resize(posterUrl, "600x900");
    }

    public String getBackdropMedium() {
        return resize(backdropUrl, "1280x720");
    }

    public String getTrailerThumb() {
        return resize(trailerUrl, "600x");
    }

    public String getMainGenre() {
        String[] genres = genre.split(", ");

        return genres[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie other)) return false;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Movie.class.hashCode();
    }
}
