DROP TABLE IF EXISTS dish;
CREATE TABLE dish
(
    dish_id       BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name          VARCHAR(255) NULL,
    description   VARCHAR(255) NULL,
    normal_price  DECIMAL      NULL,
    sale_price    DECIMAL      NULL,
    badge         VARCHAR(255) NULL,
    delivery_type VARCHAR(255) NULL,
    thumbnail     VARCHAR(255) NULL,
    category_id   BIGINT       NOT NULL,
    dish_status   VARCHAR(255) NULL
);


DROP TABLE IF EXISTS category;
CREATE TABLE category
(
    category_id BIGINT NOT NULL PRIMARY KEY,
    title       VARCHAR(255)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    user_id  BIGINT      NOT NULL PRIMARY KEY,
    login_id BIGINT      NOT NULL,
    password VARCHAR(60) NOT NULL
);
