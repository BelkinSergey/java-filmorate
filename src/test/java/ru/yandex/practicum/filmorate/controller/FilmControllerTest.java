package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.exeption.ConditionsNotMetException;
import ru.yandex.practicum.filmorate.exeption.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FilmControllerTest {
    @Autowired
    private FilmController filmController;

    @Test
    @DisplayName("Проверка  на пустой id у фильма")
    void shouldValidationForEmptyIdFilm() {
        Film film = new Film();
        film.setId(null);
        film.setName("Человек паук");
        film.setDescription("Про зеленого гоблина");
        film.setDuration(130);
        film.setReleaseDate(LocalDate.now());
        assertThrows(ConditionsNotMetException.class, () -> {
            Film film1 = filmController.update(film);
        });
    }

    @Test
    @DisplayName("Проверка на пустое название фильма")
    void shouldValidationForEmptyNameFilm() {
        Film film = new Film();
        film.setName(" ");
        film.setDescription("Про зеленого гоблина");
        film.setDuration(130);
        film.setReleaseDate(LocalDate.now());
        assertThrows(ValidationException.class, () -> {
            Film film1 = filmController.create(film);
        });
    }

    @Test
    @DisplayName("Проверка на максимальную длину описания фильма")
    void shouldValidationMaximumLengthFilmDescription() {
        Film film = new Film();
        film.setName("Человек паук");
        film.setDescription("Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина" +
                "Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина " +
                "Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина" +
                "Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина Про зеленого гоблина");
        film.setDuration(130);
        film.setReleaseDate(LocalDate.now());
        assertThrows(ValidationException.class, () -> {
            Film film1 = filmController.create(film);
        });
    }

    @Test
    @DisplayName("Проверка даты релиза фильма")
    void shouldValidationFilmsReleaseDate() {
        Film film = new Film();
        film.setName("Человек паук");
        film.setDescription("Про зеленого гоблина");
        film.setDuration(130);
        film.setReleaseDate(LocalDate.of(1801, 1, 1));
        assertThrows(ValidationException.class, () -> {
            Film film1 = filmController.create(film);
        });
    }

    @Test
    @DisplayName("Проверка продолжительности фильма")
    void shouldValidationDurationFilm() {
        Film film = new Film();
        film.setName("Человек паук");
        film.setDescription("Про зеленого гоблина");
        film.setDuration(-130);
        film.setReleaseDate(LocalDate.now());
        assertThrows(ValidationException.class, () -> {
            Film film1 = filmController.create(film);
        });
    }
}