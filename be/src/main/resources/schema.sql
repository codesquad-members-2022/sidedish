drop table if exists `order`, member, image, item_event, item, event_category, sub_category, main_category;

create table main_category
(
    id    bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) NOT NULL
);

create table sub_category
(
    id               bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    main_category_id bigint       NOT NULL,
    title            varchar(255) NOT NULL,
    FOREIGN KEY (main_category_id) references main_category (id)
);

create table event_category
(
    id    bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) NOT NULL
);
create table item
(
    id               bigint      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    main_category_id bigint      NOT NULL,
    title            varchar(50) NOT NULL,
    description      varchar(60) NOT NULL,
    price            int         NOT NULL,
    quantity         int         NOT NULL,
    discount_policy  varchar(60),
    morning_delivery boolean     NOT NULL,
    FOREIGN KEY (main_category_id) references main_category (id)
);

create table item_event
(
    id       bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_id  bigint NOT NULL,
    event_id bigint NOT NULL,
    FOREIGN KEY (item_id) references item (id),
    FOREIGN KEY (event_id) references event_category (id)
);

create table image
(
    id          bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    item_id     bigint       NOT NULL,
    url         varchar(255) NOT NULL,
    main_status boolean      NOT NULL,
    FOREIGN KEY (item_id) references item (id)
);
create table member
(
    id           bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email        varchar(60)  NOT NULL,
    access_token varchar(255) NOT NULL,
    `scope`      varchar(255) NOT NULL,
    token_type    varchar(255) NOT NULL
);

create table `order`
(
    id             bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    member_id      bigint NOT NULL,
    item_id        bigint NOT NULL,
    order_quantity int    NOT NULL,
    total_price    int    NOT NULL,
    FOREIGN KEY (item_id) references item (id),
    FOREIGN KEY (member_id) references member (id)
);
