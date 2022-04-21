set
foreign_key_checks = 0;

drop table if exists category;
drop table if exists exhibition;
drop table if exists category_has_side_dish;
drop table if exists side_dish;

set
foreign_key_checks = 1;

create table exhibition
(
    id    bigint primary key auto_increment,
    title varchar(100) not null comment '기획전 이름'
);

create table category
(
    id            bigint primary key auto_increment,
    title         varchar(100) not null comment '카테고리 이름',
    exhibition_id bigint default 1 comment '기획전 아이디',

    foreign key (exhibition_id) references exhibition (id)
);

create table category_has_side_dish
(
    category_id  bigint,
    side_dish_id bigint,

    primary key (category_id, side_dish_id),

    foreign key (category_id) references category (id)
);

create table side_dish
(
    id                  bigint primary key auto_increment,
    name                varchar(100) not null comment '반찬 이름',
    description         varchar(100) comment '반찬 설명',
    price               int comment '정상가격',
    accrual_rate        decimal(2, 2) comment '적립율',

    shipping_info       varchar(100) default '서울 경기 새벽 배송, 전국 택배 배송' comment '배송정보',
    shipping_fee        int          default 2500 comment '배송료',
    exemption_condition int          default 40000 comment '배송비 면제 조건'
);