package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Genre {

    private int id;
    @NotBlank(message = "Название жанра фильма не может быть пустыми.")
    private String name;

}