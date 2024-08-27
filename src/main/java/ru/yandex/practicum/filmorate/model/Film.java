package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Film {

    @Size(max = 200, message = "Превышена длинна описания фильма.")
    String description;
    @Positive(message = "Продолжительность фильма должна быть положительным числом.")
    int duration;
    Set<Genre> genres = new HashSet<>();
    int id;
    int idRatingMpa;
    Set<Integer> likes = new HashSet<>();
    @NotBlank(message = "Название фильма не может быть пустым.")
    String name;
    RatingMpa mpa;
    LocalDate releaseDate;

}

