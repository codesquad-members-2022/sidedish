SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `sidedish`;
CREATE SCHEMA `sidedish` DEFAULT CHARACTER SET utf8;
USE `sidedish`;

CREATE TABLE IF NOT EXISTS `sidedish`.`category`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `sidedish`.`delivery`
(
    `id`               INT         NOT NULL AUTO_INCREMENT,
    `delivery_pay`     INT         NOT NULL,
    `delivery_area`    VARCHAR(45) NOT NULL,
    `delivery_morning` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `sidedish`.`event_tabs`
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `sidedish`.`dish`
(
    `id`                  BIGINT       NOT NULL AUTO_INCREMENT,
    `price`               INT          NOT NULL,
    `title`               VARCHAR(20)  NOT NULL,
    `description`         VARCHAR(45)  NULL,
    `main_image`          VARCHAR(150) NOT NULL,
    `sub_image_1`         VARCHAR(150) NULL,
    `sub_image_2`         VARCHAR(150) NULL,
    `stock_quantity`      INT          NOT NULL,
    `point`               INT          NOT NULL,
    `category_id`         INT          NOT NULL,
    `delivery_id`         INT          NOT NULL,
    `event_tabs_id`       INT          NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_menu_card_category1_idx` (`category_id` ASC) VISIBLE,
    INDEX `fk_menu_card_delivery1_idx` (`delivery_id` ASC) VISIBLE,
    INDEX `fk_menu_card_special_category1_idx` (`event_tabs_id` ASC) VISIBLE,
    CONSTRAINT `fk_menu_card_category1`
        FOREIGN KEY (`category_id`)
            REFERENCES `sidedish`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_menu_card_delivery1`
        FOREIGN KEY (`delivery_id`)
            REFERENCES `sidedish`.`delivery` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_menu_card_special_category1`
        FOREIGN KEY (`event_tabs_id`)
            REFERENCES `sidedish`.`event_tabs` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `sidedish`.`discount_policy`
(
    `id`            BIGINT      NOT NULL AUTO_INCREMENT,
    `name`          VARCHAR(45) NOT NULL,
    `discount_rate` DOUBLE      NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sidedish`.`discount`
(
    `menu_card_id`       BIGINT NOT NULL,
    `discount_policy_id` BIGINT NOT NULL,
    INDEX `fk_discount_menu_card1_idx` (`menu_card_id` ASC) VISIBLE,
    INDEX `fk_discount_discount_policy1_idx` (`discount_policy_id` ASC) VISIBLE,
    CONSTRAINT `fk_discount_menu_card1`
        FOREIGN KEY (`menu_card_id`)
            REFERENCES `sidedish`.`dish` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_discount_discount_policy1`
        FOREIGN KEY (`discount_policy_id`)
            REFERENCES `sidedish`.`discount_policy` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sidedish`.`user`
(
    `id`        BIGINT      NOT NULL AUTO_INCREMENT,
    `name`      VARCHAR(45) NOT NULL,
    `github_id` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `sidedish`.`orders`
(
    `user_id`        BIGINT NOT NULL,
    `menu_card_id`   BIGINT NOT NULL,
    `order_quantity` INT    NOT NULL,
    INDEX `fk_table1_user1_idx` (`user_id` ASC) VISIBLE,
    INDEX `fk_orders_menu_card1_idx` (`menu_card_id` ASC) VISIBLE,
    CONSTRAINT `fk_table1_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `sidedish`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_orders_menu_card1`
        FOREIGN KEY (`menu_card_id`)
            REFERENCES `sidedish`.`dish` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
