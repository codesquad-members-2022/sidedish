-- MySQL Script generated by MySQL Workbench
-- Thu Apr 21 14:59:29 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sidedish
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sidedish
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sidedish` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;
USE `sidedish` ;

-- -----------------------------------------------------
-- Table `sidedish`.`menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sidedish`.`menu` ;

CREATE TABLE IF NOT EXISTS `sidedish`.`menu` (
    `id`                    INT             NOT NULL    AUTO_INCREMENT  COMMENT '메뉴 PK',
    `name`                  VARCHAR(255)    NOT NULL    COMMENT '메뉴 이름',
    `description`           VARCHAR(255)    NOT NULL    COMMENT '메뉴 설명',
    `price`                 INT             NOT NULL    COMMENT '메뉴 가격',
    `menu_type`             VARCHAR(45)     NOT NULL    COMMENT '메뉴 종류 (MAIN, SOUP, SIDE)',
    `sale_type`             VARCHAR(45)     NOT NULL    COMMENT '세일 종류 (NONE, LAUNCH, EVENT)',
    `fee`                   INT             NOT NULL    COMMENT '배송비',
    `free_shipping_min`     INT             NOT NULL    COMMENT '무료배송 기준 최소주문 금액',
    `delivery_info`         VARCHAR(45)     NOT NULL    COMMENT '배송 정보 (서울경기 당일배송)',
    `stock`                 INT             NOT NULL    COMMENT '재고',
    `image_id`              INT             NOT NULL    COMMENT '대표 이미지 ID',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sidedish`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sidedish`.`image` ;

CREATE TABLE IF NOT EXISTS `sidedish`.`image` (
    `id`            INT             NOT NULL     AUTO_INCREMENT      COMMENT '이미지 PK',
    `menu_id`       INT             NOT NULL     COMMENT '메뉴 정보',
    `image_path`    VARCHAR(1000)   NOT NULL     COMMENT '이미지 PATH',
    `is_main_image` TINYINT         NOT NULL     COMMENT '메인 이미지와 상세 이미지 판단',
    PRIMARY KEY (`id`),
    INDEX `fk_image_menu_idx` (`menu_id` ASC) VISIBLE,
    CONSTRAINT `fk_image_menu`
    FOREIGN KEY (`menu_id`)
    REFERENCES `sidedish`.`menu` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sidedish`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sidedish`.`user` ;

CREATE TABLE IF NOT EXISTS `sidedish`.`user` (
    `id`            INT             NOT NULL        AUTO_INCREMENT      COMMENT '유저 PK',
    `address`       VARCHAR(255)    NOT NULL        COMMENT '주소',
    `name`          VARCHAR(45)     NOT NULL        COMMENT '이름',
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sidedish`.`menu_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sidedish`.`menu_order` ;

CREATE TABLE IF NOT EXISTS `sidedish`.`menu_order` (
    `id`            INT             NOT NULL        AUTO_INCREMENT      COMMENT '주문 정보 PK',
    `user_id`       INT             NOT NULL        COMMENT '유저 FK',
    `menu_name`     VARCHAR(45)     NOT NULL        COMMENT '메뉴 이름',
    `menu_price`    INT             NOT NULL        COMMENT '(세일 적용 후) 메뉴 가격',
    `fee`           INT             NOT NULL        COMMENT '배송비',
    `quantity`      INT             UNSIGNED        NOT NULL            COMMENT '주문 수량',
    PRIMARY KEY (`id`),
    INDEX `fk_menu_order_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_menu_order_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `sidedish`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
