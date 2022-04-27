INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('[프렙] 해산물 빠에야', '메뉴설명1', 15000, 'MAIN', 'NONE', 2500, 20000, 1, 69,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (1, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-main01.png', true),
       (1, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-main02.png', true),
       (1, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-detail01.png', false),
       (1, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-detail02.png', false),
       (1, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bab-detail03.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('설렁탕', '메뉴설명2', 10000, 'MAIN', 'LAUNCH', 4000, 40000, 1, 14,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bonesoup-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (2, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bonesoup-main01.png', true),
       (2, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bonesoup-detail01.png',
        false),
       (2, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bonesoup-detail02.png',
        false),
       (2, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bonesoup-detail03.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('부대찌개', '메뉴설명3', 10000, 'MAIN', 'EVENT', 2500, 30000, 1, 45,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (3, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-main01.png', true),
       (3, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-main02.png', true),
       (3, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-detail01.png', false),
       (3, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-detail02.png', false),
       (3, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/budae-detail03.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('닭볶음탕', '메뉴설명4', 10000, 'MAIN', 'EVENT', 2500, 15000, 1, 26,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (4, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-main01.png',
        true),
       (4, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-main02.png',
        true),
       (4, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-detail01.png',
        false),
       (4, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-detail02.png',
        false),
       (4, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/spicychicken-detail03.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('육개장', '메뉴설명5', 8000, 'MAIN', 'NONE', 1500, 30000, 1, 62,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/yukgaejang-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (5, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/yukgaejang-main01.png', true),
       (5, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/yukgaejang-main02.png', true),
       (5, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/yukgaejang-detail01.png',
        false),
       (5, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/yukgaejang-detail02.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('곰국', '메뉴설명6', 8000, 'SOUP', 'EVENT', 2500, 40000, 1, 50,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/bearsoup-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (6, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/bearsoup-main01.png', true),
       (6, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/bearsoup-detail01.png',
        false),
       (6, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/bearsoup-detail02.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('삼계탕', '메뉴설명7', 18000, 'SOUP', 'LAUNCH', 2500, 33000, 1, 15,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/chickensoup-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (7, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/chickensoup-main01.png',
        true),
       (7, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/chickensoup-main02.png',
        true),
       (7, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/chickensoup-detail01.png',
        false),
       (7, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/chickensoup-detail02.png',
        false),
       (7, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/chickensoup-detail03.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('낙지 연포탕', '메뉴설명8', 22000, 'SOUP', 'NONE', 2500, 41000, 1, 8,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/octopus-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (8, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/octopus-main01.png', true),
       (8, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/octopus-main02.png', true),
       (8, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/octopus-detail01.png', false),
       (8, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/octopus-detail02.png', false),
       (8, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/octopus-detail03.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('미역국', '메뉴설명9', 6000, 'SOUP', 'LAUNCH', 2500, 25000, 1, 35,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/seaweedsoup-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (9, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/seaweedsoup-main01.png',
        true),
       (9, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/seaweedsoup-main02.png',
        true),
       (9, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/seaweedsoup-detail01.png',
        false),
       (9, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/seaweedsoup-detail02.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('순대국', '메뉴설명10', 8000, 'SOUP', 'EVENT', 2000, 40000, 1, 25,
        'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/main/sundaesoup-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (10, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/sundaesoup-main01.png',
        true),
       (10, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/sundaesoup-main02.png',
        true),
       (10, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/sundaesoup-detail01.png',
        false),
       (10, 'https://s3.ap-northeast-2.amazonaws.com/www.jerry.io/soup/sundaesoup-detail02.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('계란찜', '메뉴설명11', 5000, 'SIDE', 'EVENT', 1000, 40000, 1, 30,
        'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/egg-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (11, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/egg-main01.png', true),
       (11, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/egg-main02.png', true),
       (11, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/egg-detail01.png', false),
       (11, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/egg-detail02.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('황태채무침', '메뉴설명12', 5000, 'SIDE', 'NONE', 2000, 40000, 1, 40,
        'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/hwangtae-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (12, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/hwangtae-main01.png', true),
       (12, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/hwangtae-detail01.png', false),
       (12, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/hwangtae-detail02.png', false),
       (12, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/hwangtae-detail03.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('버섯볶음', '메뉴설명13', 5000, 'SIDE', 'LAUNCH', 2500, 30000, 1, 50,
        'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (13, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-main01.png', true),
       (13, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-main02.png', true),
       (13, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-detail01.png', false),
       (13, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-detail02.png', false),
       (13, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/mushroom-detail03.png', false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('동그랑땡', '메뉴설명14', 5000, 'SIDE', 'NONE', 2500, 80000, 1, 15,
        'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (14, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-main01.png', true),
       (14, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-main02.png', true),
       (14, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-detail01.png',
        false),
       (14, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-detail02.png',
        false),
       (14, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/roundmeat-detail03.png',
        false);

INSERT INTO menu (name, description, price, menu_type, sale_type, fee, free_shipping_starting_price,
                  delivery_info, stock, image_path)
VALUES ('시그니처반찬3종', '메뉴설명15', 10000, 'SIDE', 'EVENT', 2500, 28000, 1, 10,
        'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-main01.png');

INSERT INTO image (menu_id, image_path, is_main_image)
VALUES (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-main01.png', true),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-main02.png', true),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-detail01.png',
        false),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-detail02.png',
        false),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-detail03.png',
        false),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-detail04.png',
        false),
       (15, 'https://banchan-26.s3.ap-northeast-2.amazonaws.com/side/signature-detail05.png',
        false);

INSERT INTO user (address, name)
VALUES ('코드스쿼드', 'Dion');
