insert into main_category (name, description) values ('반찬', '맛있음');
insert into main_category (name, description) values ('메인', '두배로맛있음');
insert into sub_category (name, description) values ('짱짱반찬', '짱맛있음');

insert into dish(main_category_id, sub_category_id, name, description, stock, price, point_percent, delivery_type, discount_policy) values (1L, 1L, '짱민아침', '먹으면 짱민처럼 멋있어지는 메뉴', 10, 10000, 0.5, '새벽배송', 'FIX');
insert into dish(main_category_id, sub_category_id, name, description, stock, price, point_percent, delivery_type, discount_policy) values (1L, 1L, '짱민점심', '먹으면 짱민처럼 잘생겨지는 메뉴', 10, 10000, 0.5, '새벽배송', 'FIX');
insert into dish(main_category_id, sub_category_id, name, description, stock, price, point_percent, delivery_type, discount_policy) values (1L, 1L, '짱민저녁', '먹으면 짱민처럼 키커지는 메뉴', 10, 10000, 0.5, '새벽배송', 'FIX');
insert into dish(main_category_id, sub_category_id, name, description, stock, price, point_percent, delivery_type, discount_policy) values (2L, 1L, '짱민야식', '먹으면 짱민처럼 존잘되는 메뉴', 10, 10000, 0.5, '새벽배송', 'FIX');

insert into image(name, dish_id) values ('짱민아침메인사진.jpg',1L);
insert into image(name, dish_id) values ('짱민아침서브사진.jpg',1L);
insert into image(name, dish_id) values ('짱민아침디테일사진.jpg',1L);
insert into image(name, dish_id) values ('짱민점심메인사진.jpg',2L);
