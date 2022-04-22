DROP TABLE IF EXISTS product_order, user, image, product;

CREATE TABLE product (
                         id              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         title           varchar(64) NOT NULL,
                         description     varchar(255) NOT NULL,
                         price           int NOT NULL,
                         stock           int NOT NULL,
                         event_badge     enum('none', 'launching', 'event') NOT NULL,
                         main_category   enum('main', 'soup', 'side') NOT NULL,
                         event_category  enum('meat', 'side_set', 'season', 'kids_side') NOT NULL
);

CREATE TABLE image (
                      id              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      product_id      BIGINT NOT NULL,
                      image_path      varchar(255) NOT NULL,
                      FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE user (
                      id              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      address         varchar(255) NOT NULL,
                      name            varchar(32) NOT NULL
);

CREATE TABLE product_order(
                              id              BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              product_id      BIGINT NOT NULL,
                              user_id         BIGINT NOT NULL,
                              quantity        int,
                              FOREIGN KEY (product_id) REFERENCES product(id),
                              FOREIGN KEY (user_id) REFERENCES user(id)
);
