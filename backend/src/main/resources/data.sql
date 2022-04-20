/* 기획전 */
insert into exhibition (id, title)
values (1, '한 번 주문하면 두 번 반하는 반찬');

/* 대분류 */
insert into category (title, parent, exhibition_id)
values ('든든한 메인요리', 0, 0);

insert into category (title, parent, exhibition_id)
values ('뜨끈한 국물요리', 0, 0);

insert into category (title, parent, exhibition_id)
values ('정갈한 밑반찬', 0, 0);

/* 1. 든든한 메인요리 */
insert into category (title, parent, exhibition_id)
values ('육류 요리', 1, 0);

insert into category (title, parent, exhibition_id)
values ('해산물 요리', 1, 0);

/* 2. 뜨끈한 국물요리 */
insert into category (title, parent, exhibition_id)
values ('국/탕/찌개', 2, 0);

/* 3. 정갈한 밑반찬 */
insert into category (title, parent, exhibition_id)
values ('나물/무침', 3, 0);

insert into category (title, parent, exhibition_id)
values ('조림/볶음', 3, 0);

insert into category (title, parent, exhibition_id)
values ('절임/장아찌', 3, 0);

insert into category (title, parent, exhibition_id)
values ('풍성한 고기 반찬', 0, 1);

insert into category (title, parent, exhibition_id)
values ('편리한 반찬 세트', 0, 1);

insert into category (title, parent, exhibition_id)
values ('맛있는 제철 요리', 0, 1);

insert into category (title, parent, exhibition_id)
values ('우리 아이 영양 반찬', 0, 1);
