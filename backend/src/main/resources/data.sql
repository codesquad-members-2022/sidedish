INSERT INTO product (product_name, description, early_delivery, price, stock, event_badge, main_category, event_category)
VALUES
    ('오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', true, 15800, 100, 'launching', 'main', 'simple'),
    ('소갈비찜', '촉촉하게 벤 양념이 일품', false, 28900, 100, 'event', 'main', 'meat'),
    ('쭈꾸미 한돈 제육볶음_반조리', '쫄깃한 쭈꾸미와 고소한 돼지고기가 일품', true, 16900, 100, 'none', 'main', 'simple'),
    ('쭈꾸미 한돈 제육볶음_조리', '테스트14', true, 2000, 1020, 'launching', 'main', 'meat'),
    ('쭈꾸미 한돈 오징어볶음_반조리', '테스트1', false, 1690, 1040, 'none', 'main', 'meat'),
    ('쭈꾸미 한돈 테스트', '테스트2', false, 1900, 1000, 'event', 'soup', 'simple'),
    ('쭈꾸미 한돈 하이여', '테스트13', true, 160, 180, 'none', 'main', 'meat');



INSERT INTO image (product_id, image_path)
VALUES
    (1, 'https://imageserver.com/example1.jpg'),
    (1, 'https://imageserver.com/example2.jpg'),
    (1, 'https://imageserver.com/example3.jpg'),
    (2, 'https://imageserver.com/example1.jpg'),
    (2, 'https://imageserver.com/example2.jpg'),
    (2, 'https://imageserver.com/example3.jpg'),
    (3, 'https://imageserver.com/example1.jpg'),
    (3, 'https://imageserver.com/example2.jpg'),
    (3, 'https://imageserver.com/example3.jpg');

INSERT INTO user (address, name)
VALUES
    ('양재 뱅뱅사거리 코드스쿼드', 'JK'),
    ('용인시 수지구 어딘가', '호눅스'),
    ('태평양 해저', '내 주식...');

INSERT INTO product_order (product_id, user_id, quantity)
VALUES
    (1, 1, 10),
    (2, 1, 10),
    (3, 1, 10);

