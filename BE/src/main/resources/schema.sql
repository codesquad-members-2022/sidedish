DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    member_id BIGINT AUTO_INCREMENT NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    PRIMARY KEY (member_id)
);

DROP TABLE IF EXISTS order_sheet;
CREATE TABLE order_sheet
(
    order_id    BIGINT AUTO_INCREMENT NOT NULL,
    banchan_id  BIGINT NOT NULL,
    member_id   BIGINT NOT NULL,
    quantity    INTEGER NOT NULL,
    total_price INTEGER NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (banchan_id) REFERENCES banchans (banchan_id),
    FOREIGN KEY (member_id)  REFERENCES member (member_id)
);

DROP TABLE IF EXISTS banchans;
CREATE TABLE banchans
(
     banchan_id   BIGINT AUTO_INCREMENT NOT NULL,
     category_id  BIGINT NOT NULL,
     banchan_name VARCHAR(255) NOT NULL,
     description  VARCHAR(255) NOT NULL,
     or_price     INTEGER NOT NULL,
     dc_price     INTEGER NOT NULL,
     stock        INTEGER NOT NULL,
     label_id     INTEGER NOT NULL,
     main_image   VARCHAR(255) NOT NULL,
     delivery_id  INTEGER NOT NULL,
     best_id      BIGINT,
     PRIMARY KEY (banchan_id),
     FOREIGN KEY (category_id) REFERENCES category (category_id),
     FOREIGN KEY (label_id)    REFERENCES label (label_id),
     FOREIGN KEY (delivery_id) REFERENCES delivery (delivery_id),
     FOREIGN KEY (best_id)     REFERENCES best_type (best_id)
);

DROP TABLE IF EXISTS images;
CREATE TABLE images
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    banchan_id    BIGINT NOT NULL,
    detail_images VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (banchan_id) REFERENCES banchans (banchan_id)
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
    best_id   BIGINT AUTO_INCREMENT NOT NULL,
    best_name VARCHAR(255),
    PRIMARY KEY (best_id)
);


