INSERT INTO CATEGORY (NAME) values
('category');

INSERT INTO DISCOUNT_POLICY (NAME, TYPE, VALUE) values
('policy1', 'type1', '10000');

INSERT INTO ITEM (CATEGORY_ID, DISCOUNT_POLICY_ID, NAME, DESCRIPTION, PRICE, STOCK, MAIN_IMAGE_LINK) values
(1, 1, 'item1', 'des1', 1000, 1000, "image"),
(1, 1, 'item2', 'des2', 1000, 1000, "image"),
(1, 1, 'item3', 'des3', 1000, 1000, "image");

