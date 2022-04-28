import React, { useState } from 'react';
import styled from 'styled-components';
import Card from './Card';
import left from '../images/left.png';
import right from '../images/right.png';
import CardSlider from './CardSlider';

function CategoryMenu({ name, items, showModal }) {
  const [startCardIndex, setStartCardIndex] = useState(0);
  const NUMBER_OF_CARDS = 4;
  function moveCardsLeft() {
    const leftCards = startCardIndex;
    if (leftCards >= NUMBER_OF_CARDS) {
      setStartCardIndex(startCardIndex - NUMBER_OF_CARDS);
    } else {
      setStartCardIndex(startCardIndex - leftCards);
    }
  }
  function moveCardsRight() {
    const leftCards = items.length - (startCardIndex + NUMBER_OF_CARDS);
    if (leftCards >= 4) {
      setStartCardIndex(startCardIndex + NUMBER_OF_CARDS);
    } else {
      setStartCardIndex(startCardIndex + leftCards);
    }
  }

  return (
    <StyledCategoryMenu>
      <Title>{name}</Title>
      <CardSlide>
        <ButtonWrapper>
          <Button onClick={moveCardsLeft} disabled={startCardIndex === 0}>
            <Image src={left}></Image>
          </Button>
        </ButtonWrapper>
        <CardListWrapper>
          <CardSlider items={items} showModal={showModal} startCardIndex={startCardIndex} />
        </CardListWrapper>
        <ButtonWrapper>
          <Button onClick={moveCardsRight} disabled={startCardIndex === items.length - NUMBER_OF_CARDS}>
            <Image src={right}></Image>
          </Button>
        </ButtonWrapper>
      </CardSlide>
    </StyledCategoryMenu>
  );
}

const StyledCategoryMenu = styled.div``;
const Title = styled.div`
  margin: 56px 80px 40px 80px;
  font-weight: 500;
  font-size: 24px;
  line-height: 38px;
`;
const CardSlide = styled.div`
  display: flex;
`;
const ButtonWrapper = styled.div`
  display: flex;
  width: 80px;
`;
const Button = styled.button`
  margin: auto;
  height: 16px;
  ${props => props.disabled && `filter: opacity(0.4) drop-shadow(0 0 0 white);`}
`;
const Image = styled.img`
  max-width: 100%;
  max-height: 100%;
`;
const CardList = styled.div`
  width: 200%;
  display: flex;
  flex-shrink: 0;
  flex-basis: 302px;
  gap: 10px;
  /* justify-content: space-between; */
`;
const CardListWrapper = styled.div`
  width: auto;
`;
export default CategoryMenu;
