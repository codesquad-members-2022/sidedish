DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id   BIGINT AUTO_INCREMENT NOT NULL,
    email     VARCHAR(30) NOT NULL,
    password  VARCHAR(30) NOT NULL,
    PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
    order_id    BIGINT AUTO_INCREMENT NOT NULL,
    item_id     BIGINT NOT NULL,
    user_id     BIGINT NOT NULL,
    quantity    INTEGER NOT NULL,
    total_price DECIMAL(6,0) NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (item_id) REFERENCES item (item_id),
    FOREIGN KEY (user_id)  REFERENCES user (user_id)
);

DROP TABLE IF EXISTS item;
CREATE TABLE item
(
     item_id      BIGINT AUTO_INCREMENT NOT NULL,
     category_id  BIGINT NOT NULL,
     item_name    VARCHAR(255) NOT NULL,
     description  VARCHAR(255) NOT NULL,
     or_price     DECIMAL(6,0) NOT NULL,
     dc_price     DECIMAL(6,0) NOT NULL,
     stock        INTEGER NOT NULL,
     label_id     INTEGER NOT NULL,
     main_image   VARCHAR(255) NOT NULL,
     delivery_id  INTEGER NOT NULL,
     best_id      BIGINT,
     PRIMARY KEY (item_id),
     FOREIGN KEY (category_id) REFERENCES category (category_id),
     FOREIGN KEY (label_id)    REFERENCES label (label_id),
     FOREIGN KEY (delivery_id) REFERENCES delivery (delivery_id),
     FOREIGN KEY (best_id)     REFERENCES best_type (best_id)
);

DROP TABLE IF EXISTS images;
CREATE TABLE images
(
    image_id      BIGINT AUTO_INCREMENT NOT NULL,
    item_id       BIGINT NOT NULL,
    detail_images VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category
(
    category_id   BIGINT AUTO_INCREMENT NOT NULL,
    category_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (category_id)
);

DROP TABLE IF EXISTS label;
CREATE TABLE label
(
    label_id   BIGINT AUTO_INCREMENT NOT NULL,
    label_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (label_id)
);

DROP TABLE IF EXISTS delivery;
CREATE TABLE delivery
(
    delivery_id   BIGINT AUTO_INCREMENT NOT NULL,
    delivery_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (delivery_id)
);

DROP TABLE IF EXISTS best_type;
CREATE TABLE best_type
(
    best_id   BIGINT AUTO_INCREMENT NOT NULL, COMMENT '베스트 반찬 TAB에서 Sorting 하기 위한 ID'
    best_name VARCHAR(255),
    PRIMARY KEY (best_id)
);


