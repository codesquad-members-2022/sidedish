-- 사용자

select * from sidedish.SIDEDISH_USERS;

insert into SIDEDISH_USERS
( user_id, user_password, created_at, updated_at)
values
    ( "sally", "12341234", curdate(), curdate());


-- 사용자 oauth

select * from sidedish.SIDEDISH_USER_OAUTH;

insert into SIDEDISH_USER_OAUTH
( oauth_company, oauth_users_id, access_token )
values
    ( "google", 1, "asdfzxcvqwerEEEhjkl"),
    ( "naver", 1, "qwerertywerEEEhjkl");


-- 메뉴

insert into SIDEDISH_MENUS
( MENU_NAME, DESCRIPTION, MENU_PRICE, MENU_CATEGORY, INVENTORY_QUANTITY)
values
    ( "새콤달콤 오징어무침", "국내산 오징어를 새콤달콤하게", 7500, "side_dish", 100),
    ("호두 멸치볶음", "잔멸치와 호두가 만나 짭쪼름하지만 고소하게!", 5800, "side_dish", 100),
    ("한돈 매콤 안심장조림", "부드러운 한돈 안심살의 매콤함", 6900, "side_dish", 100),
    ("한돈 돼지 김치찌개", "김치찌개는 역시 돼지고기", 9300, "soup", 100),
    ("된장찌개", "특별하지 않아서 더 좋은 우리맛", 8800, "soup", 100),
    ("미역오이냉국", "여름엔 시원한 냉국이 최고", 7020, "soup", 100),
    ("동태찌개", "겨울철 보양식으로 안성맞춤", 10900, "soup", 100),
    ( "오리 주물럭_반조리", "감칠맛 나는 매콤한 양념", 15800, "main_dish", 100),
    ("잡채", "탱글한 면과 맛깔진 고명이 가득", 12900, "main_dish", 100),
    ("소갈비찜", "촉촉하게 벤 양념이 일품", 28900, "main_dish", 100),
    ("간장 코다리조림", "쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요", 14900, "main_dish", 100),
    ( "쭈꾸미 한돈 제육볶음_반조리", "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품", 16900, "main_dish", 100),
    ( "한돈 달콤 안심 장조림", "부드러운 안심살의 달콤함", 6900, "side_dish", 100);


-- 기획전

insert into SIDEDISH_EXHIBITIONS
(EXHIBITION_TITLE, EXHIBITION_START, EXHIBITION_DURATION)
values
    ("한 번 주문하면 두 번 반하는 반찬", curdate(), 100);

-- 기획전 내 추천 메뉴

insert into SIDEDISH_SPECIAL_MENUS
(SPECIAL_TITLE, MENU_ID, EXHIBITIONS_ID)
values
    ("풍성한 고기 반찬", 8, 1),
    ("풍성한 고기 반찬", 10, 1),
    ("풍성한 고기 반찬", 12, 1),
    ("편리한 반찬 세트", 2, 1),
    ("편리한 반찬 세트", 3, 1),
    ("편리한 반찬 세트", 4, 1),
    ("맛있는 제철 요리", 1, 1),
    ("맛있는 제철 요리", 8, 1),
    ("맛있는 제철 요리", 9, 1),
    ("우리 아이 영양 반찬", 2, 1),
    ("우리 아이 영양 반찬", 3, 1),
    ("우리 아이 영양 반찬", 4, 1);


-- 메뉴의 이미지

insert into SIDEDISH_IMAGE
( MENU_IMAGE_URL, IMAGE_MENU_ID, IMAGE_FILE_TYPE, IMAGE_DEFAULT)
values
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%B5%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.png",1, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A9%E1%84%83%E1%85%AE+%E1%84%86%E1%85%A7%E1%86%AF%E1%84%8E%E1%85%B5%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.png",2, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB+%E1%84%86%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7+%E1%84%8B%E1%85%A1%E1%86%AB%E1%84%89%E1%85%B5%E1%86%B7%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png",3, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2+%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%A8%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.png",4, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB+%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8E%E1%85%B5%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png",5, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%AC%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC+%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png",6, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%86%E1%85%B5%E1%84%8B%E1%85%A7%E1%86%A8%E1%84%8B%E1%85%A9%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A2%E1%86%BC%E1%84%80%E1%85%AE%E1%86%A8.png",7, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%A9%E1%86%BC%E1%84%90%E1%85%A2%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png",8, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A9%E1%84%85%E1%85%B5+%E1%84%89%E1%85%A5%E1%84%87%E1%85%B3+1.png",9, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A9%E1%84%85%E1%85%B5+%E1%84%89%E1%85%A5%E1%84%87%E1%85%B33+.png",9, "png", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8C%E1%85%A1%E1%86%B8%E1%84%8E%E1%85%A2.png",10, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%89%E1%85%A9%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7.png",11, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC+%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A1%E1%84%85%E1%85%B5%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png",12, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%E1%84%8D%E1%85%AE%E1%84%81%E1%85%AE%E1%84%86%E1%85%B5+%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB.png",13, "png", 1);


-- 이벤트

insert into SIDEDISH_EVENTS
( event_title)
values
    ( "런칭특가"),
    ( "이벤트특가");


-- 할인

insert into SIDEDISH_SALE_POLICY
( sale_title, sale_amount, event_id)
values
    ( "rate_discount", "0.01", 2),
    ( "amount_discount", "3000", 1);


-- 이벤트 플래너

insert into SIDEDISH_EVENT_PLANNER
( menu_id, event_id, start_date, event_duration)
values
    ( 9, 1, curdate(), 30),
    ( 1, 1, curdate(), 30),
    ( 2, 2, curdate(), 7),
    ( 3, 2, curdate(), 7),
    ( 4, 2, curdate(), 7),
    ( 5, 2, curdate(), 7),
    ( 6, 2, curdate(), 7),
    ( 7, 2, curdate(), 7),
    ( 10, 2, curdate(), 7),
    ( 11, 2, curdate(), 7);

