package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exeption.ConditionsNotMetException;
import ru.yandex.practicum.filmorate.model.User;

import java.util.*;

@Component
@Slf4j
public class InMemoryUserStorage implements UserStorage {
    private final Map<Long, User> users = new HashMap<>();

    private long id = 0;

    @Override
    public User createUser(User user) {
        user.setId(getNextId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        getUser(user.getId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        getUser(id);
        users.remove(id);
        log.info("Ползователь {} удален", users.get(id));
    }

    @Override
    public Collection<User> allUsers() {
        return users.values();
    }

    @Override
    public User getUser(Long id) {
        if (users.get(id) == null) {
            throw new ConditionsNotMetException("айди не найден");
        }
        log.info("Пользователь {} найден", users.get(id));
        return users.get(id);
    }

    private long getNextId() {
        return ++id;
    }
}
