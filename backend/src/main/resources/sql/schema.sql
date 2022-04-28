set FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    github_id VARCHAR(39) NOT NULL COMMENT 'Github 유저 ID',
    username  VARCHAR(39) COMMENT '유저가 서비스에서 사용할 이름',
    point     INT         NOT NULL DEFAULT 0 COMMENT '유저가 보유한 포인트',
    PRIMARY KEY (github_id)
);

DROP TABLE IF EXISTS dish;

CREATE TABLE dish
(
    dish_id     INT          NOT NULL AUTO_INCREMENT COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    title       VARCHAR(100) NOT NULL COMMENT '반찬의 이름',
    description VARCHAR(255) COMMENT '반찬에 대한 설명',
    price       INT          NOT NULL COMMENT '반찬의 정가',
    stock       INT          NOT NULL DEFAULT 0 COMMENT '반찬 보유 재고',
    PRIMARY KEY (dish_id)
);

DROP TABLE IF EXISTS dish_image;

CREATE TABLE dish_image
(
    dish_id       INT          NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    image_path    VARCHAR(255) NOT NULL COMMENT '반찬 이미지 경로',
    sequence      INT          NOT NULL DEFAULT 1 COMMENT '반찬 당 이미지 순서',
    PRIMARY KEY (dish_id, image_path)
);

DROP TABLE IF EXISTS dish_discount;

CREATE TABLE dish_discount
(
    dish_id       INT         NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    discount_code VARCHAR(10) NOT NULL COMMENT '할인 정보를 구분하기 위한 코드',
    PRIMARY KEY (dish_id, discount_code),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order`
(
    order_id     INT         NOT NULL AUTO_INCREMENT COMMENT 'order 테이블의 레코드를 식별하기 위한 ID',
    github_id    VARCHAR(39) NOT NULL COMMENT 'Github 유저 ID',
    dish_id      INT         NOT NULL COMMENT 'dish 테이블을 식별하기 위한 ID',
    quantity     INT         NOT NULL COMMENT '주문 시 수량',
    price        INT         NOT NULL COMMENT '주문 시 최종 가격',
    reward_point INT         NOT NULL COMMENT '주문 시 적립된 포인트',
    delivery_fee INT         NOT NULL COMMENT '주문 시 배송비',
    PRIMARY KEY (order_id),
    FOREIGN KEY (github_id) REFERENCES `user` (github_id) ON DELETE CASCADE,
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS order_delivery;

CREATE TABLE order_delivery
(
    order_id      INT         NOT NULL COMMENT 'order 테이블의 레코드를 식별하기 위한 ID',
    delivery_code VARCHAR(10) NOT NULL COMMENT '배송 정보를 구분하기 위한 코드',
    PRIMARY KEY (order_id, delivery_code),
    FOREIGN KEY (order_id) REFERENCES `order` (order_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS dish_delivery;

CREATE TABLE dish_delivery
(
    dish_id       INT         NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    delivery_code VARCHAR(10) NOT NULL COMMENT '배송 정보를 구분하기 위한 코드',
    PRIMARY KEY (dish_id, delivery_code),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    category_id   INT         NOT NULL AUTO_INCREMENT COMMENT 'category 테이블의 레코드를 식별하기 위한 ID',
    section_id    INT         NULL COMMENT 'category 상위의 section/festival 의 ID',
    category_name VARCHAR(50) NOT NULL COMMENT '카테고리의 이름',
    is_festival   BOOLEAN DEFAULT FALSE COMMENT 'festival 인지 식별하기 위한 플래그 값',
    PRIMARY KEY (category_id),
    FOREIGN KEY (section_Id) REFERENCES category (category_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS dish_category;

CREATE TABLE dish_category
(
    dish_id     INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    category_id INT NOT NULL COMMENT 'category 테이블의 레코드를 식별하기 위한 ID',
    PRIMARY KEY (dish_id, category_id),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES category (category_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS dish_recommend;

CREATE TABLE dish_recommend
(
    recommender_id INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID - 추천 요청',
    recommendee_id INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID - 추천 응답',
    PRIMARY KEY (recommender_id, recommendee_id),
    FOREIGN KEY (recommender_id) REFERENCES dish (dish_id) ON DELETE CASCADE,
    FOREIGN KEY (recommendee_id) REFERENCES dish (dish_id) ON DELETE CASCADE
);

set FOREIGN_KEY_CHECKS = 1;
