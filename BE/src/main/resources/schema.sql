DROP TABLE IF EXISTS dish;
CREATE TABLE dish
(
    dish_id       BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Dish 의 고유한 id',
    name          VARCHAR(60) NULL COMMENT '음식 이름',
    description   VARCHAR(255) NULL COMMENT '음식 설명',
    normal_price  DECIMAL NULL COMMENT '원 가격',
    badge         VARCHAR(255) NULL COMMENT '할인 정보, 할인 뱃지',
    delivery_type VARCHAR(255) NULL COMMENT '배송 타입',
    thumbnail     VARCHAR(255) NULL COMMENT '상품의 썸네일 이미지 url',
    category_id   BIGINT NOT NULL COMMENT 'category 테이블의 외래키',
    CONSTRAINT FOREIGN KEY (category_id) REFERENCES category (category_id),
    dish_status   VARCHAR(255) NULL COMMENT '음식 품절 여부'
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
