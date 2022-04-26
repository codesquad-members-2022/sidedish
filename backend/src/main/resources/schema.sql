DROP TABLE IF EXISTS item_image;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS user;

-- -----------------------------------------------------
-- Table `test`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS category (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `test`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS item (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `PRICE` INT NOT NULL,
  `STOCK` INT NOT NULL,
  `MAIN_IMAGE_LINK` VARCHAR(500) NOT NULL,
  `DISCOUNT_POLICY` VARCHAR(45) NULL,
  `DISCOUNT_RATE` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ITEM_CATEGORY1_idx` (`CATEGORY_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ITEM_CATEGORY1`
    FOREIGN KEY (`CATEGORY_ID`)
    REFERENCES `category` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `test`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `OAUTH_ID` VARCHAR(45) NOT NULL,
  `USERNAME` VARCHAR(45) NOT NULL,
  `EMAIL` VARCHAR(45),
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `test`.`ORDER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orders (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `ITEM_ID` INT NOT NULL,
  `AMOUNT` INT NOT NULL,
  `ORDER_DATE_TIME` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `IS_CANCELLED` TINYINT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ORDER_USER_idx` (`USER_ID` ASC) VISIBLE,
  INDEX `fk_ORDERS_ITEM1_idx` (`ITEM_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ORDER_USER`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `user` (`ID`),
  CONSTRAINT `fk_ORDERS_ITEM1`
    FOREIGN KEY (`ITEM_ID`)
    REFERENCES `item` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `test`.`item_image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS item_image (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ITEM_ID` INT NOT NULL,
  `IMAGE_LINK` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ITEM_IMAGE_ITEM1_idx` (`ITEM_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ITEM_IMAGE_ITEM1`
    FOREIGN KEY (`ITEM_ID`)
    REFERENCES `item` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
