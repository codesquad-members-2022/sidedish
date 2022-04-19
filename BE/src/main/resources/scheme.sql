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
