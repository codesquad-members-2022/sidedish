DROP TABLE IF EXISTS image_file;
DROP TABLE IF EXISTS user_order;
DROP TABLE IF EXISTS sidedish;
DROP TABLE IF EXISTS discount_policy;
DROP TABLE IF EXISTS menu_category;
DROP TABLE IF EXISTS event_category;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS user;

CREATE TABLE event
(
    id            INT NOT NULL AUTO_INCREMENT,
    name          VARCHAR(32),
    progress_flag TINYINT(1) DEFAULT 0 COMMENT '이벤트 진행 유무 : 진행 안함 0, 진행 중 1',
    PRIMARY KEY (id)
);

CREATE TABLE event_category
(
    id       INT NOT NULL AUTO_INCREMENT,
    event_id INT NOT NULL,
    name     VARCHAR(32),
    PRIMARY KEY (id),
    FOREIGN KEY (event_id) REFERENCES event (id)
);

CREATE TABLE menu_category
(
    id   INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE discount_policy
(
    id            INT NOT NULL AUTO_INCREMENT,
    discount_type VARCHAR(32),
    discount_rate INT,
    PRIMARY KEY (id)
);

CREATE TABLE sidedish
(
    id                         INT NOT NULL AUTO_INCREMENT,
    event_category_id          INT,
    menu_category_id           INT NOT NULL,
    discount_policy_id         INT,
    name                       VARCHAR(32),
    description                VARCHAR(64),
    dawn_delivery_flag         TINYINT(1) DEFAULT 0 COMMENT '새벽배송 가능 유무 : 불가 0, 가능 : 1',
    whole_nation_delivery_flag TINYINT(1) DEFAULT 0 COMMENT '전국 택배 가능 유무 : 불가 0, 가능 : 1',
    price                      INT,
    created_datetime           TIMESTAMP,
    modified_datetime          TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (event_category_id) REFERENCES event_category (id),
    FOREIGN KEY (menu_category_id) REFERENCES menu_category (id),
    FOREIGN KEY (discount_policy_id) REFERENCES discount_policy (id)
);

CREATE TABLE image_file
(
    id                INT         NOT NULL AUTO_INCREMENT,
    sidedish_id       INT         NOT NULL,
    file_name         VARCHAR(32),
    save_file_name    VARCHAR(32),
    content_type      VARCHAR(32) COMMENT 'image/png, image/jpg 등',
    image_type        VARCHAR(32) NOT NULL COMMENT 'ma : 메인 사진, etc : 기타 사진',
    delete_flag       TINYINT(1) DEFAULT 0 COMMENT '삭제 유무 : 존재 0, 삭제 : 1',
    created_datetime  TIMESTAMP,
    modified_datetime TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (sidedish_id) REFERENCES sidedish (id)
);

CREATE TABLE user
(
    id    INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE user_order
(
    id                INT NOT NULL AUTO_INCREMENT,
    user_id           INT NOT NULL,
    sidedish_id       INT NOT NULL,
    quantity    INT NOT NULL,
    total_price       INT NOT NULL,
    fee               INT NOT NULL,
    point             INT NOT NULL,
    created_datetime  TIMESTAMP,
    modified_datetime TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (sidedish_id) REFERENCES sidedish (id)
);

