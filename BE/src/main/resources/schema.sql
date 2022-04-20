
CREATE TABLE MAIN_CATEGORY(
      id          BIGINT PRIMARY KEY AUTO_INCREMENT,
      name        VARCHAR(30) not null,
      description VARCHAR(500)
);

CREATE TABLE SUB_CATEGORY(
     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30) not null,
     description VARCHAR(500),
     main_category_id BIGINT,
     FOREIGN KEY (main_category_id) references MAIN_CATEGORY(id)
);


drop table if exists DISH;
CREATE TABLE DISH(
     id               BIGINT PRIMARY KEY AUTO_INCREMENT,
     main_category_id BIGINT,
     sub_category_id  BIGINT,
     name             VARCHAR(30) not null,
     stock            INT not null,
     price            DOUBLE not null,
     point_percent    DOUBLE NOT NULL,
     delivery_type    VARCHAR(10) not null,
     discount_policy  VARCHAR(10) not null,
     is_deleted       BOOLEAN default false, -- 도메인에 넣을지 말지?
     foreign key (main_category_id) references MAIN_CATEGORY(id),
     foreign key (sub_category_id) references SUB_CATEGORY(id)
);

drop table if exists IMAGE;
CREATE TABLE IMAGE(
      id      BIGINT PRIMARY KEY AUTO_INCREMENT,
      name    VARCHAR(50) not null,
      dish_id BIGINT,
      dish_key INT,
      foreign key (dish_id) references DISH(id)
);

CREATE TABLE USER(
    id BIGINT PRIMARY KEY,
    name varchar(20) NOT NULL,
    address varchar(100) NOT NULL
);

-- -- 장바구니 안됨
-- CREATE TABLE ORDER(
--     id BIGINT PRIMARY KEY,
--     user_id BIGINT,
--     dish_id BIGINT,
--     shipping_address varchar(100) NOT NULL,
--     quantity BIGINT NOT NULL,
--     delivery_fee BIGINT NOT NULL,
--     total_price BIGINT NOT NULL,
--     order_datetime datetime NOT NULL,
--     foreign key (user_id) references USER(id),
--     foreign key (dish_id) references DISH(id)
-- );
