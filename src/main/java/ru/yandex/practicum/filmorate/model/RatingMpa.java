package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RatingMpa {

    private int id;
    @NotBlank(message = "Название рейтинга фильма не может быть пустым.")
    private String name;

}
