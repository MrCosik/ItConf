-- DROP TABLE IF EXISTS  app_user;
-- DROP TABLE IF EXISTS  lecture;

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
    topic_number INT       NOT NULL,
    app_user_id INT REFERENCES app_user(id)
    ON DELETE CASCADE ON UPDATE CASCADE

)
