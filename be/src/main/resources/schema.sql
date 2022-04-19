create table main_category(
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    title varchar(255) not null
)
create table sub_category(
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    main_category_id bigint not null,
    title varchar(255) not null,
    FOREIGN KEY(main_category_id) references main_category(id)
)
create table dish(
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description varchar NOT NULL,
    price int NOT NULL,
    quantity int NOT NULL,
    discount_policy varchar,
    morning_delivery boolean NOT NULL,
)
create table dish_category(
    id bigint not null AUTO_INCREMENT PRIMARY KEY,
    dish_id bigint NOT NULL,
    category_id bigint NOT NULL,
    FOREIGN KEY(dish_id) references dish(id),
    FOREIGN KEY(category_id) references sub_category(id)
)
