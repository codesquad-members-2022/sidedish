DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS item_order;

CREATE TABLE category
(
    id   BIGINT AUTO_INCREMENT,
    type VARCHAR(64),
    PRIMARY KEY (id)
);

CREATE TABLE items
(
    id            BIGINT AUTO_INCREMENT,
    category      BIGINT ,
    category_key  BIGINT references category (id),
    title         VARCHAR(64)  NOT NULL,
    description   VARCHAR(255) NOT NULL,
    price         DECIMAL      NOT NULL,
    discount_rate DOUBLE,
    badge         VARCHAR(32),
    detail_type   VARCHAR(32),
    quantity      BIGINT       NOT NULL,
    reward_point  DECIMAL      NOT NULL,
    image         VARCHAR(64)  NOT NULL,
    category_type VARCHAR (32),
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id            BIGINT primary key AUTO_INCREMENT,
    shipping_fee  DECIMAL,
    shipping_info VARCHAR(64)
);

CREATE TABLE item_order
(
    item BIGINT,
    orders BIGINT,
    primary key (item, orders)
);
