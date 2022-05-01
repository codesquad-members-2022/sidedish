INSERT INTO event (name, progress_flag) VALUES ('한 번 주문하면 두 번 반하는 반찬', 1);

INSERT INTO event_category (event_id, name) VALUES (1, '풍성한 고기 반찬');
INSERT INTO event_category (event_id, name) VALUES (1, '편리한 반찬 세트');
INSERT INTO event_category (event_id, name) VALUES (1, '맛있는 제철 요리');
INSERT INTO event_category (event_id, name) VALUES (1, '우리 아이 영양 반찬');

INSERT INTO menu_category (name) VALUES ('식탁을 풍성하게 하는 정갈한 밑반찬');
INSERT INTO menu_category (name) VALUES ('정성이 담긴 뜨끈뜨근 국물 요리');
INSERT INTO menu_category (name) VALUES ('모두가 좋아하는 든든한 메인 요리');

INSERT INTO discount_policy (discount_type, discount_rate) VALUES ('이벤트 특가', 20);
INSERT INTO discount_policy (discount_type, discount_rate) VALUES ('런칭 특가', 10);

INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, dawn_delivery_flag, whole_nation_delivery_flag, price, stock, created_datetime, modified_datetime) VALUES (1, 3, 1, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', true, true, 15800, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (1, 3, 2, '소갈비찜', '촉촉하게 벤 양념이 일품', 28900, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (1, 3, '쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈구미와 고소한 돼지고기가 일품', 16900, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (1, 3, '돼지불갈비', '맛있어요!!', 10000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, dawn_delivery_flag, whole_nation_delivery_flag, price, stock, created_datetime, modified_datetime) VALUES (2, 1, 1, '연근조림', '맛있어요!!', true, true, 2000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (2, 1, 2, '오징어채', '맛있어요!!', 3000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (2, 1, '배추김치', '맛있어요!!', 4000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (2, 1, '장조림', '맛있어요!!', 5000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, dawn_delivery_flag, whole_nation_delivery_flag, price, stock, created_datetime, modified_datetime) VALUES (3, 2, 1, '냉면', '맛있어요!!', true, true, 8000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (3, 1, 2, '죽순볶음', '맛있어요!!', 9000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (3, 3, '연어구이', '맛있어요!!', 10000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (3, 3, '광어구이', '맛있어요!!', 11000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, dawn_delivery_flag, whole_nation_delivery_flag, price, stock, created_datetime, modified_datetime) VALUES (4, 1, 1, '김', '맛있어요!!', true, true, 1000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, discount_policy_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (4, 1, 2, '콩자반', '맛있어요!!', 2000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (4, 1, '호두멸치볶음', '맛있어요!!', 3000, 3, NOW(), NOW());
INSERT INTO sidedish (event_category_id, menu_category_id, name, description, price, stock, created_datetime, modified_datetime) VALUES (4, 1, '시금치 무침', '맛있어요!!', 4000, 3, NOW(), NOW());

INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '1_ma_1.png', 'img/1_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '1_et_2.png', 'img/1_et_2.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '1_et_3.png', 'img/1_et_3.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (2, '2_ma_1.png', 'img/2_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (3, '3_ma_1.png', 'img/3_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (4, '4_ma_1.png', 'img/4_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (5, '5_ma_1.png', 'img/5_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (6, '6_ma_1.png', 'img/6_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (7, '7_ma_1.png', 'img/7_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (8, '8_ma_1.png', 'img/8_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (9, '9_ma_1.png', 'img/9_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (10, '10_ma_1.png', 'img/10_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (11, '11_ma_1.png', 'img/11_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (12, '12_ma_1.png', 'img/12_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (13, '13_ma_1.png', 'img/13_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (14, '14_ma_1.png', 'img/14_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (15, '15_ma_1.png', 'img/15_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (16, '16_ma_1.png', 'img/16_ma_1.png', 'image/png', 'main', 0, NOW(), NOW());
