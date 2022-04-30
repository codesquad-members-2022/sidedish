import styled, { css } from 'styled-components';
import Card from 'Main/Card';
import { useState, useRef } from 'react';
import { ReactComponent as LeftArrowIcon } from 'image/leftArrow.svg';
import { ReactComponent as RightArrowIcon } from 'image/rightArrow.svg';
import {
  MAIN_SLIDER_IMG_COUNT,
  MAIN_SLIDER_INIT_POSITION,
  MAIN_IMAGE_WIDTH,
  SLIDER_TRANSITION_TIME,
} from 'constant';

const DishContainerWrapper = styled.div`
  position: relative;
`;

const DishContainerBox = styled.div`
  overflow: hidden;
  padding: 34px 0 56px 0;

  h2 {
    margin-bottom: 40px;
    ${({ theme }) => theme.fontStyles.xLargeBold};
  }
`;

const DishCardList = styled.div`
  ${({ theme }) => theme.flexLayout.default};
`;

const LeftArrow = styled(LeftArrowIcon)`
  position: absolute;
  top: 50%;
  left: -42px;
  cursor: pointer;

  path {
    stroke: ${(props) => {
      return props.focus === 'true'
        ? css`
            ${({ theme }) => theme.colors.black}
          `
        : css`
            ${({ theme }) => theme.colors.gray3}
          `;
    }};
  }
`;

const RightArrow = styled(RightArrowIcon)`
  position: absolute;
  top: 50%;
  right: -42px;
  cursor: pointer;
  path {
    stroke: ${(props) => {
      return props.focus === 'true'
        ? css`
            ${({ theme }) => theme.colors.black}
          `
        : css`
            ${({ theme }) => theme.colors.gray3}
          `;
    }};
  }
`;

const DishContainer = ({ items }) => {
  const cardList = items.dishes.map((item) => {
    return <Card key={item.id} item={item} imageSize={'medium'}></Card>;
  });

  const totalCount = items.dishes.length;
  const currentPosition = useRef(MAIN_SLIDER_INIT_POSITION);
  const slider = useRef();
  const [leftFocus, setLeftFocus] = useState(false);
  const [rightFocus, setRightFocus] = useState(true);

  const checkFirstAndLastPosition = (arrow) => {
    if (currentPosition.current < MAIN_SLIDER_INIT_POSITION && arrow === 'left') {
      currentPosition.current = MAIN_SLIDER_INIT_POSITION;
      setLeftFocus(false);
      return;
    }

    if (currentPosition.current + MAIN_SLIDER_IMG_COUNT > totalCount && arrow === 'right') {
      const remainder = Math.floor(totalCount % MAIN_SLIDER_IMG_COUNT);
      currentPosition.current = currentPosition.current - MAIN_SLIDER_IMG_COUNT + remainder;
      setRightFocus(false);
      return;
    }
  };

  const calculatePosition = (arrow) => {
    if (arrow === 'left') {
      currentPosition.current -= MAIN_SLIDER_IMG_COUNT;
    } else if (arrow === 'right') {
      currentPosition.current += MAIN_SLIDER_IMG_COUNT;
    }

    setRightFocus(true);
    setLeftFocus(true);
    checkFirstAndLastPosition(arrow);

    slider.current.style.transform = `translateX(${-currentPosition.current * MAIN_IMAGE_WIDTH}px)`;
    slider.current.style.transition = `transform ${SLIDER_TRANSITION_TIME}ms`;
  };

  const onClickLeft = () => {
    if (currentPosition.current === MAIN_SLIDER_INIT_POSITION) return;
    calculatePosition('left');
  };

  const onClickRight = () => {
    if (currentPosition.current + MAIN_SLIDER_IMG_COUNT >= totalCount) return;
    calculatePosition('right');
  };

  return (
    <DishContainerWrapper>
      <DishContainerBox>
        <h2>{items.category.description}</h2>
        <DishCardList ref={slider}>{cardList}</DishCardList>
      </DishContainerBox>
      <LeftArrow onClick={onClickLeft} focus={String(leftFocus)} />
      <RightArrow onClick={onClickRight} focus={String(rightFocus)} />
    </DishContainerWrapper>
  );
};

export default DishContainer;
