package com.project.code.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieForm {

    @NotBlank(message = "Введите название")
    @Size(max = 255)
    private String title;

    @NotBlank(message = "Введите slug")
    @Size(max = 255)
    @Pattern(regexp = "^[a-z0-9]+(-[a-z0-9]+)*$", message = "Slug: строчные латинские буквы, цифры и дефисы")
    private String slug;

    @Size(max = 2000, message = "Описание: не больше 2000 символов")
    private String description;

    @NotBlank(message = "Введите URL постера")
    @Pattern(regexp = "^https?://[^\\s'\"()<>]+$", message = "Нужна ссылка http(s) без пробелов и кавычек")
    @Size(max = 1000)
    private String posterUrl;

    @Size(max = 1000)
    @Pattern(regexp = "^(https?://[^\\s'\"()<>]+)?$", message = "Нужна ссылка http(s) без пробелов и кавычек")
    private String backdropUrl;

    @Size(max = 1000)
    private String trailerUrl;

    @Min(value = 1888, message = "Год не раньше 1888")
    @Max(value = 2100, message = "Год не позже 2100")
    private int year;

    @NotBlank(message = "Введите страну")
    @Size(max = 255)
    private String country;

    @NotBlank(message = "Введите жанр")
    @Size(max = 255)
    private String genre;

    @Size(max = 255)
    private String tagline;

    @NotBlank(message = "Введите режиссера")
    @Size(max = 255)
    private String director;

    @NotBlank(message = "Введите сценариста")
    @Size(max = 255)
    private String screenplay;

    @NotBlank(message = "Введите продюсера")
    @Size(max = 255)
    private String producer;

    @NotBlank(message = "Введите оператора")
    @Size(max = 255)
    private String cinematographer;

    @NotBlank(message = "Введите композитора")
    @Size(max = 255)
    private String composer;

    @NotBlank(message = "Введите художника")
    @Size(max = 255)
    private String productionDesigner;

    @NotBlank(message = "Введите монтажера")
    @Size(max = 255)
    private String editor;

    @PositiveOrZero(message = "Бюджет не может быть отрицательным")
    private long budget;

    @PositiveOrZero(message = "Сборы не могут быть отрицательными")
    private long usaBoxOffice;

    @NotBlank(message = "Введите возрастной рейтинг")
    @Size(max = 255)
    private String ageRating;

    @Positive(message = "Длительность должна быть больше 0")
    @Max(value = 1000, message = "Слишком большая длительность")
    private int runtime;

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.strip();
    }

}