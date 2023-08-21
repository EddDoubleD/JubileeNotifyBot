CREATE TABLE tg_chat
(
    id         INT4 NOT NULL,
    chatName       VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tg_user
(
    id         INT4 NOT NULL,
    username       VARCHAR(255),
    PRIMARY KEY (id)
);