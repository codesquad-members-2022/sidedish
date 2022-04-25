import React, { useState } from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import Card from '../components/Card';
import { cardMargin, slideBtn } from '../css/variables';
import { color } from '../css/variables';

const CardContainer = ({ cardInfos, children, hasButton, cardNum }) => {
  const [curHeadCardOrder, setCurHeadCardOrder] = useState(1);
  const [slidingSize, setSlidingSize] = useState(0);
  const [disabledPrevBtn, setDisabledPrevBtn] = useState(false);
  const [disabledNextBtn, setDisabledNextBtn] = useState(false);

  const handleClickPrev = () => {
    const prevOrder = curHeadCardOrder - cardNum;
    const isLeakNFirstSlide = prevOrder >= -2 && prevOrder < 1;
    const isBelowHead = isLeakNFirstSlide || prevOrder === 1;
    if (isBelowHead) {
      setDisabledPrevBtn(true);
    } else {
      setDisabledPrevBtn(false);
    }
    setDisabledNextBtn(false);

    const sizeToMove = cardNum + curHeadCardOrder - (cardNum + 1);
    setCurHeadCardOrder(
      isLeakNFirstSlide
        ? curHeadCardOrder - sizeToMove
        : curHeadCardOrder - cardNum
    );

    const moveDefault = 100;
    const nextSlidingSize = isLeakNFirstSlide
      ? Math.floor(moveDefault * (sizeToMove / cardNum))
      : moveDefault;
    setSlidingSize(slidingSize + nextSlidingSize);
  };

  const handleClickNext = () => {
    const cardInfosLen = cardInfos.length;
    const nextHeadCardOrder = curHeadCardOrder + cardNum;

    const isOverTail =
      nextHeadCardOrder >= cardInfosLen ||
      nextHeadCardOrder + 1 >= cardInfosLen;
    if (isOverTail) {
      setDisabledNextBtn(true);
    } else {
      setDisabledNextBtn(false);
    }
    setDisabledPrevBtn(false);

    const leakCardSize = cardInfosLen % cardNum;
    const isLastSlide =
      (curHeadCardOrder + cardNum - 1) / cardNum ===
      Math.floor(cardInfosLen / cardNum);
    setCurHeadCardOrder(
      isLastSlide ? curHeadCardOrder + leakCardSize : curHeadCardOrder + cardNum
    );

    const moveDefault = 100;
    const nextSlidingSize = isLastSlide
      ? Math.floor(moveDefault * (leakCardSize / cardNum))
      : moveDefault;
    setSlidingSize(slidingSize - nextSlidingSize);
  };

  return (
    <StyledSection>
      {children}
      {hasButton && (
        <StyledLeftButton
          icon={'◀'}
          disabled={disabledPrevBtn}
          onClick={handleClickPrev}
        />
      )}
      {hasButton && (
        <StyledRightButton
          icon={'▶'}
          disabled={disabledNextBtn}
          onClick={handleClickNext}
        />
      )}
      <StyledDiv>
        <StyledCardContainer
          hasBtn={hasButton}
          cardNum={cardNum}
          slidingSize={slidingSize}
        >
          {cardInfos.map((cardInfo, idx) => (
            <StyledCard key={idx}>
              <Card cardInfo={cardInfo} cardNum={cardNum} />
            </StyledCard>
          ))}
        </StyledCardContainer>
      </StyledDiv>
    </StyledSection>
  );
};

const StyledDiv = styled.div`
  margin: 0 40px 0 40px;
  overflow: hidden;
`;

const StyledSection = styled.section`
  margin-top: 50px;
  position: relative;
`;

const StyledCardContainer = styled.ul`
  display: flex;
  transition: transform 1s ease 0s;
  transform: translateX(${({ slidingSize }) => slidingSize}%);
`;

const StyledCard = styled.li`
  margin-right: 24px;
`;

const StyledButton = styled(Button)`
  font-size: ${slideBtn.size}px;
  margin: 210px ${slideBtn.margin}px 0 0;
  padding: 0px;
  height: 0px;
  :disabled {
    color: ${color.greyFour};
  }
`;

const StyledLeftButton = styled(StyledButton)`
  position: absolute;
  left: 0px;
  z-index: 1;
`;

const StyledRightButton = styled(StyledButton)`
  position: absolute;
  right: 0px;
  z-index: 1;
`;

export default CardContainer;
