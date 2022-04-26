drop table if exists orders cascade;
drop table if exists delivery cascade;
drop table if exists item_image cascade;
drop table if exists item cascade;
drop table if exists item_section cascade;
drop table if exists member cascade;
drop table if exists discount_policy cascade;

create table member
(
    member_id   bigint auto_increment,
    member_name varchar(10) not null,
    district    varchar(10),
    city        varchar(10),
    mileage     integer,
    primary key (member_id)
);

create table discount_policy
(
    discount_policy_id bigint auto_increment,
    name               varchar(10),
    discount_rate      double,
    primary key (discount_policy_id)
);

create table item_section (
    item_section_id bigint auto_increment,
    item_section_name varchar(10) unique,
    primary key (item_section_id)
);

create table item
(
    item_id            bigint auto_increment,
    name               varchar(10) not null,
    description        varchar(255),
    price              int,
    discount_policy_id bigint,
    item_section_id    bigint,
    stock              int,
    primary key (item_id),
    CONSTRAINT item_discount_constraint FOREIGN KEY (discount_policy_id) REFERENCES discount_policy (discount_policy_id) on delete cascade on update cascade,
    CONSTRAINT item_section_constraint FOREIGN KEY (item_section_id) REFERENCES item_section (item_section_id) on delete cascade on update cascade
);

create table delivery
(
    delivery_id bigint auto_increment,
    fee int,
    district    varchar(10),
    city        varchar(10),
    delivery_type varchar(10),
    primary key (delivery_id)
);

create table orders
(
    order_id           bigint auto_increment,
    item_id            bigint,
    member_id          bigint,
    delivery_id        bigint,
    discount_policy_id bigint,
    order_item_price   int,
    item_count         int,
    primary key (order_id),
    CONSTRAINT orders_item_constraint FOREIGN KEY (item_id) REFERENCES item (item_id) on delete cascade on update cascade,
    CONSTRAINT orders_member_constraint FOREIGN KEY (member_id) REFERENCES member (member_id) on delete cascade on update cascade,
    CONSTRAINT orders_delivery_constraint FOREIGN KEY (delivery_id) REFERENCES delivery (delivery_id) on delete cascade on update cascade,
    CONSTRAINT orders_discount_constraint FOREIGN KEY (discount_policy_id) REFERENCES discount_policy (discount_policy_id) on delete cascade on update cascade
);

create table item_image (
    item_image_id bigint auto_increment,
    item_image_url varchar(511),
    item_id bigint,
    item_image_sequence int,
    item_image_type varchar(10),
    primary key (item_image_id),
    CONSTRAINT image_item_constraint FOREIGN KEY (item_id) REFERENCES item (item_id) on delete cascade on update cascade
);

