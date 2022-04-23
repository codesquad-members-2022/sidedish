INSERT INTO user (email, password) VALUES ('kvans@test.com', '1234');
INSERT INTO category (category_name) VALUES ('sidedish');
INSERT INTO category (category_name) VALUES ('soup');
INSERT INTO category (category_name) VALUES ('main');
INSERT INTO label (label_name) VALUES ('런칭특가');
INSERT INTO label (label_name) VALUES ('이벤트특가');
INSERT INTO label (label_name) VALUES ('라벨없음');
INSERT INTO delivery (delivery_name) VALUES ('새벽배송');
INSERT INTO delivery (delivery_name) VALUES ('전국배송');
INSERT INTO delivery (delivery_name) VALUES ('새벽배송/전국배송');
INSERT INTO best_type (best_name) VALUES ('meat');
INSERT INTO best_type (best_name) VALUES ('simple');
INSERT INTO best_type (best_name) VALUES ('seasonal');
INSERT INTO best_type (best_name) VALUES ('nutrition');
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (3,'오리주물럭','맛있는 오리고기와 오징어의 조합',15800, 12640,10,1,
        'https://user-images.githubusercontent.com/92678171/164159697-1c8ef07a-141e-464b-b4e5-bb73e2119535.png',
        3,1);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id)
VALUES (2,'한돈 돼지 김치 찌개','김치찌개는 역시 한돈이지',9900,8910,10,2,
        '',
        1);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1,'호두 멸치볶음','잔멸치와 호두가 만나 짭쪼롬하지만 고소하지',5800,5220,10,2,
        '',
        2,2);
INSERT INTO item (category_id, item_name, description, or_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1,'달래장','간장게장 뺨치는 밥도둑', 4000,10,3,
        '',
        2,3);
INSERT INTO item (category_id, item_name, description, or_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1,'미나리 무침','향긋하고 고소한 봄나물', 4800,10, 3,
        '',
        2,3);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1,'새콤달콤 유채나물 무침','새콤달콤보다 더 새콤달콤한 유채나물 무침',4800, 4320, 10, 2,
        '',
        2,3);
INSERT INTO item (category_id, item_name, description, or_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1,'새콤 오이무생채','아이들이 먹기 좋은 깔끔한 무생채', 3500, 10,3,
        '',
        1,4);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (2,'아이들 된장국', '아이들도 먹지 좋은 맵지 않은 된장국', 8800, 7920, 10, 2,
        '',
        3, 4);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (1, '계란말이','두툼하고 부드러운 계란말이',5800,5220, 10,2,
        '',
        3, 4);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id)
VALUES (2, '시래기 된장국','구수하면서 시원한 맛', 7800,7020,10,2,
        '',
        2);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id)
VALUES (2,'콩나물국','국내산 콩나물로 더 건강하게', 6800,6120, 10,2,
        '',
        1);
INSERT INTO item (category_id, item_name, description, or_price, dc_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (3, '소갈비찜', '맛있는 소갈비와 양념의 조합', 28900, 26010, 10, 2,
        '',
        3,1);
INSERT INTO item (category_id, item_name, description, or_price, stock, label_id, main_image,
                  delivery_id, best_id)
VALUES (3, '쭈꾸미 한돈 제육볶음','쭈꾸미와 한돈의 조합', 16900, 10, 3,
        '',
        3,1);
INSERT INTO images (item_id, detail_images)
VALUES (1, 'http://zipbanchan.godohosting.com/detail_page/3_main/1351/1351_ZIP_P_0108_how_to_cook_1.jpg,http://zipbanchan.godohosting.com/detail_page/3_main/1351/1351_ZIP_P_0108_damumsae.jpg'),
       (2, 'http://img4.tmon.kr/cdn3/deals/2019/07/18/2268874298/2268874298_front_37JotJSrqK.jpg'), (2, 'http://zipbanchan.godohosting.com/detail_page/3_main/513/513_ZIP_P_8013_S.jpg');