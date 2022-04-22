DROP TABLE IF EXISTS ITEM_IMAGE;
DROP TABLE IF EXISTS ITEM;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS `ORDER`;
DROP TABLE IF EXISTS USER;

-- -----------------------------------------------------
-- Table `test`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`CATEGORY` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `test`.`ITEM`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`ITEM` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` INT NOT NULL,
  `NAME` VARCHAR(45) NOT NULL,
  `DESCRIPTION` VARCHAR(100) NOT NULL,
  `PRICE` DECIMAL(6,0) NOT NULL,
  `STOCK` INT NOT NULL,
  `MAIN_IMAGE_LINK` VARCHAR(500) NOT NULL,
  `DISCOUNT_POLICY` VARCHAR(45) NULL,
  `DISCOUNT_RATE` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ITEM_CATEGORY1_idx` (`CATEGORY_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ITEM_CATEGORY1`
    FOREIGN KEY (`CATEGORY_ID`)
    REFERENCES `test`.`CATEGORY` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `test`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`USER` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `test`.`ORDER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`ORDERS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `USER_ID` INT NOT NULL,
  `ITEM_ID` INT NOT NULL,
  `AMOUNT` INT NOT NULL,
  `ORDER_DATE` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CANCELLED` TINYINT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ORDER_USER_idx` (`USER_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ORDER_USER`
    FOREIGN KEY (`USER_ID`)
    REFERENCES `test`.`USER` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;

-- -----------------------------------------------------
-- Table `test`.`ITEM_IMAGE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`ITEM_IMAGE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ITEM_ID` INT NOT NULL,
  `IMAGE_LINK` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ITEM_IMAGE_ITEM1_idx` (`ITEM_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ITEM_IMAGE_ITEM1`
    FOREIGN KEY (`ITEM_ID`)
    REFERENCES `test`.`ITEM` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;
