/*********/
/* 대분류 */
/*********/
insert into category (id, title, parent, exhibition_id)
values (1, '든든한 메인요리', 0, 0);

insert into category (id, title, parent, exhibition_id)
values (2, '뜨끈한 국물요리', 0, 0);

insert into category (id, title, parent, exhibition_id)
values (3, '정갈한 밑반찬', 0, 0);

/*******************/
/* 1. 든든한 메인요리 */
/*******************/
insert into category (id, title, parent, exhibition_id)
values (4, '육류 요리', 1, 0);

insert into category (id, title, parent, exhibition_id)
values (5, '해산물 요리', 1, 0);

/*******************/
/* 2. 뜨끈한 국물요리 */
/*******************/
insert into category (id, title, parent, exhibition_id)
values (6, '국/탕/찌개', 2, 0);

/******************/
/* 3. 정갈한 밑반찬 */
/******************/
insert into category (id, title, parent, exhibition_id)
values (7, '나물/무침', 3, 0);

insert into category (id, title, parent, exhibition_id)
values (8, '조림/볶음', 3, 0);

insert into category (id, title, parent, exhibition_id)
values (9, '절임/장아찌', 3, 0);

/**********************/
/* exhibition - 기획전 */
/**********************/
insert into exhibition (id, title)
values (1, '한 번 주문하면 두 번 반하는 반찬');

/************************/
/* 기획전에 속하는 카테고리 */
/************************/
insert into category (id, title, parent, exhibition_id)
values (10, '풍성한 고기 반찬', 0, 1);

insert into category (id, title, parent, exhibition_id)
values (11, '편리한 반찬 세트', 0, 1);

insert into category (id, title, parent, exhibition_id)
values (12, '맛있는 제철 요리', 0, 1);

insert into category (id, title, parent, exhibition_id)
values (13, '우리 아이 영양 반찬', 0, 1);


/*******************/
/* side_dish - 반찬 */
/*******************/

/********************************/
/* 식탁을 풍성하게 하는 정갈한 밑반찬 */
/********************************/
insert into side_dish(id, name, description, price, accrual_rate)
values (1, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 7500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (2, '호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게', 5800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (3, '한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 6990, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (4, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 990, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (5, '새콤달콤 오징어무침2', '국내산 오징어를 새콤달콤하게', 7500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (6, '호두 멸치볶음2', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게', 5800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (7, '한돈 매콤 안심장조림2', '부드러운 한돈 안심살의 매콤함', 6900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (8, '야채 어묵볶음2', '첨가물 없는 순수어묵과 야채의 만남', 4900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (9, '새콤달콤 오징어무침3', '국내산 오징어를 새콤달콤하게', 7500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (10, '호두 멸치볶음3', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게', 5800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (11, '한돈 매콤 안심장조림3', '부드러운 한돈 안심살의 매콤함', 6900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (12, '야채 어묵볶음3', '첨가물 없는 순수어묵과 야채의 만남', 4900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (13, '새콤달콤 오징어무침4', '국내산 오징어를 새콤달콤하게', 7500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (14, '호두 멸치볶음4', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게', 5800, 0.01);

/*****************************/
/* 정성이 담긴 뜨끈뜨끈 국물 요리 */
/*****************************/
insert into side_dish(id, name, description, price, accrual_rate)
values (15, '한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 9090, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (16, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (17, '미역오이냉국', '여름엔 시원한 냉국이 최고', 7800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (18, '동태찌개', '겨울철 보양식으로 안성맞춤', 10900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (19, '한돈 돼지 김치찌개2', '김치찌개에는 역시 돼지고기', 9300, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (20, '된장찌개2', '특별하지 않아서 더 좋은 우리맛', 8800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (21, '미역오이냉국2', '여름엔 시원한 냉국이 최고', 7800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (22, '동태찌개2', '겨울철 보양식으로 안성맞춤', 10900, 0.01);

/*******************************/
/* 모두가 좋아하는 든든한 메인 요리 */
/*******************************/
insert into side_dish(id, name, description, price, accrual_rate)
values (23, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 15800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (24, '잡채', '탱글한 면과 맛깔진 고명이 가득', 12900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (25, '소갈비찜', '촉촉하게 밴 양념이 일품', 48900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (26, '간장 코다리조림', '쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요', 14900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (27, '쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', 16900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (28, '오리 주물럭_반조리2', '감칠맛 나는 매콤한 양념', 15800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (29, '잡채2', '탱글한 면과 맛깔진 고명이 가득', 12900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (30, '소갈비찜2', '촉촉하게 밴 양념이 일품', 28900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (31, '간장 코다리조림2', '쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요', 14900, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (32, '쭈꾸미 한돈 제육볶음_반조리2', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', 16900, 0.01);

/*************************/
/* category_to_side_dish */
/*************************/

/* 1. 든든한 메인요리 */
insert into category_to_side_dish(category_id, side_dish_id)
values (1, 23);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 24);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 25);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 26);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 27);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 28);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 29);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 30);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 31);

insert into category_to_side_dish(category_id, side_dish_id)
values (1, 32);

/* 2. 뜨끈한 국물요리 */
insert into category_to_side_dish(category_id, side_dish_id)
values (2, 15);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 16);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 17);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 18);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 19);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 20);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 21);

insert into category_to_side_dish(category_id, side_dish_id)
values (2, 22);

/* 3. 정갈한 밑반찬 */
insert into category_to_side_dish(category_id, side_dish_id)
values (3, 1);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 2);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 3);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 4);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 5);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 6);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 7);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 8);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 9);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 10);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 11);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 12);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 13);

insert into category_to_side_dish(category_id, side_dish_id)
values (3, 14);

/*******************************/
/* side_dish_image - 반찬 이미지 */
/*******************************/
insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%83%88%EC%BD%A4%EB%8B%AC%EC%BD%A4_%EC%98%A4%EC%A7%95%EC%96%B4%EB%AC%B4%EC%B9%A8_1.png',
        1, 1 /* 새콤달콤 오징어무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%98%B8%EB%91%90_%EB%A9%B8%EC%B9%98%EB%B3%B6%EC%9D%8C_1.png',
        1, 2 /* 호두 멸치볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%95%9C%EB%8F%88_%EB%A7%A4%EC%BD%A4_%EC%95%88%EC%8B%AC%EC%9E%A5%EC%A1%B0%EB%A6%BC_1.png',
        1, 3 /* 한돈 매콤 안심장조림 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%95%BC%EC%B1%84_%EC%96%B4%EB%AC%B5%EB%B3%B6%EC%9D%8C_1.png',
        1, 4 /* 야채 어묵볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%95%9C%EB%8F%88_%EB%8F%BC%EC%A7%80_%EA%B9%80%EC%B9%98%EC%B0%8C%EA%B0%9C_1.png',
        1, 15 /* 한돈 돼지 김치찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%90%9C%EC%9E%A5%EC%B0%8C%EA%B0%9C_1.png',
        1, 16 /* 된장찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%98%A4%EC%9D%B4%EB%83%89%EA%B5%AD_1.png',
        1, 17 /* 미역오이냉국 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%8F%99%ED%83%9C%EC%B0%8C%EA%B0%9C_1.png',
        1, 18 /* 동태찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%98%A4%EB%A6%AC_%EC%A3%BC%EB%AC%BC%EB%9F%AD_%EB%B0%98%EC%A1%B0%EB%A6%AC_1.png',
        1, 23 /* 오리 주물럭_반조리 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%9E%A1%EC%B1%84_1.png',
        1, 24 /* 잡채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%86%8C%EA%B0%88%EB%B9%84%EC%B0%9C_1.png',
        1, 25 /* 소갈비찜 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B0%84%EC%9E%A5_%EC%BD%94%EB%8B%A4%EB%A6%AC%EC%A1%B0%EB%A6%BC_1.png',
        1, 26 /* 간장 코다리 조림 */);

/* no_image */
insert into side_dish_image(image_seq, side_dish_id)
values (1, 5);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 6);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 7);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 8);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 9);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 10);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 11);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 12);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 13);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 14);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 19);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 20);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 21);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 22);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 27);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 28);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 29);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 30);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 31);

insert into side_dish_image(image_seq, side_dish_id)
values (1, 32);

/******************************/
/* discount_event - 할인 이벤트 */
/******************************/
insert into discount_event(id, title, discount_rate)
values (1, '이벤트특가', 0.1);

insert into discount_event(id, title, discount_rate)
values (2, '런칭특가', 0.1);

/*******************************/
/* side_dish_to_discount_event */
/*******************************/

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (23 /* 오리 주물럭_반조리 */ , 2);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (23 /* 오리 주물럭_반조리 */ , 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (25 /* 소갈비찜 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (1 /* 새콤달콤 오징어무침 */, 2);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (2 /* 호두 멸치볶음 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (3 /* 한돈 매콤 안심장조림 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (4 /* 야채 어묵볶음 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (15 /* 한돈 돼지 김치찌개 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (16 /* 된장찌개 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (17 /* 미역오이냉국 */, 1);

insert into side_dish_to_discount_event(side_dish_id, discount_event_id)
values (24 /* 잡채 */, 1);
