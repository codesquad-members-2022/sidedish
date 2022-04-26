INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (1L, 1L, '오리주물럭 반조리', '20000', '6', '감칠맛 나는 매콤한 양념', '0.01');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (1L, 2L, '소갈비찜', '28900', '10', '촉촉하게 밴 양념이 일품', '0.05');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (1L, NULL, '꼬막비빔밥', '10900', '3', '매콤하게 입맛을 돋우는 꼬막비빔밥입니다.', '0.1');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (2L, 1L, '한돈 돼지 김치찌개', '9300', '8', '김치찌개에는 역시 돼지고기지', '0.1');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (2L, 2L, '된장찌개', '8800', '3', '특별하지 않아서 좋은 우리맛', '0.01');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (2L, NULL, '맑은 동태국', '8500', '5', '시원함과 감칠맛은 그대로 담은 국산 동태국.', '0.05');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (3L, 1L, '새콤달콤 오징어무침', '7500', '6', '국내산 오징어를 새콤달콤하게', '0.1');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (3L, 2L, '야채 어묵 볶음', '4900', '2', '첨가물없는 순수어묵과 야채의 환상적인 조합', '0.05');

INSERT INTO `product` (`category_id`, `discount_id`, `name`, `price`, `stock_quantity`, `description`, `save_point_ratio`)
VALUES (3L, NULL, '두부조림', '6900', '10', '각종 영양이 가득 담긴 두부조림.', '0.01');


INSERT INTO `category` (`code`, `name`)
VALUES ('main', '메인요리');

INSERT INTO `category` (`code`, `name`)
VALUES ('soup', '국물요리');

INSERT INTO `category` (`code`, `name`)
VALUES ('dish', '밑반찬');


INSERT INTO `discount` (`name`, `discount_rate`)
VALUES ('런칭 특가', '0.2');

INSERT INTO `discount` (`name`, `discount_rate`)
VALUES ('이벤트 특가', '0.1');
