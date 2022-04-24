import React, { useState } from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import Card from '../components/Card';
import { cardMargin } from '../css/variables';

const CardContainer = ({ cardInfos, children, hasButton, cardNum }) => {
  const [curHeadCardOrder, setCurHeadCardOrder] = useState(1);
  const [slidingSize, setSlidingSize] = useState(0);

  const isOutOfSlide = (cardInfosLen) => {
    return curHeadCardOrder + cardNum >= cardInfosLen;
  };

  const handleClickNext = () => {
    const cardInfosLen = cardInfos.length;
    if (isOutOfSlide(cardInfosLen)) return;

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
      {hasButton && <Button icon={'◀'} />}
      {hasButton && <Button icon={'▶'} onClick={handleClickNext} />}
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

export default CardContainer;
