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

const Slide = ({ cardData, alwaysDisplayed, isDisplayed }) => {
  const [cardListTranslateX, setCardListTranslateX] = useState(0);
  const cardSize = constansts.CardSize.small;
  const maxTranslateX = -(cardData.body.length * cardSize) + 4 * cardSize;
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

  const click = (event, props) => {
    console.log(event.target.id);
  };

  return (
    <SlideWrapper
      className={isDisplayed ? "active" : ""}
      style={{ display: alwaysDisplayed && "block" }}
    >
      <SlideTitle>식탁을 풍성하게 하는 정갈한 밑반찬</SlideTitle>
      <SlideCardWrapper>
        <SlideCardsList
          currentTranslateX={cardListTranslateX.toString() + "px"}
        >
          {cardData.body.map((v) => {
            return (
              <Card
                id={v.detail_hash}
                size="small"
                key={v.detail_hash}
                image={v.image}
                alt={v.alt}
                title={v.title}
                description={v.description}
                s_price={v.s_price}
                n_price={v.n_price}
                badge={v.badge}
                delivery={v.delivery_type}
                onSaveClickedId={click}
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
