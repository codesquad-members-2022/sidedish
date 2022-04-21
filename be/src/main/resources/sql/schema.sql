DROP TABLE IF EXISTS

CREATE TABLE PRODUCT
(
    id              INTEGER         PRIMARY KEY   AUTO_INCREMENT,
    name            VARCHAR(30)     NOT NULL,
    content         VARCHAR(300)    NOT NULL,
    price           INT             NOT NULL,
    quantity        INTEGER         NOT NULL,
    dishType        VARCHAR(30)     NOT NULL,
    sideDishType    VARCHAR(30),
    applyEvent      VARCHAR(30)[],
    imgUrl          VARCHAR(300)[]
);
