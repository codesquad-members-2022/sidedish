drop table if exists exhibition;

create table exhibition
(
    id    bigint primary key auto_increment,
    title varchar(100) not null comment '전시회 이름'
);

drop table if exists category;

create table category
(
    id     bigint primary key auto_increment,
    title  varchar(100) not null comment '카테고리 이름',
    parent bigint default 0 comment '대분류 카테고리'
);

drop table if exists side_dish;

create table side_dish
(
    id           bigint primary key auto_increment,
    name         varchar(100) not null comment '반찬 이름',
    description  int comment '반찬 설명',
    price        int comment '정상가격',
    accrual_rate decimal comment '적립율'
);

drop table if exists category_to_side_dish;

create table category_to_side_dish
(
    category_id  bigint,
    side_dish_id bigint,

    primary key (category_id, side_dish_id)
);


drop table if exists side_dish_image;

create table side_dish_image
(
    id           bigint primary key auto_increment,
    image_url    varchar(100) not null comment '이미지 URL',
    image_seq    int comment '이미지 순서',
    side_dish_id bigint comment '반찬 아이디'
);

drop table if exists discount_event;

create table discount_event
(
    id            bigint primary key auto_increment,
    title         varchar(100) not null comment '할인 이벤트 이름',
    discount_rate decimal comment '할인율'
);

drop table if exists side_dish_to_discount_event;

create table side_dish_to_discount_event
(
    side_dish_id      bigint,
    discount_event_id bigint,

    primary key (side_dish_id, discount_event_id)
);

drop table if exists shipping;

create table shipping
(
    id                  bigint primary key auto_increment,
    type                varchar(100) not null comment '배송 정보',
    fee                 int          not null comment '배송료',
    exemption_condition int          not null comment '배송비 면제 조건'
);

drop table if exists order_sheet;

create table order_sheet
(
    id           bigint primary key auto_increment,
    quantity     int      not null comment '배송 정보',
    total_amount decimal  not null comment '배송료',
    created_at   datetime not null comment '배송비 면제 조건',
    side_dish_id bigint   not null comment '배송 정보',
    member_id    bigint   not null comment '배송료',
    shipping_id  bigint   not null comment '배송비 면제 조건'
);

drop table if exists member;

create table member
(
    id       bigint primary key auto_increment,
    user_id  varchar(100) not null comment '회원 아이디',
    password varchar(100) comment '비밀번호',
    name     varchar(100) comment '회원 이름'
);
