DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT
(
    id                INTEGER           PRIMARY KEY   AUTO_INCREMENT,
    name              VARCHAR(30)       NOT NULL,
    content           VARCHAR(300)      NOT NULL,
    price             INTEGER           NOT NULL,
    quantity          INTEGER           NOT NULL,
    dish_type         VARCHAR(30)       NOT NULL,
    side_dish_type    VARCHAR(30),
    apply_event       VARCHAR(30),
    img_url           VARCHAR(3000),
    delivery_type     VARCHAR(30)
);

DROP TABLE IF EXISTS SHIPPING_INFO;

CREATE TABLE SHIPPING_INFO
(
    delivery_type     INTEGER           PRIMARY KEY    AUTO_INCREMENT,
    delivery_charge   INTEGER           NOT NULL,
    delivery_info     VARCHAR(30)       NOT NULL
);
