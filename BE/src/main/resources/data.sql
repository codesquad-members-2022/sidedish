insert into member (member_name, district, city, mileage)
values ('honux', '서울특별시', '강남구', 0);

insert into discount_policy (name, discount_rate)
values ('이벤트특가', 0.1), ('런칭특가', 0.2);

insert into item_section (item_section_name)
value ('main'), ('soup'), ('side');

insert into item (name, description, price, discount_policy_id, item_section_id, stock, support_dawn_delivery)
values ('땃쥐고기', '땃쥐고기입니다.', 10000, 1, 1, 100, true),
       ('리고기', '리고기입니다.', 20000, 2, 1, 100, false),
       ('순대국밥', '따끈한 국밥입니다.', 20000, 1, 2, 100, false),
       ('김치', '없이는 못 삽니다.', 20000, 1, 3, 100, true);

insert into item_image (item_image_url, item_id, item_image_sequence, item_image_type)
values ('https://i.imgur.com/8MbyiN2.jpeg', 1, 1, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 1, 2, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 1, 1, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 1, 2, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 2, 1, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 2, 2, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 2, 1, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 2, 2, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 3, 1, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 3, 2, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 3, 1, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 3, 2, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 3, 3, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 4, 1, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 4, 2, 'MAIN'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 4, 1, 'SUB'),
       ('https://i.imgur.com/8MbyiN2.jpeg', 4, 2, 'SUB');
