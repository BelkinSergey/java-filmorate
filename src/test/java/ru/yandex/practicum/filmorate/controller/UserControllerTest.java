package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.exeption.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {
    @Autowired
    UserController userController;

    @Test
    @DisplayName("Проверка корректности формата почты")
    void shouldValidationCorrectFormatEmail() {
        User user = new User();
        user.setName("Sergei");
        user.setBirthday(LocalDate.of(1995, 1, 11));
        user.setLogin("Belka");
        user.setEmail("");
        assertThrows(ValidationException.class, () -> {
            User user1 = userController.userCreate(user);
        });
    }

    @Test
    @DisplayName("Проверка корректности формата логина")
    void shouldValitationCorrectFormatLogin() {
        User user = new User();
        user.setName("Sergei");
        user.setBirthday(LocalDate.of(1995, 1, 11));
        user.setLogin("");
        user.setEmail("belka95@mail.ru");
        assertThrows(ConstraintViolationException.class, () -> {
            User user1 = userController.userCreate(user);
        });

    }

    @Test
    @DisplayName("Проверка даты рождения в будущем")
    void shouldValidationBirthdayFuture() {
        User user = new User();

        user.setBirthday(LocalDate.of(2025, 1, 11));
        user.setLogin("Belka");
        user.setEmail("belka95@mail.ru");

        assertThrows(ValidationException.class, () -> {
            User user1 = userController.userCreate(user);
        });
    }

    @Test
    @DisplayName("Провекра пустого имени")
    void shouldValidationEmptyName() {
        User user = new User();
        user.setBirthday(LocalDate.of(1995, 1, 11));
        user.setLogin("Belka");
        user.setEmail("belka95@mail.ru");
        User user1 = userController.userCreate(user);

        assertEquals("Belka", user1.getName());
    }

    @Test
    @DisplayName("Проверка правильности написания почты")
    void shouldValidationEmail() {
        User user = new User();
        user.setName("Sergei");
        user.setBirthday(LocalDate.of(1995, 1, 11));
        user.setLogin("Belka");
        user.setEmail("belka95mail.ru");

        assertThrows(ConstraintViolationException.class, () -> {
            User user1 = userController.userCreate(user);
        });
    }


}