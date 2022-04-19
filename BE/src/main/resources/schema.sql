drop table if exists CATEGORY;
CREATE TABLE CATEGORY(
     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30) not null,
     description VARCHAR(500)
);

drop table if exists DISH;
CREATE TABLE DISH(
     id          BIGINT PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30) not null,
     stock       INT not null,
     price       INT not null,
     category_id BIGINT,
     is_deleted  BOOLEAN default false,
     delivery_type varchar(10) not null,
     discount_policy varchar(10) not null,
     foreign key (category_id) references CATEGORY(id)
);

drop table if exists IMAGE;
CREATE TABLE IMAGE(
      id      BIGINT PRIMARY KEY AUTO_INCREMENT,
      name    VARCHAR(50) not null,
      dish_id BIGINT,
      foreign key (dish_id) references DISH(id)
);