set FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    github_id VARCHAR(39) NOT NULL COMMENT 'Github 유저 ID',
    username  VARCHAR(39) NOT NULL COMMENT '유저가 서비스에서 사용할 이름',
    point     INT         NOT NULL DEFAULT 0 COMMENT '유저가 보유한 포인트',
    PRIMARY KEY (github_id)
);

DROP TABLE IF EXISTS dish;

CREATE TABLE dish
(
    dish_id        INT          NOT NULL AUTO_INCREMENT COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    title          VARCHAR(100) NOT NULL COMMENT '반찬의 이름',
    description    VARCHAR(255) COMMENT '반찬에 대한 설명',
    price          INT          NOT NULL COMMENT '반찬의 정가',
    stock          INT          NOT NULL DEFAULT 0 COMMENT '반찬 보유 재고',
    PRIMARY KEY (dish_id)
);

DROP TABLE IF EXISTS dish_image;

CREATE TABLE dish_image
(
    dish_image_id INT          NOT NULL AUTO_INCREMENT COMMENT 'dish_image 테이블의 레코드를 식별하기 위한 ID',
    dish_id       INT          NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    image_path    VARCHAR(255) NOT NULL COMMENT '반찬 이미지 경로',
    sequence      INT          NOT NULL DEFAULT 1 COMMENT '반찬 당 이미지 순서',
    PRIMARY KEY (dish_image_id)
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
    FOREIGN KEY (github_id) REFERENCES `user` (github_id),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id)
);

DROP TABLE IF EXISTS delivery;

CREATE TABLE delivery
(
    delivery_id INT          NOT NULL AUTO_INCREMENT COMMENT 'delivery 테이블의 레코드를 식별하기 위한 ID',
    detail      VARCHAR(255) NOT NULL COMMENT '배송 정보',
    PRIMARY KEY (delivery_id)
);

DROP TABLE IF EXISTS order_delivery;

CREATE TABLE order_delivery
(
    order_id    INT NOT NULL COMMENT 'order 테이블의 레코드를 식별하기 위한 ID',
    delivery_id INT NOT NULL COMMENT 'delivery 테이블의 레코드를 식별하기 위한 ID',
    CONSTRAINT PK_order_delivery PRIMARY KEY (order_id, delivery_id),
    FOREIGN KEY (order_id) REFERENCES `order` (order_id),
    FOREIGN KEY (delivery_id) REFERENCES delivery (delivery_id)
);

DROP TABLE IF EXISTS dish_delivery;

CREATE TABLE dish_delivery
(
    dish_id     INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    delivery_id INT NOT NULL COMMENT 'delivery 테이블의 레코드를 식별하기 위한 ID',
    CONSTRAINT PK_dish_delivery PRIMARY KEY (dish_id, delivery_id),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id),
    FOREIGN KEY (delivery_id) REFERENCES delivery (delivery_id)
);

DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    category_id   INT         NOT NULL AUTO_INCREMENT COMMENT 'category 테이블의 레코드를 식별하기 위한 ID',
    section_id    INT         NULL COMMENT 'category 상위의 section/festival 의 ID',
    category_name VARCHAR(50) NOT NULL COMMENT '카테고리의 이름',
    is_festival   BOOLEAN DEFAULT FALSE COMMENT 'festival 인지 식별하기 위한 플래그 값',
    PRIMARY KEY (category_id),
    FOREIGN KEY (section_Id) REFERENCES category (category_id)
);

DROP TABLE IF EXISTS dish_category;

CREATE TABLE dish_category
(
    dish_id     INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    category_id INT NOT NULL COMMENT 'category 테이블의 레코드를 식별하기 위한 ID',
    CONSTRAINT PK_dish_category PRIMARY KEY (dish_id, category_id),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id),
    FOREIGN KEY (category_id) REFERENCES category (category_id)
);

DROP TABLE IF EXISTS event_badge;

CREATE TABLE event_badge
(
    event_badge_id   INT            NOT NULL AUTO_INCREMENT COMMENT 'event_badge 테이블의 레코드를 식별하기 위한 ID',
    event_badge_name VARCHAR(50)    NOT NULL COMMENT '이벤트 뱃지의 이름',
    discount         DECIMAL(10, 2) NOT NULL COMMENT '이벤트 뱃지의 할인율',
    PRIMARY KEY (event_badge_id)
);

DROP TABLE IF EXISTS dish_event_badge;

CREATE TABLE dish_event_badge
(
    dish_id        INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID',
    event_badge_id INT NOT NULL COMMENT 'event_badge 테이블의 레코드를 식별하기 위한 ID',
    CONSTRAINT PK_dish_event_badge PRIMARY KEY (dish_id, event_badge_id),
    FOREIGN KEY (dish_id) REFERENCES dish (dish_id),
    FOREIGN KEY (event_badge_id) REFERENCES event_badge (event_badge_id)
);

DROP TABLE IF EXISTS dish_recommend;

CREATE TABLE dish_recommend
(
    recommender_id INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID - 추천 요청',
    recommendee_id INT NOT NULL COMMENT 'dish 테이블의 레코드를 식별하기 위한 ID - 추천 응답',
    CONSTRAINT PK_dish_recommend PRIMARY KEY (recommender_id, recommendee_id),
    FOREIGN KEY (recommender_id) REFERENCES dish (dish_id),
    FOREIGN KEY (recommendee_id) REFERENCES dish (dish_id)
);

set FOREIGN_KEY_CHECKS = 1;
