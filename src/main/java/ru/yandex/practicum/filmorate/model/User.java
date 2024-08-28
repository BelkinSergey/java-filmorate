package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
public class User {

    @Past(message = "Некорректно введен день рождения пользователя.")
    private LocalDate birthday;
    @Email(message = "Некорректно введен email пользователя.")
    private String email;
    private Set<User> friends = new HashSet<>();
    private int id;
    @NotBlank(message = "Логин пользователя не может быть пустым.")
    private String login;
    private String name;

}
