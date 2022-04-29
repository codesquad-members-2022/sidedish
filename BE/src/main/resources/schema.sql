DROP TABLE IF EXISTS dish;
CREATE TABLE dish
(
    dish_id               BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Dish 의 고유한 id',
    name                  VARCHAR(60)  NULL COMMENT '음식 이름',
    description           VARCHAR(255) NULL COMMENT '음식 설명',
    price                 DECIMAL      NULL COMMENT '원 가격',
    badge                 VARCHAR(255) NULL COMMENT '할인 정보, 할인 뱃지',
    delivery_price_option VARCHAR(255) NULL COMMENT '배송 타입',
    thumbnail             VARCHAR(255) NULL COMMENT '상품의 썸네일 이미지 url',
    category_id           BIGINT       NOT NULL COMMENT 'category 테이블의 외래키',
    count                 INT,
    dish_status           VARCHAR(255) NULL COMMENT '음식 품절 여부'
);

DROP TABLE IF EXISTS images;
CREATE TABLE images
(
    image_id   BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    image_path VARCHAR(500),
    dish_id    BIGINT NOT NULL

);

DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id    BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(30),
    username   VARCHAR(30),
    avatar_url VARCHAR(255),
    email      VARCHAR(25),
    location   VARCHAR(120),
    bio        ENUM ('MAN', 'WOMAN', 'NOT_REGISTERED'),
    github_id VARCHAR(50)
);

DROP TABLE IF EXISTS category;
CREATE TABLE category
(
    category_id BIGINT NOT NULL PRIMARY KEY,
    description VARCHAR(255)
);


DROP TABLE IF EXISTS sub_category;
CREATE TABLE sub_category
(
    sub_category_id    BIGINT       NOT NULL PRIMARY KEY AUTO_INCREMENT,
    description_detail VARCHAR(255) NOT NULL,
    country            ENUM ('KOREA', 'JAPAN', 'CHINA', 'FRANCE') COMMENT '각 국가별 이름'
);
