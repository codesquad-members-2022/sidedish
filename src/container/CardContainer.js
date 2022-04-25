import React, { useState } from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import Card from '../components/Card';
import { slideBtn } from '../css/variables';
import { color } from '../css/variables';

const CardContainer = ({ cardInfos, children, hasButton, cardNum }) => {
  const [curHeadCardOrder, setCurHeadCardOrder] = useState(1);
  const [slidingSize, setSlidingSize] = useState(0);
  const [disabledPrevBtn, setDisabledPrevBtn] = useState(true);
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
    const showingHeadCardOrder = curHeadCardOrder + cardNum;

    const leakCardSize = cardInfosLen % cardNum;
    const isUndividedLastSlide =
      (showingHeadCardOrder - 1) / cardNum ===
      Math.floor(cardInfosLen / cardNum);

    if (
      isUndividedLastSlide ||
      showingHeadCardOrder + cardNum === cardInfosLen + 1
    ) {
      setDisabledNextBtn(true);
    } else {
      setDisabledNextBtn(false);
    }
    setDisabledPrevBtn(false);

    setCurHeadCardOrder(
      isUndividedLastSlide
        ? curHeadCardOrder + leakCardSize
        : showingHeadCardOrder
    );

    const moveDefault = 100;
    const nextSlidingSize = isUndividedLastSlide
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
