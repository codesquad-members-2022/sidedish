-- member Table
insert into member (name, password)
values ('dave', 'songdavenaknak');

-- dish Table
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('오리 주물럭_반조리', '감칠맛 나는 매콤한 양념', '런칭특가', 15800, 100, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('잡채', '탱글한 면과 맛깔진 고명이 가득', '이벤트특가', 12900, 100, 2500, 40000, 0.01, false);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('소갈비찜', '촉촉하게 밴 양념이 일품', '이벤트특가', 28900, 0, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('간장 코다리조림', '쫀득한 코다리를 국내산 간장소스로 맛있게 조렸어요', null, 14900, 100, 2500, 40000, 0.01, false);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', '이벤트특가', 9300, 50, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('된장찌개', '특별하지 않아서 더 좋은 우리맛', '이벤트특가', 8800, 100, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('미역 오이 냉국', '여름엔 시원한 냉국이 최고', '이벤트특가', 7800, 20, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('동태찌개', '겨울철 보양식으로 안성맞춤', null, 10900, 0, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', '런칭특가', 7500, 100, 2500, 40000, 0.01, false);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게!', '이벤트특가', 5800, 10, 2500, 40000, 0.01, false);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', '이벤트특가', 6900, 5, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', '이벤트특가', 4900, 0, 2500, 40000, 0.01, true);

insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('맛있는 마늘쫑', '맛있음', '이벤트특가', 3000, 10, 2500, 40000, 0.01, true);
insert into dish (title, content, tag, price, stock, delivery_fee, free_shipping_amount, mileage_rate, early_deliverable)
values ('해파리냉채', '시원함', '런칭특가', 2000, 10, 2500, 40000, 0.01, true);

-- category Table
insert into category (parent_category_id, name, is_event, is_deleted)
values (null, '든든한 메인요리', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (null, '뜨끈한 국물요리', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (null, '정갈한 밑반찬', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (null, '한 번 주문하면 두 번 반하는 반찬', true, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (1, '육류 요리', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (1, '해산물 요리', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (2, '국/탕/찌개', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (3, '나물/무침', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (3, '조림/볶음', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (3, '절임/장아찌', false, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (4, '풍성한 고기 반찬', true, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (4, '편리한 반찬 세트', true, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (4, '맛있는 제철 요리', true, false);
insert into category (parent_category_id, name, is_event, is_deleted)
values (4, '우리 아이 영양 반찬', true, false);

-- category_dish Table
insert into category_dish (category_id, dish_id)
values (1, 1);
insert into category_dish (category_id, dish_id)
values (5, 1);
insert into category_dish (category_id, dish_id)
values (1, 2);
insert into category_dish (category_id, dish_id)
values (1, 3);
insert into category_dish (category_id, dish_id)
values (5, 3);
insert into category_dish (category_id, dish_id)
values (1, 4);
insert into category_dish (category_id, dish_id)
values (6, 4);
insert into category_dish (category_id, dish_id)
values (2, 5);
insert into category_dish (category_id, dish_id)
values (2, 6);
insert into category_dish (category_id, dish_id)
values (2, 7);
insert into category_dish (category_id, dish_id)
values (2, 8);
insert into category_dish (category_id, dish_id)
values (7, 5);
insert into category_dish (category_id, dish_id)
values (7, 6);
insert into category_dish (category_id, dish_id)
values (7, 7);
insert into category_dish (category_id, dish_id)
values (7, 8);
insert into category_dish (category_id, dish_id)
values (3, 9);
insert into category_dish (category_id, dish_id)
values (3, 10);
insert into category_dish (category_id, dish_id)
values (3, 11);
insert into category_dish (category_id, dish_id)
values (3, 12);
insert into category_dish (category_id, dish_id)
values (8, 9);
insert into category_dish (category_id, dish_id)
values (9, 10);
insert into category_dish (category_id, dish_id)
values (9, 11);
insert into category_dish (category_id, dish_id)
values (9, 12);
insert into category_dish (category_id, dish_id)
values (4, 1);
insert into category_dish (category_id, dish_id)
values (4, 2);
insert into category_dish (category_id, dish_id)
values (4, 3);
insert into category_dish (category_id, dish_id)
values (4, 4);
insert into category_dish (category_id, dish_id)
values (4, 5);
insert into category_dish (category_id, dish_id)
values (4, 6);
insert into category_dish (category_id, dish_id)
values (4, 7);
insert into category_dish (category_id, dish_id)
values (4, 8);
insert into category_dish (category_id, dish_id)
values (11, 1);
insert into category_dish (category_id, dish_id)
values (11, 3);
insert into category_dish (category_id, dish_id)
values (11, 4);
insert into category_dish (category_id, dish_id)
values (11, 5);
insert into category_dish (category_id, dish_id)
values (12, 9);
insert into category_dish (category_id, dish_id)
values (12, 10);
insert into category_dish (category_id, dish_id)
values (12, 11);
insert into category_dish (category_id, dish_id)
values (12, 12);
insert into category_dish (category_id, dish_id)
values (13, 4);
insert into category_dish (category_id, dish_id)
values (13, 7);
insert into category_dish (category_id, dish_id)
values (13, 8);
insert into category_dish (category_id, dish_id)
values (13, 10);
insert into category_dish (category_id, dish_id)
values (14, 4);
insert into category_dish (category_id, dish_id)
values (14, 5);
insert into category_dish (category_id, dish_id)
values (14, 6);
insert into category_dish (category_id, dish_id)
values (14, 7);

insert into category_dish (category_id, dish_id)
values (3, 13);
insert into category_dish (category_id, dish_id)
values (3, 14);
insert into category_dish (category_id, dish_id)
values (9, 13);
insert into category_dish (category_id, dish_id)
values (9, 14);

-- dish_image Table
insert into dish_image (dish_id,path)
values (1, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img1-1.png');
insert into dish_image (dish_id,path)
values (1, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img1-2.png');
insert into dish_image (dish_id,path)
values (2, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img2-1.png');
insert into dish_image (dish_id,path)
values (3, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img3-1.png');
insert into dish_image (dish_id,path)
values (4, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img4-1.png');
insert into dish_image (dish_id,path)
values (5, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img5-1.png');
insert into dish_image (dish_id,path)
values (6, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img6-1.png');
insert into dish_image (dish_id,path)
values (7, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img7-1.png');
insert into dish_image (dish_id,path)
values (8, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img8-1.png');
insert into dish_image (dish_id,path)
values (9, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img9-1.png');
insert into dish_image (dish_id,path)
values (10, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img10-1.png');
insert into dish_image (dish_id,path)
values (11, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img11-1.png');
insert into dish_image (dish_id,path)
values (12, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img12-1.png');

insert into dish_image (dish_id,path)
values (13, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img11-1.png');
insert into dish_image (dish_id,path)
values (14, 'https://team34-sidedish.s3.ap-northeast-2.amazonaws.com/images/img12-1.png');
