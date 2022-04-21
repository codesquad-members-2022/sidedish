/* exhibition */
insert into exhibition (id, title)
values (1, '일반 진열 상품');

insert into exhibition (id, title)
values (2, '한 번 주문하면 두 번 반하는 반찬');

/* category */
insert into category (id, title, exhibition_id)
values (1, '든든한 메인요리', 1);

insert into category (id, title, exhibition_id)
values (2, '뜨끈한 국물요리', 1);

insert into category (id, title, exhibition_id)
values (3, '정갈한 밑반찬', 1);

insert into category (id, title, exhibition_id)
values (4, '풍성한 고기 반찬', 2);

insert into category (id, title, exhibition_id)
values (5, '편리한 반찬 세트', 2);

insert into category (id, title, exhibition_id)
values (6, '맛있는 제철 요리', 2);

insert into category (id, title, exhibition_id)
values (7, '우리 아이 영양 반찬', 2);

/* category_has_side_dish */
insert into category_has_side_dish (category_id, side_dish_id)
values (1, 9);

insert into category_has_side_dish (category_id, side_dish_id)
values (1, 10);

insert into category_has_side_dish (category_id, side_dish_id)
values (1, 11);

insert into category_has_side_dish (category_id, side_dish_id)
values (1, 12);

insert into category_has_side_dish (category_id, side_dish_id)
values (1, 13);

insert into category_has_side_dish (category_id, side_dish_id)
values (2, 5);

insert into category_has_side_dish (category_id, side_dish_id)
values (2, 6);

insert into category_has_side_dish (category_id, side_dish_id)
values (2, 7);

insert into category_has_side_dish (category_id, side_dish_id)
values (2, 8);

insert into category_has_side_dish (category_id, side_dish_id)
values (3, 1);

insert into category_has_side_dish (category_id, side_dish_id)
values (3, 2);

insert into category_has_side_dish (category_id, side_dish_id)
values (3, 3);

insert into category_has_side_dish (category_id, side_dish_id)
values (3, 4);

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 9);

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 11);

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 13);

/* side_dish */
insert into side_dish(id, name, description, price, accrual_rate)
values (1, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 7500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (2, '호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게!', 5800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (3, '한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 6900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (4, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 4900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (5, '한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 9300, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (6, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (7, '미역오이냉국', '여름엔 시원한 냉국이 최고', 7800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (8, '동태찌개', '겨울철 보양식으로 안성맞춤', 10900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (9, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 15800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (10, '잡채', '탱글한 면과 맛깔진 고명이 가득', 12900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (11, '소갈비찜', '촉촉하게 밴 양념이 일품', 28900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (12, '간장 코다리조림', '쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요', 14900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (13, '쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', 16900, 0.01);
