insert into main_category (title)
values ('든든한 메인요리');
insert into main_category (title)
values ('뜨끈한 국물 요리');
insert into main_category (title)
values ('정갈한 밑반찬');

insert into event_category (title)
values ('풍성한 고기반찬');
insert into event_category (title)
values ('편리한 반찬세트');
insert into event_category (title)
values ('맛있는 제철요리');
insert into event_category (title)
values ('우리아이 영양 반찬쓰');

insert into item (main_category_id, title, `description`, price, quantity, discount_policy,
                  morning_delivery)
values (1, '오리주무럭', '감칠맛나는 매콤한 양념', 15800, 5, 'lunch', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy,
                  morning_delivery)
values (1, '잡채', '맛깔남', 12900, 2, 'lunch', true);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy,
                  morning_delivery)
values (1, '소갈비 찜', '매콤양념', 26800, 1, 'dinner', false);
insert into item (main_category_id, title, `description`, price, quantity, discount_policy,
                  morning_delivery)
values (1, '수육국밥', '다데기 굳', 6800, 1, 'dinner', true);

insert into images (item_id, url, main_status)
values (1,
        'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg',
        true);
insert into images (item_id, url, main_status)
values (2,
        'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg',
        false);
insert into images (item_id, url, main_status)
values (3,
        'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg',
        false);
insert into images (item_id, url, main_status)
values (4,
        'http://bitcdn.bit-play.com/unibox/2016/12/31/01/9ffdffc6248909840ea94c990e5c72ee_6575547_450.jpg',
        true);

insert into dish_event (item_id, event_id)
values (1, 1);
insert into dish_event (item_id, event_id)
values (2, 2);
insert into dish_event (item_id, event_id)
values (3, 3);
insert into dish_event (item_id, event_id)
values (4, 4);
