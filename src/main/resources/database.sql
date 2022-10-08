CREATE TABLE origin
(
    id          int NOT NULL AUTO_INCREMENT,
    name        varchar(255) UNIQUE NOT NULL,
    description varchar(1024)       NOT NULL,
    creator     varchar(255)        NOT NULL,
    created_at  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO origin (name, description, creator, created_at, updated_at)
VALUES ('Marvel', 'Marvel', 'Stan Lee', '2022-05-02 12:42:17', '2022-05-02 12:42:17');

CREATE TABLE card
(
    id          int NOT NULL AUTO_INCREMENT,
    name        varchar(255) UNIQUE NOT NULL,
    description varchar(255) DEFAULT NULL,
    strength    int          DEFAULT '1',
    speed       int          DEFAULT '1',
    skill       int          DEFAULT '1',
    gear        int          DEFAULT '1',
    intellect   int          DEFAULT '1',
    image_url   varchar(255) DEFAULT NULL,
    created_at  timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    origin_id    int NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (origin_id) REFERENCES origin (id)
);

INSERT INTO card (name, description, strength, speed, skill, gear, intellect, image_url,
                    created_at, updated_at, origin_id)
VALUES ('Iron Man', 'Homem de ferro', 1, 1, 1, 1, 1,
        'https://conteudo.imguol.com.br/c/entretenimento/96/2020/08/07/iron-man-1596813808466_v2_900x506.jpg.webp',
        '2022-05-02 12:43:36', '2022-05-02 12:43:36', 1);