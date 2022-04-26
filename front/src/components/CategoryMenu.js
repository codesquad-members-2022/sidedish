import React, { useState } from 'react';
import styled from 'styled-components';
import Card from './Card';
import left from '../images/left.png';
import right from '../images/right.png';

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
        <CardList>
          {items
            .filter((_, index) => index >= startCardIndex && index <= startCardIndex + (NUMBER_OF_CARDS - 1))
            .map(item => (
              <Card key={item.id} size={'medium'} item={item} showModal={showModal}></Card>
            ))}
        </CardList>
        <ButtonWrapper>
          <Button onClick={moveCardsRight} disabled={startCardIndex === items.length - NUMBER_OF_CARDS}>
            <Image src={right}></Image>
          </Button>
        </ButtonWrapper>
      </CardSlide>
    </StyledCategoryMenu>
  );
}

CategoryMenu.defaultProps = {
  name: '정갈한 밑반찬',
  items: [
    {
      id: 0,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 1',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 1,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 2',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 2,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 3',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 3,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 4',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 4,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 5',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 5,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 6',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 5,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 7',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 5,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 8',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
    {
      id: 5,
      image: 'https://static.wtable.co.kr/image/production/service/recipe/873/1c52a4fd-68fb-458f-aa6c-cf3537d674df.jpg',
      title: '편리한 반찬 9',
      contents: '스테이크 먹고싶다',
      origin_price: 50000,
      discount_price: 39800,
      early_delivery: true,
      badge_title: ['이벤트특가', '런칭특가'],
      categories: ['메인 요리'],
    },
  ],
};

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
  width: 100%;
  display: flex;
  justify-content: space-between;
`;

export default CategoryMenu;
