INSERT INTO category (NAME, PRODUCT_COUNT) VALUES ('모두가 좋아하는 든든한 메인요리', 3);
INSERT INTO category (NAME, PRODUCT_COUNT) VALUES ('정성이 담긴 뜨끈한 국물요리', 2);
INSERT INTO category (NAME, PRODUCT_COUNT) VALUES ('식탁을 풍성하게 하는 정갈한 밑반찬', 1);

INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템1', 15800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 100, 1);
INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템2', 16800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 200, 1);
INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템3', 17800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 300, 1);
INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템4', 18800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 400, 2);
INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템5', 20800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 500, 2);
INSERT INTO product (NAME, PRICE, DESCRIPTION, THUMBNAIL_IMAGE_URL, STOCK, CATEGORY_ID) VALUES ('아이템6', 21800, '설명1', 'https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg', 600, 3);

INSERT INTO delivery (REGION, TYPE) VALUES ('전국', 'NORMAL');
INSERT INTO delivery (REGION, TYPE) VALUES ('서울', 'DAWN');

INSERT INTO event (NAME, DISCOUNT_RATE) VALUES('이벤트1', 0.2);
INSERT INTO event (NAME, DISCOUNT_RATE) VALUES('이벤트2', 0.1);
INSERT INTO event (NAME, DISCOUNT_RATE) VALUES('이벤트3', 0.3);

INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (1, 1);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (1, 2);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (2, 1);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (3, 2);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (4, 2);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (5, 1);
INSERT INTO product_delivery (PRODUCT_ID, DELIVERY_ID) VALUES (6, 2);

INSERT INTO product_event (PRODUCT_ID, EVENT_ID) VALUES (1,1);
INSERT INTO product_event (PRODUCT_ID, EVENT_ID) VALUES (1,2);
INSERT INTO product_event (PRODUCT_ID, EVENT_ID) VALUES (2,1);
INSERT INTO product_event (PRODUCT_ID, EVENT_ID) VALUES (3,2);
INSERT INTO product_event (PRODUCT_ID, EVENT_ID) VALUES (5,2);

INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',1);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',1);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',2);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',3);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',4);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',5);
INSERT INTO image (URL, PRODUCT_ID) VALUES ('https://recipe1.ezmember.co.kr/cache/data/goods/19/10/43/1000003443/1000003443_detail_08.jpg',6);
