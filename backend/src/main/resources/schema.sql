set
foreign_key_checks = 0;

drop table if exists category;
drop table if exists exhibition;
drop table if exists category_has_side_dish;
drop table if exists side_dish;
drop table if exists side_dish_image;
drop table if exists discount_event;
drop table if exists side_dish_has_discount_event;
drop table if exists member;

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
    accrual_rate        decimal(2, 2) comment '적립률',

    shipping_info       varchar(100) default '서울 경기 새벽 배송, 전국 택배 배송' comment '배송정보',
    shipping_fee        int          default 2500 comment '배송료',
    exemption_condition int          default 40000 comment '배송비 면제 조건'
);

create table side_dish_image
(
    id           bigint primary key auto_increment,
    image_url    varchar(255) default 'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/noimage.png' comment '이미지 URL',
    image_seq    int comment '이미지 순서',
    side_dish_id bigint comment '반찬 아이디',

    foreign key (side_dish_id) references side_dish (id)
);

create table discount_event
(
    id            bigint primary key auto_increment,
    title         varchar(100) not null comment '할인 이벤트 이름',
    discount_rate decimal(2, 2) comment '할인율'
);

create table side_dish_has_discount_event
(
    side_dish_id      bigint,
    discount_event_id bigint,

    primary key (side_dish_id, discount_event_id),

    foreign key (side_dish_id) references side_dish (id)
);

create table member
(
    id       bigint primary key auto_increment,
    email    varchar(100) not null comment '이메일',
    password varchar(100) comment '비밀번호'
);

