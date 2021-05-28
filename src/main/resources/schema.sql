CREATE TABLE app_user
(
    id       IDENTITY NOT NULL PRIMARY KEY,
    username VARCHAR   NOT NULL,
    email    VARCHAR   NOT NULL
);
CREATE TABLE lecture
(
    id           IDENTITY NOT NULL PRIMARY KEY,
    lecture_id   INT       NOT NULL,
    topic_number INT       NOT NULL
)
