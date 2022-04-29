# DROP TABLE IF EXISTS `product`;
# CREATE TABLE `product`
# (
#     `id`               BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `category_id`      BIGINT NOT NULL,
#     `discount_id`      BIGINT,
#     `name`             VARCHAR(20),
#     `price`            BIGINT,
#     `stock_quantity`   INT,
#     `description`      VARCHAR(255),
#     `save_point_ratio` DOUBLE
# );
#
# DROP TABLE IF EXISTS `category`;
# CREATE TABLE `category`
# (
#     `id`   BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `code` VARCHAR(255) NOT NULL,
#     `name` VARCHAR(255) NOT NULL
# );
#
# DROP TABLE IF EXISTS `discount`;
# CREATE TABLE `discount`
# (
#     `id`            BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `name`          VARCHAR(255) NOT NULL,
#     `discount_rate` DOUBLE       NOT NULL
# );
#
# DROP TABLE IF EXISTS `product_image`;
# CREATE TABLE `product_image`
# (
#     `id`           BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `product_id`   BIGINT NOT NULL,
#     `image_path`   VARCHAR(255),
#     `represent_yn` BOOLEAN,
#     `sequence`     INT
# );
#
# DROP TABLE IF EXISTS `orders`;
# CREATE TABLE `orders`
# (
#     `id`         BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `member_id`  BIGINT NOT NULL,
#     `order_date` DATETIME
# );
#
# DROP TABLE IF EXISTS `order_products`;
# CREATE TABLE `order_products`
# (
#     `id`         BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `order_id`   BIGINT NOT NULL,
#     `product_id` BIGINT NOT NULL,
#     `quantity`   INT    NOT NULL
# );
#
# DROP TABLE IF EXISTS `member`;
# CREATE TABLE `member`
# (
#     `id`        BIGINT PRIMARY KEY AUTO_INCREMENT,
#     `member_id` VARCHAR(255) NOT NULL,
#     `password`  VARCHAR(255) NOT NULL,
#     `email`     VARCHAR(255)
# );
