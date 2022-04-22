insert into main_category (title)
values ('든든한 메인요리');
insert into main_category (title)
values ('뜨끈한 국물 요리');
insert into main_category (title)
values ('정갈한 밑반찬');


insert into sub_category (main_category_id, title)
values (1, '육류 요리');
insert into sub_category (main_category_id, title)
values (1, '해산물 요리');
insert into sub_category (main_category_id, title)
values (2, '국/탕/찌개');
insert into sub_category (main_category_id, title)
values (3, '나물/무침');
insert into sub_category (main_category_id, title)
values (3, '조림/볶음');
insert into sub_category (main_category_id, title)
values (3, '절임/장아찌');



insert into event_category (title)
values ('풍성한 고기반찬');
insert into event_category (title)
values ('편리한 반찬세트');
insert into event_category (title)
values ('맛있는 제철요리');
insert into event_category (title)
values ('우리아이 영양 반찬쓰');



insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (1, '오리주무럭', '감칠맛나는 매콤한 양념', 15800, 5, 'lunch', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (1, '잡채', '맛깔남', 12900, 2, 'lunch', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (1, '소갈비 찜', '매콤양념', 26800, 1, 'dinner', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (1, '수육국밥', '다데기 굳', 6800, 1, 'dinner', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (2, '한돈 돼지 김치찌개', '김치찌개에는 역시 돼지고기', 9300, 5, 'lunch', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (2, '된장찌개', '특별하지 않아서 더 좋은 우리맛', 8800, 10, 'dinner', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (2, '미역오이냉국', '여름엔 시원한 냉국이 최고', 7800, 5, 'lunch', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (2, '동태찌개', '겨울철 보양식으로 안성맞춤', 9300, 5, 'lunch', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (3, '새콤달콤 오징어무침', '국내산 오징어를 새콤달콤하게', 7500, 7, 'lunch', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (3, '호두 멸치볶음', '잔멸치와 호두가 만나 짭쪼름하지만 고소하게', 5800, 10, 'dinner', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (3, '한돈 매콤 안심장조림', '부드러운 한돈 안심살의 매콤함', 6900, 3, 'lunch', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy, morning_delivery)
values (3, '야채 어묵볶음', '첨가물 없는 순수어묵과 야채의 만남', 4900, 2, 'lunch', false);


insert into images (item_id, url, main_status)
values (1, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (2, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (3, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (4, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (5, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (6, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (7, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (8, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (9, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (10, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (11, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);
insert into images (item_id, url, main_status)
values (12, 'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg', true);


insert into dish_event (item_id, event_id)
values (1, 1);
insert into dish_event (item_id, event_id)
values (2, 2);
insert into dish_event (item_id, event_id)
values (3, 3);
insert into dish_event (item_id, event_id)
values (4, 4);


