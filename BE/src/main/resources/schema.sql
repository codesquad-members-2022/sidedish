-- member Table
DROP TABLE IF EXISTS member;

CREATE TABLE member
(
    `id`          BIGINT         NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `name`        VARCHAR(50)    NOT NULL    COMMENT '사용자 이름',
    `password`    VARCHAR(50)    NOT NULL    COMMENT '비밀번호',
    `created_at`  TIMESTAMP      NOT NULL    DEFAULT NOW() COMMENT '생성일시',
    `updated_at`  TIMESTAMP      NOT NULL    DEFAULT NOW() COMMENT '수정일시',
    PRIMARY KEY (id)
);

ALTER TABLE member COMMENT '회원';

-- dish Table
DROP TABLE IF EXISTS dish;

CREATE TABLE dish
(
    `id`                    BIGINT           NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `title`                 VARCHAR(50)      NOT NULL    COMMENT '반찬 이름',
    `content`               VARCHAR(500)     NULL        COMMENT '반찬 설명',
    `tag`                    VARCHAR(50)      NULL        COMMENT '뱃지',
    `price`                 INT              NOT NULL    COMMENT '정가',
    `stock`                 INT              NOT NULL    COMMENT '재고',
    `delivery_fee`          INT              NOT NULL    COMMENT '배송비',
    `free_shipping_amount`  INT              NULL        COMMENT '무료배송조건금액',
    `mileage_rate`          DECIMAL(2, 2)    NOT NULL    COMMENT '적립금 비율',
    `early_deliverable`     BOOLEAN          NULL        COMMENT '새벽배송가능여부',
    PRIMARY KEY (id)
);

ALTER TABLE dish COMMENT '반찬';

-- category Table
DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    `id`                  BIGINT         NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `parent_category_id`  BIGINT         NULL        COMMENT '상위 카테고리 id',
    `name`                VARCHAR(50)    NOT NULL    COMMENT '카테고리 이름',
    `is_event`            BOOLEAN        NOT NULL    COMMENT '기획전 여부',
    `is_deleted`          BOOLEAN        NOT NULL    COMMENT '삭제 여부',
    PRIMARY KEY (id),
    FOREIGN KEY(parent_category_id) REFERENCES category(id)
);

ALTER TABLE category COMMENT '카테고리';

-- orders Table
DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    `id`            BIGINT    NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `member_id`     BIGINT    NOT NULL    COMMENT '회원 id',
    `dish_id`       BIGINT    NOT NULL    COMMENT '반찬 id',
    `quantity`      INT       NOT NULL    COMMENT '주문수량',
    `total_amount`  INT       NOT NULL    COMMENT '주문총액',
    PRIMARY KEY (id)
);

ALTER TABLE orders COMMENT '주문';

-- category_dish Table
DROP TABLE IF EXISTS category_dish;

CREATE TABLE category_dish
(
    `id`           BIGINT    NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `category_id`  BIGINT    NULL        COMMENT '카테고리 id',
    `dish_id`      BIGINT    NULL        COMMENT '반찬 id',
    PRIMARY KEY (id)
);

ALTER TABLE category_dish COMMENT '카테고리반찬';

-- dish_image Table
DROP TABLE IF EXISTS dish_image;

CREATE TABLE dish_image
(
    `id`       BIGINT           NOT NULL    AUTO_INCREMENT COMMENT 'id',
    `dish_id`  BIGINT           NULL        COMMENT '반찬 id',
    `path`     VARCHAR(2000)    NULL        COMMENT '파일 경로',
    PRIMARY KEY (id)
);

ALTER TABLE dish_image COMMENT '반찬이미지';
