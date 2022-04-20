INSERT INTO event (name, progress_flag) VALUES ('한 번 주문하면 두 번 반하는 반찬', 1);

INSERT INTO event_category (event_id, name) VALUES (1, '풍성한 고기 반찬');
INSERT INTO event_category (event_id, name) VALUES (1, '편리한 반찬 세트');
INSERT INTO event_category (event_id, name) VALUES (1, '맛있는 제철 요리');
INSERT INTO event_category (event_id, name) VALUES (1, '우리 아이 영양 반찬');

INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (1, '오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (1, '소갈비찜', '촉촉하게 벤 양념이 일품', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (1, '쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈구미와 고소한 돼지고기가 일품', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (1, '돼지불갈비', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (2, '연근조림', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (2, '오징어채', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (2, '배추김치', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (2, '장조림', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (3, '냉면', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (3, '죽순볶음', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (3, '연어', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (3, '광어', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (4, '놀부김', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (4, '콩자반', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (4, '호두멸치볶음', '맛있어요!!', NOW(), NOW());
INSERT INTO sidedish (event_category_id, name, description, created_datetime, modified_datetime) VALUES (4, '분유', '맛있어요!!', NOW(), NOW());

INSERT INTO sidedish_price (sidedish_id, price, discount_type, discount_rate, created_datetime, modified_datetime) VALUES (1, 15800, '런칭특가', 20, NOW(), NOW());
INSERT INTO sidedish_price (sidedish_id, price, discount_type, discount_rate, created_datetime, modified_datetime) VALUES (2, 28900, '이벤트특가', 10, NOW(), NOW());
INSERT INTO sidedish_price (sidedish_id, price, discount_rate, created_datetime, modified_datetime) VALUES (3, 16900, 0, NOW(), NOW());
INSERT INTO sidedish_price (sidedish_id, price, discount_rate, created_datetime, modified_datetime) VALUES (4, 10000, 0, NOW(), NOW());

INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '1_ma_1.png', 'img/1_ma_1.png', 'image/png', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '2_ma_1.png', 'img/2_ma_1.png', 'image/png', 0, NOW(), NOW());
INSERT INTO image_file (sidedish_id, file_name, save_file_name, content_type, image_type, delete_flag, created_datetime, modified_datetime) VALUES (1, '3_ma_1.png', 'img/3_ma_1.png', 'image/png', 0, NOW(), NOW());
