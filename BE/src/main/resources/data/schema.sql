SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id   BIGINT AUTO_INCREMENT,
    type VARCHAR(64),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS items;

CREATE TABLE items
(
    id            BIGINT AUTO_INCREMENT,
    category      BIGINT references category (id),
    category_key  BIGINT,
    title         VARCHAR(64)  NOT NULL,
    description   VARCHAR(255) NOT NULL,
    price         DECIMAL      NOT NULL,
    discount_rate DOUBLE,
    badge         VARCHAR(32),
    detail_type   VARCHAR(32),
    quantity      BIGINT       NOT NULL,
    reward_point  DECIMAL      NOT NULL,
    main_url      VARCHAR(255) NOT NULL,
    side_one      VARCHAR(255) NOT NULL COMMENT '상세 페이지 조회 시 출력되는 사이드 이미지 중 첫번째를 저장하는 링크',
    side_two      VARCHAR(255) NOT NULL COMMENT '상세 페이지 조회 시 출력되는 사이드 이미지 중 두번쨰를 저장하는 링크',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id            BIGINT primary key AUTO_INCREMENT,
    shipping_fee  DECIMAL,
    shipping_info VARCHAR(64)
);

DROP TABLE IF EXISTS item_order;

CREATE TABLE item_order
(
    item   BIGINT,
    orders BIGINT,
    primary key (item, orders)
);


SET FOREIGN_KEY_CHECKS = 1;
