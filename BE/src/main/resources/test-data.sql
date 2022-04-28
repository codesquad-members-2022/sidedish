insert into category (name, description) values ('test-category', '테스트카테고리입니다.');

insert into event (name, description) values ('테스트이벤트', '테스트이벤트입니다.');

insert into dish(category_id, event_id, name, description, stock, price, point_percent, delivery_type, discount_policy) values (4L, 7L, '테스트디쉬', '테스트디쉬입니다.', 1, 100, 0.1, '새벽배송', '이벤트특가');

insert into image(name, dish_id) values ('테스트1.jpg', 15L);
insert into image(name, dish_id) values ('테스트2.jpg', 15L);
insert into image(name, dish_id) values ('테스트3.jpg', 15L);
