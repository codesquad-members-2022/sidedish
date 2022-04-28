INSERT INTO product (product_name, description, early_delivery, price, stock, event_badge, main_category, event_category)
VALUES
    ('고등어 무조림', '매콤 칼칼한 매력', true, 13800, 100, 'launching', 'main', 'season'),
    ('불고기 잡채', '아이들 입맛에 딱 맞는', false, 14800, 100, 'event', 'main', 'kids'),
    ('매운 돼지갈비찜', '촉촉하게 밴 양념이 일품', true, 19800, 100, 'none', 'main', 'meat'),
    ('서울식 불고기 버섯전골', '달큰한 육수와 부드러운 버섯이 일품', true, 17800, 50, 'launching', 'soup', 'meat'),
    ('주꾸미 한돈 제육볶음_반조리', '쫄깃한 주꾸미와 고소한 돼지고기가 일품', false, 17800, 200, 'none', 'main', 'meat'),
    ('한돈 돼지돼지 김치찌개_쿠킹박스', '끓이면 끓일 수록 더 맛있어요', false, 13800, 1000, 'event', 'soup', 'meat'),
    ('맛보기 반찬 4종', '맛보기로 먼저 드셔보세요!', true, 12800, 180, 'launching', 'side', 'simple'),
    ('집반찬 베스트 4종', '인기제품으로만 모았어요!', true, 13800, 150, 'launching', 'side', 'simple'),
    ('아이반찬 3종', '아이들이 좋아하는 반찬 3종!', false, 14800, 150, 'none', 'side', 'kids'),
    ('취나물무침', '부드럽고 고소해 자꾸만 손이가는 무침', false, 4300, 100, 'none', 'side', 'season'),
    ('달래장', '알싸하고 향긋한 맛', true, 4600, 100, 'event', 'side', 'season'),
    ('새콤달콤 유채나물무침', '유채나물의 향긋함을 그대로', true, 4800, 100, 'event', 'side', 'season'),
    ('달래 된장찌개', '구수하고 감칠맛이 좋은', false, 9800, 100, 'none', 'soup', 'season'),
    ('멸치 주먹밥', '남녀노소 함께 즐기는', false, 4800, 50, 'none', 'main', 'kids'),
    ('한우 무볶음', '달달한 무와 짭조름한 한우의 조합', true, 4800, 50, 'launching', 'main', 'kids'),
    ('출산선물 세트', '마음을 전하는 선물', false, 48800, 50, 'event', 'main', 'simple'),
    ('생일축하세트(2인)', '소중한 사람의 특별한 하루를 위해', false, 49900, 50, 'event', 'main', 'simple'),
    ('도시락반찬 4종', '국물 없이 깔끔하게', true, 13800, 10, 'event', 'side', 'simple'),
    ('뚝배기 불고기_반조리', '야들야들 소고기와 달큰한 양념의 조화', false, 16800, 30, 'none', 'soup', 'meat'),
    ('한우 소불고기_반조리', '한우로 만든 대한민국 대표요리', false, 25800, 60, 'none', 'main', 'meat');



INSERT INTO image (product_id, image_path)
VALUES
    (1, 'http://zipbanchan.godohosting.com/detail_page/3_main/832_ZIP_P_4044_S.jpg'),
    (2, 'http://zipbanchan.godohosting.com/detail_page/3_main/1203_ZIP_P_6234_S.jpg'),
    (3, 'http://zipbanchan.godohosting.com/detail_page/3_main/350_ZIP_P_0025_S.jpg'),
    (4, 'http://zipbanchan.godohosting.com/detail_page/3_main/1346/1346_ZIP_P_0093_S.jpg'),
    (5, 'http://zipbanchan.godohosting.com/detail_page/3_main/1354/1354_ZIP_P_0104_S.jpg'),
    (6, 'http://zipbanchan.godohosting.com/detail_page/3_main/513/513_ZIP_P_8013_S.jpg'),
    (7, 'http://zipbanchan.godohosting.com/detail_page/2_set/265_ZIP_P_6039_S.jpg'),
    (8, 'http://zipbanchan.godohosting.com/detail_page/2_set/557_ZIP_P_6080_S.jpg'),
    (9, 'http://zipbanchan.godohosting.com/detail_page/5_kid/1105_ZIP_P_9216_S.jpg'),
    (10, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/1329_ZIP_P_5116_S.jpg'),
    (11, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/707_ZIP_P_5057_S.jpg'),
    (12, 'http://zipbanchan.godohosting.com/detail_page/8_muchim/1330_ZIP_P_5117_S.jpg'),
    (13, 'http://zipbanchan.godohosting.com/detail_page/9_soup/134_ZIP_P_1007_S.jpg'),
    (14, 'https://zipbanchan.godohosting.com/detail_page/5_kid/719_ZIP_P_6113_S.jpg'),
    (15, 'http://zipbanchan.godohosting.com/detail_page/5_kid/1130_ZIP_P_6196_S.jpg'),
    (16, 'http://zipbanchan.godohosting.com/detail_page/2_set/1257_ZIP_P_9194_S.jpg'),
    (17, 'http://zipbanchan.godohosting.com/detail_page/2_set/808_ZIP_P_9012_S.jpg'),
    (18, 'http://zipbanchan.godohosting.com/detail_page/2_set/743_ZIP_P_6989_S.jpg'),
    (19, 'http://zipbanchan.godohosting.com/detail_page/3_main/1406/1406_ZIP_P_0113_S.jpg'),
    (20, 'http://zipbanchan.godohosting.com/detail_page/3_main/1348/1348_ZIP_P_0096_S.jpg');


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

