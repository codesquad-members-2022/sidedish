import React, { useState } from 'react';
import styled from 'styled-components';

import Button from '../components/Button';
import CardBox from '../components/CardBox';
import { slideBtn } from '../css/variables';
import { color } from '../css/variables';

const changeBtnActivation = (
  isImmovable,
  setSelectedBtnActivate,
  setAnotherBtnActivate
) => {
  if (isImmovable) {
    setSelectedBtnActivate(true);
  } else {
    setSelectedBtnActivate(false);
  }
  setAnotherBtnActivate(false);
};

const getSlidingSize = (isMoveableSlide, sizeToMove, cardNum) => {
  const moveDefault = 100;
  const slidingSize = isMoveableSlide
    ? Math.floor(moveDefault * (sizeToMove / cardNum))
    : moveDefault;
  return slidingSize;
};

const CardContainer = ({
  cardInfos,
  children,
  hasButton,
  cardNum,
  handleModal,
}) => {
  const initialHeadCardOrder = 1;

  const [curHeadCardOrder, setCurHeadCardOrder] =
    useState(initialHeadCardOrder);
  const [slidingSize, setSlidingSize] = useState(0);
  const [disabledPrevBtn, setDisabledPrevBtn] = useState(true);
  const [disabledNextBtn, setDisabledNextBtn] = useState(false);

  const handleClickPrev = () => {
    if (disabledPrevBtn) return;

    /**
     * 1 2 3 4 | 5 6 7 8 (이전에 4개 있는 경우)
     * 5 - 4 => 1
     * 1 2 3 | 4 5 6 7 |(이전에 3개 있는 경우)
     * 4 - 4 => 0
     * 1 2 | 3 4 5 6 | (이전에 2개 있는 경우)
     * 3 - 4 => -1
     * 1 | 2 3 4 5 | (이전에 1개 있는 경우)
     * 2- 4 => -2
     */
    const prevOrder = curHeadCardOrder - cardNum;
    const isLeakNFirstSlide = prevOrder >= -2 && prevOrder < 1;

    const isFirstShowingSlide =
      isLeakNFirstSlide || prevOrder === initialHeadCardOrder;

    changeBtnActivation(
      isFirstShowingSlide,
      setDisabledPrevBtn,
      setDisabledNextBtn
    );

    /**
     * if(cardNum = 4) 1 2 3 | 4 5 6 7 | => 4 + 4 - (4 + 1) = 3
     * if(cardNum = 3) 1 2 | 3 4 5 | => 3 + 3 - (3 + 1) = 2
     */
    const sizeToMove =
      cardNum + curHeadCardOrder - (cardNum + initialHeadCardOrder);

    setCurHeadCardOrder(
      isLeakNFirstSlide
        ? curHeadCardOrder - sizeToMove
        : curHeadCardOrder - cardNum
    );

    const prevSlidingSize = getSlidingSize(
      isLeakNFirstSlide,
      sizeToMove,
      cardNum
    );

    setSlidingSize(slidingSize + prevSlidingSize);
  };

  const handleClickNext = () => {
    if (disabledNextBtn) return;

    const cardInfosLen = cardInfos.length;
    const showingHeadCardOrder = curHeadCardOrder + cardNum;
    const sizeToMove = cardInfosLen % cardNum;

    const isUndividedLastSlide =
      (showingHeadCardOrder - initialHeadCardOrder) / cardNum ===
      Math.floor(cardInfosLen / cardNum);

    const isDividedLastSlide =
      showingHeadCardOrder + cardNum === cardInfosLen + initialHeadCardOrder;

    const isLastShowingSlide = isUndividedLastSlide || isDividedLastSlide;

    changeBtnActivation(
      isLastShowingSlide,
      setDisabledNextBtn,
      setDisabledPrevBtn
    );

    setCurHeadCardOrder(
      isUndividedLastSlide
        ? curHeadCardOrder + sizeToMove
        : showingHeadCardOrder
    );

    const nextSlidingSize = getSlidingSize(
      isUndividedLastSlide,
      sizeToMove,
      cardNum
    );

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
        <CardBox
          hasBtn={hasButton}
          cardNum={cardNum}
          slidingSize={slidingSize}
          cardInfos={cardInfos}
          handleModal={handleModal}
        />
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
