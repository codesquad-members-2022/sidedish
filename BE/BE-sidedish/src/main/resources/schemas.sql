-- 카테고리
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
    `category_id` int NOT NULL AUTO_INCREMENT,
    `category_name` varchar(50) NOT NULL,
    `category_event` tinyint NOT NULL,
    PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- 이미지
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
     `image_id` int NOT NULL AUTO_INCREMENT,
     `image_name` varchar(100) NOT NULL,
     `image_path` varchar(100) NOT NULL,
     `image_main` tinyint NOT NULL,
     PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- 메뉴
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
    `menu_id` int NOT NULL AUTO_INCREMENT,
    `menu_name` varchar(50) NOT NULL,
    `menu_content` varchar(100) NOT NULL,
    `menu_price` int NOT NULL,
    `category_id` int NOT NULL,
    `sale_id` int NOT NULL,
    `image_id` int NOT NULL,
    PRIMARY KEY (`menu_id`),
    KEY `category_id_idx` (`category_id`),
    KEY `sale_id_idx` (`sale_id`),
    KEY `image_id_idx` (`image_id`),
    CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
    CONSTRAINT `sale_id` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- 주문
DROP TABLE IF EXISTS `orderFrom`;
CREATE TABLE `orderFrom` (
     `order_id` int NOT NULL AUTO_INCREMENT,
     `order_info` varchar(100) NOT NULL,
     `order_fee` int NOT NULL,
     PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- 할인 정보
DROP TABLE IF EXISTS `orderFrom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderFrom` (
     `order_id` int NOT NULL AUTO_INCREMENT,
     `order_info` varchar(100) NOT NULL,
     `order_fee` int NOT NULL,
     PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;