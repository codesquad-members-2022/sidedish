SET AUTOCOMMIT = 0;

INSERT INTO `user` (github_id, username)
VALUES ('rxdcxdrnine', 'Miller');
INSERT INTO `user` (github_id, username)
VALUES ('nathan29849', 'Nathan');

-- festival
INSERT INTO dish (title, description, price, stock)
VALUES ('오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', 15800, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('소갈비찜', '촉촉하게 밴 양념이 일품', 28900, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', 16900, 1000);

-- side
INSERT INTO dish (title, description, price, stock)
VALUES ('새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 7500, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('호두 멸치볶음', '잔멸치와 호두가 만나 짭조름하지만 고소하게!', 5800, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 6900, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 4900, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('오이소박이', NULL, 7300, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('미나리무침', NULL, 4300, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('참외오이무침', NULL, 4300, 1000);

-- soup
INSERT INTO dish (title, description, price, stock)
VALUES ('한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 9300, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('미역오이냉국', '여름엔 시원한 냉국이 최고', 7500, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('동태찌개', '겨울철 보양식으로 안성맞춤', 10900, 1000);

-- main
INSERT INTO dish (title, description, price, stock)
VALUES ('잡채', '탱글한 면과 맛깔진 고명이 가득', 12900, 1000);
INSERT INTO dish (title, description, price, stock)
VALUES ('간장 코다리조림', '쫀득한 코디를 국내산 간장소스로 맛있게 조렸어요', 14900, 1000);

-- image
INSERT INTO dish_image (dish_id, image_path, sequence)
VALUES (1, 'https://bit.ly/382HCTR', 1);
INSERT INTO dish_image (dish_id, image_path, sequence)
VALUES (1, 'https://bit.ly/36xNMeo', 2);
INSERT INTO dish_image (dish_id, image_path)
VALUES (2, 'https://bit.ly/385Pzb5');
INSERT INTO dish_image (dish_id, image_path)
VALUES (3, 'https://bit.ly/3vrZTCd');

INSERT INTO dish_image (dish_id, image_path)
VALUES (4, 'https://bit.ly/3jS6roa');
INSERT INTO dish_image (dish_id, image_path)
VALUES (5, 'https://bit.ly/3xFHJ2v');
INSERT INTO dish_image (dish_id, image_path)
VALUES (6, 'https://bit.ly/3EyOtAO');
INSERT INTO dish_image (dish_id, image_path)
VALUES (7, 'https://bit.ly/3EsDpow');
INSERT INTO dish_image (dish_id, image_path)
VALUES (8, 'https://bit.ly/3jX1kmA');
INSERT INTO dish_image (dish_id, image_path)
VALUES (9, 'https://bit.ly/38X5sAN');
INSERT INTO dish_image (dish_id, image_path)
VALUES (10, 'https://bit.ly/3rD529e');

INSERT INTO dish_image (dish_id, image_path)
VALUES (11, 'https://bit.ly/3JY6klH');
INSERT INTO dish_image (dish_id, image_path)
VALUES (12, 'https://bit.ly/3uXeKpb');
INSERT INTO dish_image (dish_id, image_path)
VALUES (13, 'https://bit.ly/3OoHdf9');
INSERT INTO dish_image (dish_id, image_path)
VALUES (14, 'https://bit.ly/3vo6Xja');

INSERT INTO dish_image (dish_id, image_path)
VALUES (15, 'https://bit.ly/3uZBHIq');
INSERT INTO dish_image (dish_id, image_path)
VALUES (16, 'https://bit.ly/3xKYvgR');

-- delivery
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (1, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (1, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (2, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (3, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (3, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (5, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (5, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (6, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (7, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (8, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (8, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (9, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (11, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (11, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (12, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (12, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (13, 'DL001');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (15, 'DL002');
INSERT INTO dish_delivery (dish_id, delivery_code)
VALUES (16, 'DL001');

-- category : festival
INSERT INTO category (section_id, category_name, is_festival)
VALUES (NULL, '한 번 주문하면 두 번 반하는 반찬', TRUE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (1, '풍성한 고기 반찬', TRUE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (1, '편리한 반찬 세트', TRUE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (1, '맛있는 제철 요리', TRUE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (1, '우리 아이 영양 반찬', TRUE);

-- category : section
INSERT INTO category (section_id, category_name, is_festival)
VALUES (NULL, '든든한 메인요리', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (NULL, '뜨끈한 국물요리', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (NULL, '정갈한 밑반찬', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (6, '육류 요리', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (6, '해산물 요리', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (7, '국/탕/찌개', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (8, '나물/무침', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (8, '조림/볶음', FALSE);
INSERT INTO category (section_id, category_name, is_festival)
VALUES (8, '절임/장아찌', FALSE);

-- category with dish: festival
INSERT INTO dish_category (dish_id, category_id)
VALUES (1, 2);
INSERT INTO dish_category (dish_id, category_id)
VALUES (2, 2);
INSERT INTO dish_category (dish_id, category_id)
VALUES (3, 2);

-- category with dish: side
INSERT INTO dish_category (dish_id, category_id)
VALUES (4, 12);
INSERT INTO dish_category (dish_id, category_id)
VALUES (5, 13);
INSERT INTO dish_category (dish_id, category_id)
VALUES (6, 13);
INSERT INTO dish_category (dish_id, category_id)
VALUES (7, 13);
INSERT INTO dish_category (dish_id, category_id)
VALUES (8, 12);
INSERT INTO dish_category (dish_id, category_id)
VALUES (9, 12);
INSERT INTO dish_category (dish_id, category_id)
VALUES (10, 14);

-- category with dish: soup
INSERT INTO dish_category (dish_id, category_id)
VALUES (11, 11);
INSERT INTO dish_category (dish_id, category_id)
VALUES (12, 11);
INSERT INTO dish_category (dish_id, category_id)
VALUES (13, 11);
INSERT INTO dish_category (dish_id, category_id)
VALUES (14, 11);

-- category with dish: main
INSERT INTO dish_category (dish_id, category_id)
VALUES (1, 9);
INSERT INTO dish_category (dish_id, category_id)
VALUES (2, 9);
INSERT INTO dish_category (dish_id, category_id)
VALUES (15, 9);
INSERT INTO dish_category (dish_id, category_id)
VALUES (16, 10);

-- dish with event badge : 런칭특가
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (1, 'DC001');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (4, 'DC001');

-- dish with event badge : 이벤트특가
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (2, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (5, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (6, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (7, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (8, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (11, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (12, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (13, 'DC002');
INSERT INTO dish_discount (dish_id, discount_code)
VALUES (15, 'DC002');

-- recommend
INSERT INTO dish_recommend (recommender_id, recommendee_id)
VALUES (1, 6);
INSERT INTO dish_recommend (recommender_id, recommendee_id)
VALUES (1, 7);
INSERT INTO dish_recommend (recommender_id, recommendee_id)
VALUES (1, 8);
INSERT INTO dish_recommend (recommender_id, recommendee_id)
VALUES (1, 9);
INSERT INTO dish_recommend (recommender_id, recommendee_id)
VALUES (1, 10);

SET AUTOCOMMIT = 1;
