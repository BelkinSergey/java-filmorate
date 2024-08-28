package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Film {

    @Size(max = 200, message = "Превышена длинна описания фильма.")
    private String description;
    @Positive(message = "Продолжительность фильма должна быть положительным числом.")
    private int duration;
    private Set<Genre> genres = new HashSet<>();
    private int id;
    private int idRatingMpa;
    private Set<Integer> likes = new HashSet<>();
    @NotBlank(message = "Название фильма не может быть пустым.")
    private String name;
    private RatingMpa mpa;
    private LocalDate releaseDate;

}

