SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id      BIGINT AUTO_INCREMENT,
    type    VARCHAR(64),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS items;

CREATE TABLE items
(
    id            VARCHAR(64),
    title         VARCHAR(64)  NOT NULL,
    description   VARCHAR(255) NOT NULL,
    price         DECIMAL      NOT NULL,
    discount_rate DOUBLE,
    badge         VARCHAR(32),
    detail_type   VARCHAR(32),
    quantity      BIGINT       NOT NULL,
    reward_point  DECIMAL      NOT NULL,
    image         VARCHAR(64)  NOT NULL,
    category_id   BIGINT,

    CONSTRAINT category_fk FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

SET FOREIGN_KEY_CHECKS = 1;
