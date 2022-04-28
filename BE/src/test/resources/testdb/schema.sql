drop table if exists orders;
drop table if exists product_image;
drop table if exists product;
drop table if exists discount_policy;
drop table if exists delivery_policy;

create table discount_policy
(
    id            bigint auto_increment primary key,
    discount_rate int          not null,
    policy_name   varchar(100) not null
);

create table delivery_policy
(
    id                        bigint auto_increment primary key,
    delivery_info             varchar(100) not null,
    delivery_charge           int          not null,
    free_delivery_over_amount int          not null
);

create table product
(
    id                 bigint auto_increment primary key,
    discount_policy_id bigint,
    delivery_policy_id bigint,
    product_name       varchar(100) not null,
    description        varchar(1000),
    original_price     int          not null,
    stock_quantity     int          not null,
    meal_category      varchar(100) not null,
    best_category      varchar(100),
    foreign key (discount_policy_id) references discount_policy (id),
    foreign key (delivery_policy_id) references delivery_policy (id)
);

create table product_image
(
    id         bigint auto_increment primary key,
    product_id bigint        not null,
    image_url  varchar(1000) not null,
    foreign key (product_id) references product (id)
);

create table orders
(
    id              bigint          auto_increment primary key,
    product_id      bigint          not null,
    total_price     bigint          not null,
    count           bigint          not null,
    delivery_price  bigint          not null,
    foreign key (product_id) references product (id)
);
