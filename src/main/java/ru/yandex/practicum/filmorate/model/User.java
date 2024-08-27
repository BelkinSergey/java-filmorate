package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {

    @Past(message = "Некорректно введен день рождения пользователя.")
    LocalDate birthday;
    @Email(message = "Некорректно введен email пользователя.")
    String email;
    Set<User> friends = new HashSet<>();
    int id;
    @NotBlank(message = "Логин пользователя не может быть пустым.")
    String login;
    String name;

}
