import styled, { css } from 'styled-components';
import Card from 'Main/Card';
import { useState, useRef } from 'react';
import { ReactComponent as LeftArrowIcon } from 'image/leftArrow.svg';
import { ReactComponent as RightArrowIcon } from 'image/rightArrow.svg';
import { MAIN_ITEMS } from 'MockData/dummyData';

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

const DishContainer = () => {
  const cardList = MAIN_ITEMS.data.map((item) => {
    return <Card key={item.id} item={item} imageSize={'medium'}></Card>;
  });

  const totalCount = MAIN_ITEMS.data.length;
  const currentPosition = useRef(0);
  const slider = useRef();
  const [leftFocus, setLeftFocus] = useState(false);
  const [rightFocus, setRightFocus] = useState(true);

  const checkFirstAndLastPosition = (arrow) => {
    if (currentPosition.current < 0 && arrow === 'left') {
      currentPosition.current = 0;
      setLeftFocus(false);
      return;
    }

    if (currentPosition.current + 4 > totalCount && arrow === 'right') {
      const remainder = Math.floor(totalCount % 4);
      currentPosition.current = currentPosition.current - 4 + remainder;
      setRightFocus(false);
      return;
    }
  };

  const calculatePosition = (arrow) => {
    if (arrow === 'left') {
      currentPosition.current -= 4;
    } else if (arrow === 'right') {
      currentPosition.current += 4;
    }

    setRightFocus(true);
    setLeftFocus(true);
    checkFirstAndLastPosition(arrow);
    slider.current.style.transform = `translateX(${-currentPosition.current * 326}px)`;
    slider.current.style.transition = 'transform 500ms';
  };

  const onClickLeft = () => {
    if (currentPosition.current === 0) return;
    calculatePosition('left');
  };

  const onClickRight = () => {
    if (currentPosition.current + 4 >= totalCount) return;
    calculatePosition('right');
  };

  return (
    <DishContainerWrapper>
      <DishContainerBox>
        <h2>{MAIN_ITEMS.title}</h2>
        <DishCardList ref={slider}>{cardList}</DishCardList>
      </DishContainerBox>
      <LeftArrow onClick={onClickLeft} focus={String(leftFocus)} />
      <RightArrow onClick={onClickRight} focus={String(rightFocus)} />
    </DishContainerWrapper>
  );
};

export default DishContainer;
