drop table if exists orders, images, dish_event, item, event_category, main_category;
create table main_category
(
    id    bigint       not null AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) not null
);
create table event_category
(
    id    bigint       not null AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) not null
);
create table item
(
    id               bigint      not null AUTO_INCREMENT PRIMARY KEY,
    main_category_id bigint      NOT NULL,
    title            varchar(50) NOT NULL,
    description      varchar(60) NOT NULL,
    price            int         NOT NULL,
    quantity         int         NOT NULL,
    discount_policy  varchar(60),
    morning_delivery boolean     NOT NULL,
    FOREIGN KEY (main_category_id) references main_category (id)
);

create table dish_event
(
    id       bigint not null AUTO_INCREMENT PRIMARY KEY,
    item_id  bigint NOT NULL,
    event_id bigint NOT NULL,
    FOREIGN KEY (item_id) references item (id),
    FOREIGN KEY (event_id) references event_category (id)
);

create table images
(
    id          bigint      not null AUTO_INCREMENT PRIMARY KEY,
    item_id     bigint      NOT NULL,
    url         varchar(255) NOT NULL,
    main_status boolean     NOT NULL,
    FOREIGN KEY (item_id) references item (id)
);

create table orders
(
    id             bigint not null AUTO_INCREMENT PRIMARY KEY,
    item_id        bigint NOT NULL,
    order_quantity int    NOT NULL,
    delivery_fee   boolean,
    total_price    int    NOT NULL,
    FOREIGN KEY (item_id) references item (id)
);
