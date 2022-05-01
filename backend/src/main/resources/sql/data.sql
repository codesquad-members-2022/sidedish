# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (1L, 1L, '오리주물럭 반조리', '20000', '6', '감칠맛 나는 매콤한 양념', '0.01');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (1L, 2L, '소갈비찜', '28900', '10', '촉촉하게 밴 양념이 일품', '0.05');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (1L, NULL, '꼬막비빔밥', '10900', '3', '매콤하게 입맛을 돋우는 꼬막비빔밥입니다.', '0.1');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (2L, 1L, '한돈 돼지 김치찌개', '9300', '8', '김치찌개에는 역시 돼지고기지', '0.1');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (2L, 2L, '된장찌개', '8800', '3', '특별하지 않아서 좋은 우리맛', '0.01');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (2L, NULL, '맑은 동태국', '8500', '5', '시원함과 감칠맛은 그대로 담은 국산 동태국.', '0.05');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (3L, 1L, '새콤달콤 오징어무침', '7500', '6', '국내산 오징어를 새콤달콤하게', '0.1');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (3L, 2L, '야채 어묵 볶음', '4900', '2', '첨가물없는 순수어묵과 야채의 환상적인 조합', '0.05');
#
# INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
# VALUES (3L, NULL, '두부조림', '6900', '10', '각종 영양이 가득 담긴 두부조림.', '0.01');
#
#
# INSERT INTO `category` (`code`, `name`)
# VALUES ('main', '메인요리');
#
# INSERT INTO `category` (`code`, `name`)
# VALUES ('soup', '국물요리');
#
# INSERT INTO `category` (`code`, `name`)
# VALUES ('dish', '밑반찬');
#
#
# INSERT INTO `discount` (`name`, `discount_rate`)
# VALUES ('런칭 특가', '0.2');
#
# INSERT INTO `discount` (`name`, `discount_rate`)
# VALUES ('이벤트 특가', '0.1');
#
#
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (1, 'http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (1, 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (1, 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (2, 'http://public.codesquad.kr/jk/storeapp/data/main/1155_ZIP_P_0081_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (2, 'http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (2, 'http://public.codesquad.kr/jk/storeapp/data/main/349_ZIP_P_0024_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (3, 'http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (3, 'http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (3, 'http://public.codesquad.kr/jk/storeapp/data/main/417_ZIP_P_0041_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (4, 'http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (4, 'http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (4, 'http://public.codesquad.kr/jk/storeapp/data/soup/28_ZIP_P_1003_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (5, 'http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (5, 'http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (5, 'http://public.codesquad.kr/jk/storeapp/data/soup/33_ZIP_P_1004_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (6, 'http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (6, 'http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (6, 'http://public.codesquad.kr/jk/storeapp/data/soup/842_ZIP_P_1035_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (7, 'http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (7, 'http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (7, 'http://public.codesquad.kr/jk/storeapp/data/side/48_ZIP_P_5008_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (8, 'http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (8, 'http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (8, 'http://public.codesquad.kr/jk/storeapp/data/side/84_ZIP_P_6006_D1.jpg', false, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (9, 'http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_T.jpg', true, 1);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (9, 'http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_S.jpg', true, 2);
# INSERT INTO `product_image` (`product_id`,`image_path`,`represent_yn`,`sequence`) VALUES (9, 'http://public.codesquad.kr/jk/storeapp/data/side/268_ZIP_P_4023_D1.jpg', false, 1);
