-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `category` (`id`, `name`, `description`) VALUES (DEFAULT, '든든한 메인요리', '모두가 좋아하는 든든한 메인요리');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (DEFAULT, '뜨끈한 국물요리', '정성이 담긴 뜨끈뜨끈 국물요리');
INSERT INTO `category` (`id`, `name`, `description`) VALUES (DEFAULT, '정갈한 밑반찬', '식탁을 풍성하게 하는 정갈한 밑반찬');

COMMIT;


-- -----------------------------------------------------
-- Data for table `subcategory`
-- -----------------------------------------------------
START TRANSACTION;
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '육류 요리', '육류 요리', 1);
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '해산물 요리', '해산물 요리', 1);
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '국/탕/찌개', '국/탕/찌개', 2);
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '나물/무침', '나물/무침', 3);
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '조림/볶음', '조림/볶음', 3);
INSERT INTO `subcategory` (`id`, `name`, `description`, `category_id`) VALUES (DEFAULT, '절임/장아찌', '절임/장아찌', 3);

COMMIT;
