-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
INSERT INTO `category` (`name`, `description`)
VALUES ('든든한 메인요리', '모두가 좋아하는 든든한 메인요리'),
       ('뜨끈한 국물요리', '정성이 담긴 뜨끈뜨끈 국물요리'),
       ('정갈한 밑반찬', '식탁을 풍성하게 하는 정갈한 밑반찬');


-- -----------------------------------------------------
-- Data for table `subcategory`
-- -----------------------------------------------------
INSERT INTO `subcategory` (`name`, `description`, `category_id`)
VALUES ('육류 요리', '육류 요리', 1),
       ('해산물 요리', '해산물 요리', 1),
       ('국/탕/찌개', '국/탕/찌개', 2),
       ('나물/무침', '나물/무침', 3),
       ('조림/볶음', '조림/볶음', 3),
       ('절임/장아찌', '절임/장아찌', 3);


-- -----------------------------------------------------
-- Data for table `theme`
-- -----------------------------------------------------
INSERT INTO `theme` (`name`)
VALUES ('풍성한 고기 반찬'),
       ('편리한 반찬 세트'),
       ('맛있는 제철 요리'),
       ('우리 아이 영양 반찬');


-- -----------------------------------------------------
-- Data for table `discount`
-- -----------------------------------------------------
INSERT INTO `discount` (`name`, `discount_rate`)
VALUES ('런칭특가', 0.2),
       ('이벤트특가', 0.1);


-- -----------------------------------------------------
-- Data for table `delivery_policy`
-- -----------------------------------------------------
INSERT INTO `delivery_policy`
(`description`, `early_morning_delivery`, `nationwide_delivery`, `delivery_rate`, `free_delivery_threshold`)
VALUES ('기본배송정책', true, true, 2500, 40000);


-- -----------------------------------------------------
-- Data for table `products`
-- -----------------------------------------------------
INSERT INTO `product`
(`name`, `description`, `price`, `mileage_rate`, `stock`,
 `primary_image`, `category_id`, `subcategory_id`, `delivery_policy_id`)
VALUES ('불고기 잡채', '아이들 입맛에 딱 맞는', 14800, 0.01, 11,
        'https://zipbanchan.godohosting.com/800X800px/3_main/1203_ZIP_P_6234_T.jpg', 1, 1, 1),
       ('매운돼지갈비찜', '촉촉하게 밴 양념이 일품', 19800, 0.01, 8,
        'https://zipbanchan.godohosting.com/800X800px/3_main/350_ZIP_P_0025_T.jpg', 1, 1, 1),
       ('한돈 매콤 제육볶음_반조리', '밥 반찬으로 제육볶음은 진리입니다', 9800, 0.01, 7,
        'https://zipbanchan.godohosting.com/800X800px/3_main/1339_ZIP_P_0088_T.jpg', 1, 1, 1),
       ('오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 15800, 0.01, 6,
        'https://zipbanchan.godohosting.com/800X800px/3_main/1351_ZIP_P_0108_T.jpg', 1, 1, 1),
       ('오징어 야채볶음_반조리', '국내산 오징어와 싱싱한 야채의 환상궁합', 16800, 0.01, 9,
        'https://zipbanchan.godohosting.com/800X800px/3_main/1352_ZIP_P_0106_T.jpg', 1, 2, 1),
       ('주꾸미 야채볶음_반조리', '밥 비벼 먹으면 매콤하게 한 그릇 뚝딱!', 15800, 0.01, 5,
        'https://zipbanchan.godohosting.com/800X800px/3_main/1351_ZIP_P_0108_T.jpg', 1, 2, 1),
       ('시래기 된장국(냉동)', '구수하면서도 시원한 맛', 7800, 0.01, 7,
        'https://zipbanchan.godohosting.com/800X800px/9_soup/176_ZIP_P_2004_T.jpg', 2, 3, 1),
       ('감자국', '국내산 감자라 더 고소한', 7800, 0.01, 8,
        'https://zipbanchan.godohosting.com/800X800px/9_soup/1367_ZIP_P_1046_T.jpg', 2, 3, 1),
       ('맑은 동태국', '시원함과 감칠맛은 그대로 담은 맑은 국', 8800, 0.01, 5,
        'https://zipbanchan.godohosting.com/800X800px/9_soup/842_ZIP_P_1035_T.jpg', 2, 3, 1),
       ('한우 소고기 감자국', '깔끔하고 담백한 국물', 11800, 0.01, 4,
        'https://zipbanchan.godohosting.com/800X800px/9_soup/1368_ZIP_P_1047_T.jpg', 2, 3, 1),
       ('오징어찌개', '매콤 쫄깃한 매력', 13800, 0.01, 9,
        'https://zipbanchan.godohosting.com/800X800px/9_soup/819_ZIP_P_1034_T.jpg', 2, 3, 1),
       ('콩나물무침', '국내산 참깨기름으로 고소하게', 3800, 0.01, 4,
        'https://zipbanchan.godohosting.com/800X800px/8_muchim/128_ZIP_P_5009_T.jpg', 3, 4, 1),
       ('시금치나물', '국내산 참깨기름으로 향긋하게 무쳤어요', 3300, 0.01, 6,
        'http://zipbanchan.godohosting.com/800X800px/8_muchim/31_ZIP_P_5001_T.jpg', 3, 4, 1),
       ('무나물', '푹 익혀서 먹기 편해요', 3400, 0.01, 8,
        'https://zipbanchan.godohosting.com/800X800px/8_muchim/39_ZIP_P_5005_T.jpg', 3, 4, 1),
       ('가지무침', '국산 가지를 부드럽고 담백하게 무쳤어요', 3600, 0.01, 3,
        'https://zipbanchan.godohosting.com/800X800px/8_muchim/1188_ZIP_P_5134_T.jpg', 3, 4, 1),
       ('쑥갓 두부무침', '고소한 내음 솔솔', 3900, 0.01, 4,
        'http://zipbanchan.godohosting.com/800X800px/8_muchim/715_ZIP_P_5064_T.jpg', 3, 4, 1),
       ('감자채볶음', '고소하면서 담백한 감자채볶음', 3400, 0.01, 10,
        'https://zipbanchan.godohosting.com/800X800px/7_fry/71_ZIP_P_6001_T.jpg', 3, 5, 1),
       ('감자햄볶음', '우리 아이 최애 반찬', 3900, 0.01, 5,
        'https://zipbanchan.godohosting.com/800X800px/7_fry/580_ZIP_P_6089_T.jpg', 3, 5, 1),
       ('건호박볶음', '별미반찬 국내산 건호박볶음이에요', 4600, 0.01, 4,
        'https://zipbanchan.godohosting.com/800X800px/7_fry/1194_ZIP_P_6215_T.jpg', 3, 5, 1),
       ('야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 4900, 0.01, 8,
        'https://zipbanchan.godohosting.com/800X800px/7_fry/84_ZIP_P_6006_T.jpg', 3, 5, 1),
       ('깻잎 장아찌', '국산 콩간장으로 절여 건강한', 3600, 0.01, 7,
        'https://zipbanchan.godohosting.com/800X800px/10_kimchi/242_ZIP_P_3037_T.jpg', 3, 6, 1);


-- -----------------------------------------------------
-- Data for table `variant_image`
-- -----------------------------------------------------
INSERT INTO `variant_image` (`product_id`, `url`)
VALUES (1, 'http://zipbanchan.godohosting.com/detail_page/3_main/1203_ZIP_P_6234_S.jpg'),
       (2, 'http://zipbanchan.godohosting.com/detail_page/3_main/350_ZIP_P_0025_S.jpg'),
       (3, 'http://zipbanchan.godohosting.com/detail_page/3_main/1339/1339_ZIP_P_0088_S.jpg'),
       (3, 'http://zipbanchan.godohosting.com/detail_page/3_main/1339/1339_ZIP_P_0088_damumsae.jpg'),
       (3, 'http://zipbanchan.godohosting.com/detail_page/3_main/1339/1339_ZIP_P_0088_how_to_cook_3.jpg'),
       (4, 'http://zipbanchan.godohosting.com/detail_page/3_main/1351/1351_ZIP_P_0108_S.jpg'),
       (4, 'http://zipbanchan.godohosting.com/detail_page/3_main/1351/1351_ZIP_P_0108_how_to_cook_3.jpg'),
       (5, 'http://zipbanchan.godohosting.com/detail_page/3_main/1352/1352_ZIP_P_0106_S.jpg'),
       (5, 'http://zipbanchan.godohosting.com/detail_page/3_main/1352/1352_ZIP_P_0106_damumsae.jpg'),
       (5, 'http://zipbanchan.godohosting.com/detail_page/3_main/1352/1352_ZIP_P_0106_how_to_cook_3.jpg'),
       (6, 'http://zipbanchan.godohosting.com/detail_page/3_main/1353/1353_ZIP_P_0103_S.jpg'),
       (6, 'http://zipbanchan.godohosting.com/detail_page/3_main/1353/1353_ZIP_P_0103_damumsae.jpg'),
       (6, 'http://zipbanchan.godohosting.com/detail_page/3_main/1353/1353_ZIP_P_0103_how_to_cook_4.jpg'),
       (7, 'http://zipbanchan.godohosting.com/detail_page/9_soup/176_ZIP_P_2004_S.jpg'),
       (8, 'http://zipbanchan.godohosting.com/detail_page/9_soup/1367_ZIP_P_1046_S.jpg'),
       (9, 'http://zipbanchan.godohosting.com/detail_page/9_soup/842_ZIP_P_1035_S.jpg'),
       (10, 'http://zipbanchan.godohosting.com/detail_page/9_soup/1368_ZIP_P_1047_S.jpg'),
       (11, 'http://zipbanchan.godohosting.com/detail_page/9_soup/819_ZIP_P_1034_S.jpg'),
       (12, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/128_ZIP_P_5009_S.jpg'),
       (13, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/31_ZIP_P_5001_S.jpg'),
       (14, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/39_ZIP_P_5005_S.jpg'),
       (15, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/1188_ZIP_P_5134_S.jpg'),
       (16, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/715_ZIP_P_5064_S.jpg'),
       (17, 'http://zipbanchan.godohosting.com/detail_page/7_fry/71_ZIP_P_6001_S.jpg'),
       (18, 'http://zipbanchan.godohosting.com/detail_page/7_fry/580_ZIP_P_6089_S.jpg'),
       (19, 'http://zipbanchan.godohosting.com/detail_page/7_fry/1194_ZIP_P_6215_S.jpg'),
       (20, 'http://zipbanchan.godohosting.com/detail_page/7_fry/84_ZIP_P_6006_S.jpg'),
       (21, 'http://zipbanchan.godohosting.com/detail_page/10_kimchi/242_ZIP_P_3037_S.jpg');


-- -----------------------------------------------------
-- Data for table `product_theme`
-- -----------------------------------------------------
INSERT INTO `product_theme` (`product_id`, `theme_id`)
VALUES (1, 1),
       (1, 2),
       (1, 4),
       (2, 1),
       (2, 4),
       (3, 1),
       (4, 1),
       (5, 3),
       (6, 3),
       (7, 2),
       (7, 3),
       (8, 4),
       (9, 3),
       (12, 2),
       (12, 3),
       (12, 4),
       (13, 2),
       (13, 3),
       (14, 2),
       (15, 2),
       (15, 3),
       (16, 2),
       (16, 3),
       (17, 4),
       (18, 2),
       (18, 4),
       (19, 3),
       (20, 4),
       (21, 2);


-- -----------------------------------------------------
-- Data for table `product_discount`
-- -----------------------------------------------------
INSERT INTO `product_discount` (`product_id`, `discount_id`)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (4, 2),
       (6, 2),
       (10, 1),
       (18, 1),
       (18, 2);
