import React, { useState } from 'react';
import styled from 'styled-components';

import Button from './Button';
import { slideBtn } from '../css/variables';

const Slider = ({
  showingSlideCardNum,
  handleClickSlide,
  cardInfos,
  hasButton,
}) => {
  const initialHeadCardOrder = 1;

  const [curHeadCardOrder, setCurHeadCardOrder] =
    useState(initialHeadCardOrder);
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
    const prevOrder = curHeadCardOrder - showingSlideCardNum;
    const isLeakNFirstSlide = prevOrder >= -2 && prevOrder < 1;
    const isFirstShowingSlide =
      isLeakNFirstSlide || prevOrder === initialHeadCardOrder;

    changeBtnActivation(
      isFirstShowingSlide,
      setDisabledPrevBtn,
      setDisabledNextBtn
    );

    /**
     * if(showingSlideCardNum = 4) 1 2 3 | 4 5 6 7 | => 4 + 4 - (4 + 1) = 3
     * if(showingSlideCardNum = 3) 1 2 | 3 4 5 | => 3 + 3 - (3 + 1) = 2
     */
    const sizeToMove =
      showingSlideCardNum +
      curHeadCardOrder -
      (showingSlideCardNum + initialHeadCardOrder);

    setCurHeadCardOrder(
      isLeakNFirstSlide
        ? curHeadCardOrder - sizeToMove
        : curHeadCardOrder - showingSlideCardNum
    );

    const prevSlidingSize = getSlidingSize(
      isLeakNFirstSlide,
      sizeToMove,
      showingSlideCardNum
    );

    handleClickSlide(prevSlidingSize);
  };

  const handleClickNext = () => {
    if (disabledNextBtn) return;

    const cardInfosLen = cardInfos.length;
    const showingHeadCardOrder = curHeadCardOrder + showingSlideCardNum;
    const sizeToMove = cardInfosLen % showingSlideCardNum;

    const isUndividedLastSlide =
      (showingHeadCardOrder - initialHeadCardOrder) / showingSlideCardNum ===
      Math.floor(cardInfosLen / showingSlideCardNum);

    const isDividedLastSlide =
      showingHeadCardOrder + showingSlideCardNum ===
      cardInfosLen + initialHeadCardOrder;

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
      showingSlideCardNum
    );

    handleClickSlide(-nextSlidingSize);
  };

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

  const getSlidingSize = (isMoveableSlide, sizeToMove, showingSlideCardNum) => {
    const moveDefault = 100;
    const slidingSize = isMoveableSlide
      ? Math.floor(moveDefault * (sizeToMove / showingSlideCardNum))
      : moveDefault;
    return slidingSize;
  };

  return (
    <>
      {hasButton && (
        <>
          <StyledLeftButton
            icon={'◀'}
            disabled={disabledPrevBtn}
            onClick={handleClickPrev}
          />
          <StyledRightButton
            icon={'▶'}
            disabled={disabledNextBtn}
            onClick={handleClickNext}
          />
        </>
      )}
    </>
  );
};

const StyledButton = styled(Button)`
  font-size: ${slideBtn.size}px;
  margin: 210px ${slideBtn.margin}px 0 0;
  padding: 0px;
  height: 0px;
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

export default Slider;
