INSERT INTO rating_mpa (id_rating_mpa, name)
VALUES (1, 'G'),
       (2, 'PG'),
       (3, 'PG-13'),
       (4, 'R'),
       (5, 'NC-17');

INSERT INTO genre (id_genre, name)
VALUES (1, 'Комедия'),
       (2, 'Драма'),
       (3, 'Мультфильм'),
       (4, 'Триллер'),
       (5, 'Документальный'),
       (6, 'Боевик');

INSERT INTO user_storage (birthday, email, login, name)
VALUES ('1981-03-11', 'Leonardo@mail.com', 'Leonardo', 'DiCaprio'),
       ('1951-08-21', 'Johnny@gmail.com', 'Johny', 'Depp'),
       ('1981-04-17', 'BPitt.com', 'Bred', 'Pitt');

INSERT INTO film_storage (description, duration, name, id_rating_mpa, release_date)
VALUES ('Жили-были ...', 136, 'Русские сказки: Выпуск 1', 1, '1995-05-16'),
       ('В одной старой-старой деревне...', 142, 'Русские сказки: Выпуск 2', 2, '2002-05-12'),
       ('Старая бабка испекла колобок...', 140, 'Русские сказки: Выпуск 3', 3, '2005-05-12');

INSERT INTO film_genre (id_film, id_genre) VALUES (1, 1), (2, 2), (3, 3);
INSERT INTO friends (id_user, id_friend) VALUES (1, 2), (1, 3), (2, 1);