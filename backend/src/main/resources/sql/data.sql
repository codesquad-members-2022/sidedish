-- user

INSERT INTO `user` (github_id, name)
VALUES ('hwicode', 'hwi');

INSERT INTO `user` (github_id, name)
VALUES ('nohriter', 'nori');


-- delivery

INSERT INTO `delivery` (delivery_pay, delivery_area, delivery_morning)
VALUES (2500, '전국 택배 배송', '서울 경기 새벽 배송');


-- category
INSERT INTO `category` (name)
VALUES ('식탁을 풍성하게 하는 정갈한 밑반찬');

INSERT INTO `category` (name)
VALUES ('정성이 담긴 뜨끈뜨끈 국물 요리');

INSERT INTO `category` (name)
VALUES ('모두가 좋아하는 든든한 메인 요리');


--event_tabs
INSERT INTO `event_tabs` (name)
VALUES ('풍성한 고기 반찬');

INSERT INTO `event_tabs` (name)
VALUES ('편리한 반찬 세트');

INSERT INTO `event_tabs` (name)
VALUES ('맛있는 제철 요리');

INSERT INTO `event_tabs` (name)
VALUES ('우리 아이 영양 반찬');


--discount_policy
INSERT INTO `discount_policy` (name, discount_rate)
VALUES ('이벤트특가', 10);

INSERT INTO `discount_policy` (name, discount_rate)
VALUES ('런칭특가', 20);


-- 메인 요리
INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(15800, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 'https://bit.ly/382HCTR', 'https://bit.ly/36xNMeo',
       null, 100, 158, 3, 1, 1);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(28900, '소갈비찜', '촉촉하게 벤 양념이 일품', 'https://bit.ly/385Pzb5', null,
       null, 100, 289, 3, 1, 1);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(16900, '쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', 'https://bit.ly/3vrZTCd', null,
       null, 100, 169, 3, 1, 1);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(12900, '잡채', '탱긓한 면과 맛깔진 고명이 가득', 'https://bit.ly/3uZBHIq', null,
       null, 100, 129, 3, 1, null);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(14900, '간장 코다리조림', '쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요', 'https://bit.ly/3xKYvgR', null,
       null, 100, 149, 3, 1, null);


-- 밑반찬
INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(7500, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 'https://bit.ly/3jS6roa', null,
       null, 100, 75, 1, 1, 2);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(5800, '호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게!', 'https://bit.ly/3xFHJ2v', null,
       null, 100, 58, 1, 1, 4);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(6900, '한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 'https://bit.ly/3EyOtAO', null,
       null, 100, 69, 1, 1, 4);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(4900, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 'https://bit.ly/3EsDpow', null,
       null, 100, 49, 1, 1, 4);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(7300, '오이소박이', null, 'https://bit.ly/3jX1kmA', null,
       null, 100, 73, 1, 1, 2);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(4300, '미나리무침', null, 'https://bit.ly/38X5sAN', null,
       null, 100, 43, 1, 1, 2);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(4300, '참외오이무침', null, 'https://bit.ly/3rD529e', null,
       null, 100, 43, 1, 1, 2);


--궁물 요리
INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(9300, '한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 'https://bit.ly/3JY6klH', null,
       null, 100, 93, 2, 1, null);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(8800, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 'https://bit.ly/3uXeKpb', null,
       null, 100, 88, 2, 1, null);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(7800, '미역오이냉국', '여름엔 시원한 냉국이 최고', 'https://bit.ly/3OoHdf9', null,
       null, 100, 78, 2, 1, 3);

INSERT INTO `dish` (price, title, description, main_image, sub_image_1,
                    sub_image_2, stock_quantity, point, category_id, delivery_id, event_tabs_id)
VALUES(10900, '동태찌개', '겨울철 보양식으로 안성맞춤', 'https://bit.ly/3vo6Xja', null,
       null, 100, 109, 2, 1, 3);



-- discount

-- 오리 주물럭_반조리
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(1, 2);

--소갈비찜
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(2, 1);

--잡채
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(4, 1);

--새콤달콤 오징어무침
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(6, 2);

--호두 멸치볶음
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(7, 1);

--한돈 매콤 안심장조림
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(8, 1);

--야채 어묵볶음
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(9, 1);

--오이소박이
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(10, 1);

--한돈 돼지 김치찌개
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(13, 1);

--된장찌개
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(14, 1);

--미역오이냉국
INSERT INTO `discount` (menu_card_id, discount_policy_id)
VALUES(15, 1);
