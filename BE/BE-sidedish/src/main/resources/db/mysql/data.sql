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
    ("가지무침", "국산 가지를 부드럽고 담백하게 무쳤어요", 3600, "side_dish", 100),
    ("깍두기", "시원한 국을 먹을 때 깍두기는 필수", 5900, "side_dish", 100),
    ("깻잎조림", "밥 한 공기 뚝딱", 5300, "side_dish", 100),
    ("감자채 볶음", "고소하면서 담백한 감자채볶음", 3400, "side_dish", 100),
    ("간장 감자조림", "포근포근 잘 익혔어요", 3900, "side_dish", 100),
    ("낙지젓", "3대째 이어온 젓갈 장인이 만듭니다", 8800, "side_dish", 100),
    ("계란말이", "두툼하고 부드러운", 5800, "side_dish", 100),
    ("닭가슴살 참깨무침", "달콤하고 담백한", 6500, "side_dish", 100),
    ("메추리알 간장조림", "한 입에 쏙들어가는 동글동글 메추리알", 4500, "side_dish", 100),
    ("미나리 무침", "향긋하고 고소한 봄나물", 4000, "side_dish", 100),
    ("오이 부추무침", "새콤달콤하게", 6000, "side_dish", 100),
    ("돌나물 무침", "톡톡 터지는 식감", 5600, "side_dish", 100),
    ("야채 어묵볶음", "첨가물 없는 순수어묵과 야채의 만남", 4900, "side_dish", 100),
    ("옥수수 버무리", "믿고 먹일 수 있는 반찬", 4800, "side_dish", 100),
    ("한돈 김치찌개", "김치찌개는 역시 돼지고기", 9300, "soup", 100),
    ("된장찌개", "특별하지 않아서 더 좋은 우리맛", 8800, "soup", 100),
    ("미역오이냉국", "여름엔 시원한 냉국이 최고", 7020, "soup", 100),
    ("동태찌개", "겨울철 보양식으로 안성맞춤", 10900, "soup", 100),
    ("감자국", "국내산 감자라 더 고소한", 7800, "soup", 100),
    ("맑은 동태국", "시원함과 감칠맛은 그대로 담은 맑은 국", 8800, "soup", 100),
    ("오징어찌개", "매콤 쫄깃한 매력", 13800, "soup", 100),
    ( "오리 주물럭_반조리", "감칠맛 나는 매콤한 양념", 15800, "main_dish", 100),
    ("잡채", "탱글한 면과 맛깔진 고명이 가득", 12900, "main_dish", 100),
    ("소갈비찜", "촉촉하게 벤 양념이 일품", 28900, "main_dish", 100),
    ("간장 코다리조림", "쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요", 14900, "main_dish", 100),
    ("쭈꾸미 한돈 제육볶음_반조리", "쫄깃한 쭈꾸미와 고소한 돼지고기가 일품", 16900, "main_dish", 100),
    ("매운 돼지 갈비찜", "양념이 일품", 15000, "main_dish", 100),
    ("고등어 무조림", "매콤 칼칼한 매력", 13800, "main_dish", 100),
    ("꼬막 비빔밥", "매콤하게 입맛 돋우는", 12800, "main_dish", 100);


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
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%A7%95%EC%96%B4+%EB%AC%B4%EC%B9%A8/%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%B5%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.png", 1, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%A7%95%EC%96%B4+%EB%AC%B4%EC%B9%A8/%E1%84%89%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7%E1%84%83%E1%85%A1%E1%86%AF%E1%84%8F%E1%85%A9%E1%86%B7_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%B5%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7_2.jpeg", 1, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%98%B8%EB%91%90+%EB%A9%B8%EC%B9%98%EB%B3%B6%EC%9D%8C/%E1%84%92%E1%85%A9%E1%84%83%E1%85%AE+%E1%84%86%E1%85%A7%E1%86%AF%E1%84%8E%E1%85%B5%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.png", 2, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%98%B8%EB%91%90+%EB%A9%B8%EC%B9%98%EB%B3%B6%EC%9D%8C/%E1%84%92%E1%85%A9%E1%84%83%E1%85%AE_%E1%84%86%E1%85%A7%E1%86%AF%E1%84%8E%E1%85%B5%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.jpeg", 2, "png", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%95%9C%EB%8F%88+%EB%A7%A4%EC%BD%A4+%EC%95%88%EC%8B%AC%EC%9E%A5%EC%A1%B0%EB%A6%BC/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB+%E1%84%86%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7+%E1%84%8B%E1%85%A1%E1%86%AB%E1%84%89%E1%85%B5%E1%86%B7%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png", 3, "png", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%95%9C%EB%8F%88+%EB%A7%A4%EC%BD%A4+%EC%95%88%EC%8B%AC%EC%9E%A5%EC%A1%B0%EB%A6%BC/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB_%E1%84%86%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7_%E1%84%8B%E1%85%A1%E1%86%AB%E1%84%89%E1%85%B5%E1%86%B7%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 3, "png", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%80%EC%A7%80%EB%AC%B4%EC%B9%A8/%E1%84%80%E1%85%A1%E1%84%8C%E1%85%B5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpeg", 4, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%80%EC%A7%80%EB%AC%B4%EC%B9%A8/%E1%84%80%E1%85%A1%E1%84%8C%E1%85%B5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7_2.jpeg", 4, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B9%8D%EB%91%90%EA%B8%B0/%E1%84%81%E1%85%A1%E1%86%A8%E1%84%83%E1%85%AE%E1%84%80%E1%85%B5.jpeg", 5, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B9%8D%EB%91%90%EA%B8%B0/%E1%84%81%E1%85%A1%E1%86%A8%E1%84%83%E1%85%AE%E1%84%80%E1%85%B5_2.jpeg", 5, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B9%BB%EC%9E%8E%EC%A1%B0%EB%A6%BC/%E1%84%81%E1%85%A2%E1%86%BA%E1%84%8B%E1%85%B5%E1%87%81%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.jpeg", 6, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B9%BB%EC%9E%8E%EC%A1%B0%EB%A6%BC/%E1%84%81%E1%85%A2%E1%86%BA%E1%84%8B%E1%85%B5%E1%87%81%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 6, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%90%EC%9E%90%EC%B1%84%EB%B3%B6%EC%9D%8C/%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%8E%E1%85%A2%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.jpeg", 7, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%90%EC%9E%90%EC%B1%84%EB%B3%B6%EC%9D%8C/%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%8E%E1%85%A2%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7_2.jpeg", 7, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%84%EC%9E%A5+%EA%B0%90%EC%9E%90%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC_%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.jpeg", 8, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%84%EC%9E%A5+%EA%B0%90%EC%9E%90%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC_%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 8, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%82%99%EC%A7%80%EC%A0%93/%E1%84%82%E1%85%A1%E1%86%A8%E1%84%8C%E1%85%B5%E1%84%8C%E1%85%A5%E1%86%BA.jpeg", 9, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%82%99%EC%A7%80%EC%A0%93/%E1%84%82%E1%85%A1%E1%86%A8%E1%84%8C%E1%85%B5%E1%84%8C%E1%85%A5%E1%86%BA_2.jpeg", 9, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B3%84%EB%9E%80%EB%A7%90%EC%9D%B4/%E1%84%80%E1%85%A8%E1%84%85%E1%85%A1%E1%86%AB%E1%84%86%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%B5.jpeg", 10, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B3%84%EB%9E%80%EB%A7%90%EC%9D%B4/%E1%84%80%E1%85%A8%E1%84%85%E1%85%A1%E1%86%AB%E1%84%86%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%B5_2.jpeg", 10, "jpeg", 0);

insert into SIDEDISH_IMAGE
( MENU_IMAGE_URL, IMAGE_MENU_ID, IMAGE_FILE_TYPE, IMAGE_DEFAULT)
values
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4+%EC%B0%B8%EA%B9%A8%EB%AC%B4%EC%B9%A8/%E1%84%83%E1%85%A1%E1%86%B0%E1%84%80%E1%85%A1%E1%84%89%E1%85%B3%E1%86%B7%E1%84%89%E1%85%A1%E1%86%AF_%E1%84%8E%E1%85%A1%E1%86%B7%E1%84%81%E1%85%A2%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpeg", 11, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%8B%AD%EA%B0%80%EC%8A%B4%EC%82%B4+%EC%B0%B8%EA%B9%A8%EB%AC%B4%EC%B9%A8/%E1%84%83%E1%85%A1%E1%86%B0%E1%84%80%E1%85%A1%E1%84%89%E1%85%B3%E1%86%B7%E1%84%89%E1%85%A1%E1%86%AF_%E1%84%8E%E1%85%A1%E1%86%B7%E1%84%81%E1%85%A2%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7_2.jpeg", 11, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A9%94%EC%B6%94%EB%A6%AC%EC%95%8C+%EA%B0%84%EC%9E%A5%EC%A1%B0%EB%A6%BC/%E1%84%86%E1%85%A6%E1%84%8E%E1%85%AE%E1%84%85%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AF_%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.jpeg", 12, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A9%94%EC%B6%94%EB%A6%AC%EC%95%8C+%EA%B0%84%EC%9E%A5%EC%A1%B0%EB%A6%BC/%E1%84%86%E1%85%A6%E1%84%8E%E1%85%AE%E1%84%85%E1%85%B5%E1%84%8B%E1%85%A1%E1%86%AF_%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 12, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%AF%B8%EB%82%98%EB%A6%AC+%EB%AC%B4%EC%B9%A8/%E1%84%86%E1%85%B5%E1%84%82%E1%85%A1%E1%84%85%E1%85%B5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpg", 13, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%AF%B8%EB%82%98%EB%A6%AC+%EB%AC%B4%EC%B9%A8/%E1%84%86%E1%85%B5%E1%84%82%E1%85%A1%E1%84%85%E1%85%B5%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpg", 13, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%9D%B4+%EB%B6%80%EC%B6%94%EB%AC%B4%EC%B9%A8/%E1%84%8B%E1%85%A9%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%84%8E%E1%85%AE%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpeg", 14, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%9D%B4+%EB%B6%80%EC%B6%94%EB%AC%B4%EC%B9%A8/%E1%84%8B%E1%85%A9%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%84%8E%E1%85%AE%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7_2.jpeg", 14, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%83%88%EC%BD%A4%EB%8B%AC%EC%BD%A4+%EB%8F%8C%EB%82%98%EB%AC%BC+%EB%AC%B4%EC%B9%A8/%E1%84%89%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7%E1%84%83%E1%85%A1%E1%86%AF%E1%84%8F%E1%85%A9%E1%86%B7_%E1%84%83%E1%85%A9%E1%86%AF%E1%84%82%E1%85%A1%E1%84%86%E1%85%AE%E1%86%AF%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7.jpeg", 15, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%83%88%EC%BD%A4%EB%8B%AC%EC%BD%A4+%EB%8F%8C%EB%82%98%EB%AC%BC+%EB%AC%B4%EC%B9%A8/%E1%84%89%E1%85%A2%E1%84%8F%E1%85%A9%E1%86%B7%E1%84%83%E1%85%A1%E1%86%AF%E1%84%8F%E1%85%A9%E1%86%B7_%E1%84%83%E1%85%A9%E1%86%AF%E1%84%82%E1%85%A1%E1%84%86%E1%85%AE%E1%86%AF%E1%84%86%E1%85%AE%E1%84%8E%E1%85%B5%E1%86%B7_2.jpeg", 15, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%95%BC%EC%B1%84+%EC%96%B4%EB%AC%B5%EB%B3%B6%EC%9D%8C/%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2+%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%A8%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7.png", 16, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%95%BC%EC%B1%84+%EC%96%B4%EB%AC%B5%EB%B3%B6%EC%9D%8C/%E1%84%8B%E1%85%A3%E1%84%8E%E1%85%A2_%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%86%A8%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7_2.jpeg", 16, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A5%EC%88%98%EC%88%98%EB%B2%84%EB%AC%B4%EB%A6%AC/%E1%84%8B%E1%85%A9%E1%86%A8%E1%84%89%E1%85%AE%E1%84%89%E1%85%AE%E1%84%87%E1%85%A5%E1%84%86%E1%85%AE%E1%84%85%E1%85%B5.jpeg", 17, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A5%EC%88%98%EC%88%98%EB%B2%84%EB%AC%B4%EB%A6%AC/%E1%84%8B%E1%85%A9%E1%86%A8%E1%84%89%E1%85%AE%E1%84%89%E1%85%AE%E1%84%87%E1%85%A5%E1%84%86%E1%85%AE%E1%84%85%E1%85%B5_2.jpeg", 17, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%95%9C%EB%8F%88+%EA%B9%80%EC%B9%98%EC%B0%8C%EA%B0%9C/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB+%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8E%E1%85%B5%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png", 18, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%ED%95%9C%EB%8F%88+%EA%B9%80%EC%B9%98%EC%B0%8C%EA%B0%9C/%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB_%E1%84%83%E1%85%AB%E1%84%8C%E1%85%B5_%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8E%E1%85%B5%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2_2.jpeg", 18, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%90%9C%EC%9E%A5%EC%B0%8C%EA%B0%9C/%E1%84%83%E1%85%AC%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC+%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png", 19, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%90%9C%EC%9E%A5%EC%B0%8C%EA%B0%9C/%E1%84%83%E1%85%AC%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2_2.jpeg", 19, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%AF%B8%EC%97%AD+%EC%98%A4%EC%9D%B4%EB%83%89%EA%B5%AD/%E1%84%86%E1%85%B5%E1%84%8B%E1%85%A7%E1%86%A8%E1%84%8B%E1%85%A9%E1%84%8B%E1%85%B5%E1%84%82%E1%85%A2%E1%86%BC%E1%84%80%E1%85%AE%E1%86%A8.png", 20, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%AF%B8%EC%97%AD+%EC%98%A4%EC%9D%B4%EB%83%89%EA%B5%AD/%E1%84%86%E1%85%B5%E1%84%8B%E1%85%A7%E1%86%A8%E1%84%82%E1%85%A2%E1%86%BC%E1%84%80%E1%85%AE%E1%86%A82.jpeg", 20, "jpeg", 0);

insert into SIDEDISH_IMAGE
( MENU_IMAGE_URL, IMAGE_MENU_ID, IMAGE_FILE_TYPE, IMAGE_DEFAULT)
values
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%8F%99%ED%83%9C%EC%B0%8C%EA%B0%9C/%E1%84%83%E1%85%A9%E1%86%BC%E1%84%90%E1%85%A2%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.png", 21, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%8F%99%ED%83%9C%EC%B0%8C%EA%B0%9C/%E1%84%83%E1%85%A9%E1%86%BC%E1%84%90%E1%85%A2%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2_2.jpeg", 21, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%90%EC%9E%90%EA%B5%AD/%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%80%E1%85%AE%E1%86%A8.jpeg", 22, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%90%EC%9E%90%EA%B5%AD/%E1%84%80%E1%85%A1%E1%86%B7%E1%84%8C%E1%85%A1%E1%84%80%E1%85%AE%E1%86%A8_2.jpeg", 22, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A7%91%EC%9D%80+%EB%8F%99%ED%83%9C%EA%B5%AD/%E1%84%86%E1%85%A1%E1%86%B0%E1%84%8B%E1%85%B3%E1%86%AB_%E1%84%83%E1%85%A9%E1%86%BC%E1%84%90%E1%85%A2%E1%84%80%E1%85%AE%E1%86%A8.jpeg", 23, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A7%91%EC%9D%80+%EB%8F%99%ED%83%9C%EA%B5%AD/%E1%84%86%E1%85%A1%E1%86%B0%E1%84%8B%E1%85%B3%E1%86%AB_%E1%84%83%E1%85%A9%E1%86%BC%E1%84%90%E1%85%A2%E1%84%80%E1%85%AE%E1%86%A8_2.jpeg", 23, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%A7%95%EC%96%B4%EC%B0%8C%EA%B0%9C/%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%B5%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2.jpeg", 24, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EC%A7%95%EC%96%B4%EC%B0%8C%EA%B0%9C/%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%B5%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%8D%E1%85%B5%E1%84%80%E1%85%A2_2.jpeg", 24, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EB%A6%AC+%EC%A3%BC%EB%AC%BC%EB%9F%AD/%E1%84%8B%E1%85%A9%E1%84%85%E1%85%B5+%E1%84%8C%E1%85%AE%E1%84%86%E1%85%AE%E1%86%AF%E1%84%85%E1%85%A5%E1%86%A8.png", 25, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%98%A4%EB%A6%AC+%EC%A3%BC%EB%AC%BC%EB%9F%AD/%E1%84%8B%E1%85%A9%E1%84%85%E1%85%B5+%E1%84%89%E1%85%A5%E1%84%87%E1%85%B33+.png", 25, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%9E%A1%EC%B1%84/%E1%84%8C%E1%85%A1%E1%86%B8%E1%84%8E%E1%85%A2.png", 26, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%9E%A1%EC%B1%84/%E1%84%8C%E1%85%A1%E1%86%B8%E1%84%8E%E1%85%A2_2.jpeg", 26, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%86%8C%EA%B0%88%EB%B9%84%EC%B0%9C/%E1%84%89%E1%85%A9%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7.png", 27, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%86%8C%EA%B0%88%EB%B9%84%EC%B0%9C/%E1%84%89%E1%85%A9%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7+2.jpeg", 27, "jpeg", 0),
    (" https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%84%EC%9E%A5+%EC%BD%94%EB%8B%A4%EB%A6%AC%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC+%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A1%E1%84%85%E1%85%B5%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.png", 28, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B0%84%EC%9E%A5+%EC%BD%94%EB%8B%A4%EB%A6%AC%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A1%E1%86%BC_%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A1%E1%84%85%E1%85%B5%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 28, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%AD%88%EA%BE%B8%EB%AF%B8+%ED%95%9C%EB%8F%88+%EC%A0%9C%EC%9C%A1/%E1%84%8D%E1%85%AE%E1%84%81%E1%85%AE%E1%84%86%E1%85%B5+%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB.png", 29, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EC%AD%88%EA%BE%B8%EB%AF%B8+%ED%95%9C%EB%8F%88+%EC%A0%9C%EC%9C%A1/%E1%84%8C%E1%85%AE%E1%84%81%E1%85%AE%E1%84%86%E1%85%B5_%E1%84%92%E1%85%A1%E1%86%AB%E1%84%83%E1%85%A9%E1%86%AB%E1%84%8C%E1%85%A6%E1%84%8B%E1%85%B2%E1%86%A8%E1%84%87%E1%85%A9%E1%86%A9%E1%84%8B%E1%85%B3%E1%86%B7_%E1%84%87%E1%85%A1%E1%86%AB%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5_2.jpeg", 29, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A7%A4%EC%9A%B4%EB%8F%BC%EC%A7%80%EA%B0%88%EB%B9%84%EC%B0%9C/%E1%84%86%E1%85%A2%E1%84%8B%E1%85%AE%E1%86%AB%E1%84%83%E1%85%AB%E1%84%8C%E1%85%B5%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7.jpeg", 30, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EB%A7%A4%EC%9A%B4%EB%8F%BC%EC%A7%80%EA%B0%88%EB%B9%84%EC%B0%9C/%E1%84%86%E1%85%A2%E1%84%8B%E1%85%AE%E1%86%AB%E1%84%83%E1%85%AB%E1%84%8C%E1%85%B5%E1%84%80%E1%85%A1%E1%86%AF%E1%84%87%E1%85%B5%E1%84%8D%E1%85%B5%E1%86%B7_2.jpeg", 30, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B3%A0%EB%93%B1%EC%96%B4%EB%AC%B4%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A9%E1%84%83%E1%85%B3%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7.jpeg", 31, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%B3%A0%EB%93%B1%EC%96%B4%EB%AC%B4%EC%A1%B0%EB%A6%BC/%E1%84%80%E1%85%A9%E1%84%83%E1%85%B3%E1%86%BC%E1%84%8B%E1%85%A5%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A9%E1%84%85%E1%85%B5%E1%86%B7_2.jpeg", 31, "jpeg", 0),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%BC%AC%EB%A7%89%EB%B9%84%EB%B9%94%EB%B0%A5/%E1%84%81%E1%85%A9%E1%84%86%E1%85%A1%E1%86%A8%E1%84%87%E1%85%B5%E1%84%87%E1%85%B5%E1%86%B7%E1%84%87%E1%85%A1%E1%86%B8.jpeg", 32, "jpeg", 1),
    ("https://sidedish.s3.ap-northeast-2.amazonaws.com/%EA%BC%AC%EB%A7%89%EB%B9%84%EB%B9%94%EB%B0%A5/%E1%84%81%E1%85%A9%E1%84%86%E1%85%A1%E1%86%A8%E1%84%87%E1%85%B5%E1%84%87%E1%85%B5%E1%86%B7%E1%84%87%E1%85%A1%E1%86%B8_2.jpeg", 32, "jpeg", 0);

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

