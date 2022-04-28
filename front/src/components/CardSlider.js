import styled from 'styled-components';
import Card from './Card';
import { useState } from 'react';

function CardSlider({ items, showModal, startCardIndex, NUMBER_OF_CARDS, width, cardSize }) {
  const cardSizes = {
    // 테마에서 가져오도록 변경 예정
    large: { width: 411, height: 565 },
    medium: { width: 302, height: 456 },
    small: { width: 160, height: 226 },
  };
  const [gap, setGap] = useState((width - NUMBER_OF_CARDS * cardSizes[cardSize].width) / (NUMBER_OF_CARDS - 1));
  // gap을 변수로 선언했을때 적용이 안되서 상태로 변경함 물어보기!
  return (
    <CardSliderWrap>
      <CardListWrap>
        <CardList startCardIndex={startCardIndex} gap={gap} cardWidth={cardSizes[cardSize].width}>
          {items.map((item, index) => (
            <CardListItem>
              <Card key={index} size={cardSize} item={item} showModal={showModal}></Card>
            </CardListItem>
          ))}
        </CardList>
      </CardListWrap>
    </CardSliderWrap>
  );
}

const CardSliderWrap = styled.div``;
const CardList = styled.ul`
  display: flex;
  transform: translateX(-${({ startCardIndex, gap, cardWidth }) => startCardIndex * (cardWidth + gap)}px);
  transition: 1s;
  gap: ${props => props.gap}px;
`;
const CardListItem = styled.li``;
const CardListWrap = styled.div`
  width: ${props => props.width}px;
  overflow: hidden;
`;
export default CardSlider;
