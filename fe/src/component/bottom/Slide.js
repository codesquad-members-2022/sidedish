import React, { useState } from "react";
import styled from "styled-components";
import Card from "../UI/Card";
import { SlideIcon } from "../icons/SlideIcon";
import constansts from "../../constants/constansts";

const SlideWrapper = styled.div`
  position: relative;
  height: 460px;
  display: none;
  &.active {
    display: block;
  }
`;

const SlideTitle = styled.h5`
  font-size: ${({ theme }) => theme.fontSize.mLarge};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  color: ${({ theme }) => theme.colors.black};
  margin: 40px 0 20px 40px;
`;

const SlideCardWrapper = styled.div`
  position: absolute;
  width: 1280px;
  height: 450px;
  overflow: hidden;
  margin-left: 50px;
`;

const SlideCardsList = styled.div`
  display: flex;
  transform: translateX(${({ currentTranslateX }) => currentTranslateX});
`;

const Slide = ({ title, cardData, alwaysDisplayed, isDisplayed }) => {
  const [cardListTranslateX, setCardListTranslateX] = useState(0);
  const cardSize = constansts.CardSize.small;
  const maxTranslateX = -(cardData.length * cardSize) + 4 * cardSize;
  const onClickRightHandler = () => {
    setCardListTranslateX((prev) =>
      prev - cardSize >= maxTranslateX ? prev - cardSize : prev
    );
  };

  const onClickLeftHandler = () => {
    setCardListTranslateX((prev) =>
      prev + cardSize <= 0 ? prev + cardSize : prev
    );
  };

  return (
    <SlideWrapper
      className={isDisplayed ? "active" : ""}
      style={{ display: alwaysDisplayed && "block" }}
    >
      <SlideTitle>{title}</SlideTitle>
      <SlideCardWrapper>
        <SlideCardsList currentTranslateX={`${cardListTranslateX}px`}>
          {cardData.map((v) => {
            return (
              <Card
                size="small"
                id={v.id}
                key={v.id}
                image={v.imgUrl}
                alt={v.name}
                title={v.name}
                description={v.content}
                discountPrice={v.discountPrice}
                originPrice={v.price}
                badge={v.applyEvent}
              />
            );
          })}
        </SlideCardsList>
      </SlideCardWrapper>
      <SlideIcon
        place="mainSlide"
        onClickRightBtn={onClickRightHandler}
        onClickLeftBtn={onClickLeftHandler}
        current={cardListTranslateX}
        max={maxTranslateX}
        min={0}
      />
    </SlideWrapper>
  );
};

export default Slide;
