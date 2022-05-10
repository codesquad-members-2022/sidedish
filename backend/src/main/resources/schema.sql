DROP TABLE IF EXISTS product_order, user, image, product;

CREATE TABLE product (
                         id              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         product_name    varchar(64) NOT NULL,
                         description     varchar(255) NOT NULL,
                         early_delivery  TINYINT DEFAULT true,
                         price           int NOT NULL,
                         stock           int NOT NULL,
                         event_badge     varchar(64) NOT NULL COMMENT '이벤트 종류 : none, event, launching',
                         main_category   varchar(64) NOT NULL COMMENT '메인카테고리 : main, soup, side',
                         event_category  varchar(64) NOT NULL COMMENT '기획전카테고리 : meat, simple, season, kids'
);

CREATE TABLE image (
                      id                 BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      product_id         BIGINT NOT NULL,
                      image_path         varchar(255) NOT NULL,
                      FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE user (
                      id                 BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      address            varchar(255) NOT NULL,
                      name               varchar(32) NOT NULL
);

CREATE TABLE product_order(
                      id                BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      product_id        BIGINT NOT NULL,
                      user_id           BIGINT NOT NULL,
                      quantity          int,
                      price             int,
                      FOREIGN KEY (product_id) REFERENCES product(id),
                      FOREIGN KEY (user_id) REFERENCES user(id)
);
