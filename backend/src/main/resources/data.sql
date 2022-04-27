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

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 14);

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 15);

insert into category_has_side_dish (category_id, side_dish_id)
values (4, 16);

insert into category_has_side_dish (category_id, side_dish_id)
values (5, 17);

insert into category_has_side_dish (category_id, side_dish_id)
values (5, 18);

insert into category_has_side_dish (category_id, side_dish_id)
values (5, 19);

insert into category_has_side_dish (category_id, side_dish_id)
values (5, 20);

insert into category_has_side_dish (category_id, side_dish_id)
values (5, 21);

insert into category_has_side_dish (category_id, side_dish_id)
values (6, 22);

insert into category_has_side_dish (category_id, side_dish_id)
values (6, 23);

insert into category_has_side_dish (category_id, side_dish_id)
values (6, 24);

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

insert into side_dish(id, name, description, price, accrual_rate)
values (14, '간장돼지불고기', '국내산 생고기에 수제양념', 6800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (15, '지리산흑돼지갈비찜', '초신선 No 조미료, 지리산에서온', 15800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (16, '고추장제육볶음', '흑돼지에 남도식 양념', 6800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (17, '만가닥버섯볶음', '슴슴한 맛 건강푸드', 4000, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (18, '해파리냉채', '탱글탱글 톡 쏘는 매력', 3800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (19, '미역초무침', '새콤달콤 부들부들한 식감의', 3500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (20, '무생채', '시원새콤 깔끔한 맛', 3500, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (21, '오징어도라지초무침', '새콤 향긋 국내산 도라지', 5800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (22, '취나물', '', 3800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (23, '바지락초무침[밀키트]', '', 8800, 0.01);

insert into side_dish(id, name, description, price, accrual_rate)
values (24, '바지락애호박볶음', '쫄깃하고 아삭한', 4800, 0.01);

/* side_dish_image */

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
        1, 5 /* 한돈 돼지 김치찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%90%9C%EC%9E%A5%EC%B0%8C%EA%B0%9C_1.png',
        1, 6 /* 된장찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%98%A4%EC%9D%B4%EB%83%89%EA%B5%AD_1.png',
        1, 7 /* 미역오이냉국 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%8F%99%ED%83%9C%EC%B0%8C%EA%B0%9C_1.png',
        1, 8 /* 동태찌개 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%98%A4%EB%A6%AC_%EC%A3%BC%EB%AC%BC%EB%9F%AD_%EB%B0%98%EC%A1%B0%EB%A6%AC_1.png',
        1, 9 /* 오리 주물럭_반조리 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%9E%A1%EC%B1%84_1.png',
        1, 10 /* 잡채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%86%8C%EA%B0%88%EB%B9%84%EC%B0%9C_1.png',
        1, 11 /* 소갈비찜 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B0%84%EC%9E%A5_%EC%BD%94%EB%8B%A4%EB%A6%AC%EC%A1%B0%EB%A6%BC_1.png',
        1, 12 /* 간장 코다리 조림 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%AD%88%EA%BE%B8%EB%AF%B8+%ED%95%9C%EB%8F%88+%EC%A0%9C%EC%9C%A1%EB%B3%B6%EC%9D%8C_%EB%B0%98%EC%A1%B0%EB%A6%AC_1.png',
        1, 13 /* 쭈꾸미 한돈 제육볶음_반조리 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B0%84%EC%9E%A5%EB%8F%BC%EC%A7%80%EB%B6%88%EA%B3%A0%EA%B8%B0_1.png',
        1, 14 /* 간장돼지불고기 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B0%84%EC%9E%A5%EB%8F%BC%EC%A7%80%EB%B6%88%EA%B3%A0%EA%B8%B0_2.png',
        2, 14 /* 간장돼지불고기 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B0%84%EC%9E%A5%EB%8F%BC%EC%A7%80%EB%B6%88%EA%B3%A0%EA%B8%B0_3.png',
        3, 14 /* 간장돼지불고기 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%A7%80%EB%A6%AC%EC%82%B0%ED%9D%91%EB%8F%BC%EC%A7%80%EA%B0%88%EB%B9%84%EC%B0%9C_1.png',
        1, 15 /* 지리산흑돼지갈비찜 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%A7%80%EB%A6%AC%EC%82%B0%ED%9D%91%EB%8F%BC%EC%A7%80%EA%B0%88%EB%B9%84%EC%B0%9C_2.png',
        2, 15 /* 지리산흑돼지갈비찜 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%A7%80%EB%A6%AC%EC%82%B0%ED%9D%91%EB%8F%BC%EC%A7%80%EA%B0%88%EB%B9%84%EC%B0%9C_3.png',
        3, 15 /* 지리산흑돼지갈비찜 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B3%A0%EC%B6%94%EC%9E%A5%EC%A0%9C%EC%9C%A1%EB%B3%B6%EC%9D%8C_1.png',
        1, 16 /* 고추장제육볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B3%A0%EC%B6%94%EC%9E%A5%EC%A0%9C%EC%9C%A1%EB%B3%B6%EC%9D%8C_2.png',
        2, 16 /* 고추장제육볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EA%B3%A0%EC%B6%94%EC%9E%A5%EC%A0%9C%EC%9C%A1%EB%B3%B6%EC%9D%8C_3.png',
        3, 16 /* 고추장제육볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%A7%8C%EA%B0%80%EB%8B%A5%EB%B2%84%EC%84%AF%EB%B3%B6%EC%9D%8C_1.png',
        1, 17 /* 만가닥버섯볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%A7%8C%EA%B0%80%EB%8B%A5%EB%B2%84%EC%84%AF%EB%B3%B6%EC%9D%8C_2.png',
        2, 17 /* 만가닥버섯볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%95%B4%ED%8C%8C%EB%A6%AC%EB%83%89%EC%B1%84_1.png',
        1, 18 /* 해파리냉채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%95%B4%ED%8C%8C%EB%A6%AC%EB%83%89%EC%B1%84_2.png',
        2, 18 /* 해파리냉채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%ED%95%B4%ED%8C%8C%EB%A6%AC%EB%83%89%EC%B1%84_3.png',
        3, 18 /* 해파리냉채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_1.png',
        1, 19 /* 미역초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_2.png',
        2, 19 /* 미역초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_3.png',
        3, 19 /* 미역초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AC%B4%EC%83%9D%EC%B1%84_1.png',
        1, 20 /* 무생채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AC%B4%EC%83%9D%EC%B1%84_2.png',
        2, 20 /* 무생채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AC%B4%EC%83%9D%EC%B1%84_3.png',
        3, 20 /* 무생채 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%98%A4%EC%A7%95%EC%96%B4%EB%8F%84%EB%9D%BC%EC%A7%80%EC%B4%88%EB%AC%B4%EC%B9%A8_1.png',
        1, 21 /* 오징어도라지초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%98%A4%EC%A7%95%EC%96%B4%EB%8F%84%EB%9D%BC%EC%A7%80%EC%B4%88%EB%AC%B4%EC%B9%A8_2.png',
        2, 21 /* 오징어도라지초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%98%A4%EC%A7%95%EC%96%B4%EB%8F%84%EB%9D%BC%EC%A7%80%EC%B4%88%EB%AC%B4%EC%B9%A8_3.png',
        3, 21 /* 오징어도라지초무침 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%B7%A8%EB%82%98%EB%AC%BC_1.png',
        1, 22 /* 취나물 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%B7%A8%EB%82%98%EB%AC%BC_2.png',
        2, 22 /* 취나물 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EC%B7%A8%EB%82%98%EB%AC%BC_3.png',
        3, 22 /* 취나물 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%B4%88%EB%AC%B4%EC%B9%A8%5B%EB%B0%80%ED%82%A4%ED%8A%B8%5D_1.png',
        1, 23 /* 바지락초무침[밀키트] */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%B4%88%EB%AC%B4%EC%B9%A8%5B%EB%B0%80%ED%82%A4%ED%8A%B8%5D_2.png',
        2, 23 /* 바지락초무침[밀키트] */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%B4%88%EB%AC%B4%EC%B9%A8%5B%EB%B0%80%ED%82%A4%ED%8A%B8%5D_3.png',
        3, 23 /* 바지락초무침[밀키트] */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%95%A0%ED%98%B8%EB%B0%95%EB%B3%B6%EC%9D%8C_1.png',
        1, 24 /* 바지락애호박볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%95%A0%ED%98%B8%EB%B0%95%EB%B3%B6%EC%9D%8C_2.png',
        2, 24 /* 바지락애호박볶음 */);

insert into side_dish_image(image_url, image_seq, side_dish_id)
values ('https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%B0%94%EC%A7%80%EB%9D%BD%EC%95%A0%ED%98%B8%EB%B0%95%EB%B3%B6%EC%9D%8C_3.png',
        3, 24 /* 바지락애호박볶음 */);

-- insert into side_dish_image(image_url, image_seq, side_dish_id)
-- values ('',
--         1, 25 /* 바지락애호박볶음 */);

/* discount_event */

insert into discount_event(id, title, discount_rate)
values (1, '이벤트특가', 0.1);

insert into discount_event(id, title, discount_rate)
values (2, '런칭특가', 0.1);

/* side_dish_has_discount_event */

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (9 /* 오리 주물럭_반조리 */ , 2);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (9 /* 오리 주물럭_반조리 */ , 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (11 /* 소갈비찜 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (1 /* 새콤달콤 오징어무침 */, 2);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (2 /* 호두 멸치볶음 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (3 /* 한돈 매콤 안심장조림 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (4 /* 야채 어묵볶음 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (5 /* 한돈 돼지 김치찌개 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (6 /* 된장찌개 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (7 /* 미역오이냉국 */, 1);

insert into side_dish_has_discount_event(side_dish_id, discount_event_id)
values (10 /* 잡채 */, 1);
