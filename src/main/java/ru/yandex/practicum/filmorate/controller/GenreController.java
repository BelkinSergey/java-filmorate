package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.constraints.Positive;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.service.genre.GenreService;

import java.util.Collection;


@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private static final String ID = "id";

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection<Genre> findAllGenres() {
        return genreService.findAllGenres();
    }

    @GetMapping("/{" + ID + "}")
    @ResponseStatus(HttpStatus.OK)
    public Genre findGenre(@PathVariable(ID) @Positive int idGenre) {
        return genreService.findGenre(idGenre);
    }

}
