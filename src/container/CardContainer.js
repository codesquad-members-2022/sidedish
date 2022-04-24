import React, { useState } from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import Card from '../components/Card';
import { cardMargin, slideBtn } from '../css/variables';
import { color } from '../css/variables';

const CardContainer = ({ cardInfos, children, hasButton, cardNum }) => {
  const [curHeadCardOrder, setCurHeadCardOrder] = useState(1);
  const [slidingSize, setSlidingSize] = useState(0);
  const [disabledNextBtn, setDisabledNextBtn] = useState(false);

  const isOutOfSlide = (current, target) => {
    return current >= target;
  };

  const handleClickNext = () => {
    const cardInfosLen = cardInfos.length;
    const nextHeadCardOrder = curHeadCardOrder + cardNum;
    if (isOutOfSlide(curHeadCardOrder + cardNum, cardInfosLen)) return;

    if (isOutOfSlide(nextHeadCardOrder + cardNum, cardInfosLen)) {
      setDisabledNextBtn(true);
    } else {
      setDisabledNextBtn(false);
    }

    const leakCardSize = cardInfosLen % cardNum;
    const isLastSlide =
      (curHeadCardOrder + cardNum - 1) / cardNum ===
      Math.floor(cardInfosLen / cardNum);
    setCurHeadCardOrder(curHeadCardOrder + cardNum);

    const moveDefault = 100;
    const nextSlidingSize = isLastSlide
      ? Math.floor(moveDefault * (leakCardSize / cardNum))
      : moveDefault;

    setSlidingSize(slidingSize - nextSlidingSize);
  };

  return (
    <StyledSection>
      {children}
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
      {hasButton && <StyledButton icon={'◀'} isOutOfSlide={isOutOfSlide} />}
      {hasButton && (
        <StyledButton
          icon={'▶'}
          disabled={disabledNextBtn}
          isOutOfSlide={isOutOfSlide}
          onClick={handleClickNext}
        />
      )}
    </StyledSection>
  );
};

const StyledSection = styled.section`
  margin-top: 50px;
  overflow: hidden;
`;

const StyledCardContainer = styled.ul`
  display: flex;
  transition: transform 1s ease 0s;
  transform: translateX(${({ slidingSize }) => slidingSize}%);
`;

const StyledCard = styled.li`
  margin-right: ${cardMargin.right}px;
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

export default CardContainer;
