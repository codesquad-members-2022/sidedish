INSERT INTO CATEGORY (NAME) values
('main'),
('soup'),
('side');

INSERT INTO ITEM (CATEGORY_ID, NAME, DESCRIPTION, PRICE, STOCK, MAIN_IMAGE_LINK) values
(1, 'item1', 'des1', 1000, 1000, "image"),
(1, 'item2', 'des2', 1000, 1000, "image"),
(2, 'item3', 'des2', 1000, 1000, "image"),
(2, 'item4', 'des2', 1000, 1000, "image"),
(3, 'item5', 'des2', 1000, 1000, "image"),
(3, 'item6', 'des2', 1000, 1000, "image"),
(3, 'item7', 'des3', 1000, 1000, "image");

INSERT INTO USER (USERNAME, PASSWORD) VALUES
('santory', '1111'),
('lucid', '2222');
