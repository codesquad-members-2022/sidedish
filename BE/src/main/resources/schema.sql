drop table if exists CATEGORY;
CREATE TABLE CATEGORY(
     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30) not null,
     description VARCHAR(500)

);

CREATE TABLE SUB_CATEGORY(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,

);


drop table if exists DISH;
CREATE TABLE DISH(
     id              BIGINT PRIMARY KEY AUTO_INCREMENT,
     category_id     BIGINT,
     name            VARCHAR(30) not null,
     stock           INT not null,
     price           DOUBLE not null,
     point_percent   DOUBLE NOT NULL,
     delivery_type   VARCHAR(10) not null,
     discount_policy VARCHAR(10) not null,
     is_deleted      BOOLEAN default false, -- 도메인에 넣을지 말지?
     foreign key (category_id) references CATEGORY(id)
);

drop table if exists IMAGE;
CREATE TABLE IMAGE(
      id      BIGINT PRIMARY KEY AUTO_INCREMENT,
      name    VARCHAR(50) not null,
      dish_id BIGINT,
      foreign key (dish_id) references DISH(id)
);