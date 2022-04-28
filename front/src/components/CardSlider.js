import styled, { useTheme } from 'styled-components';
import Card from './Card';
import { useState } from 'react';

function CardSlider({ items, showModal, startCardIndex, NUMBER_OF_CARDS, width, cardSize }) {
  const theme = useTheme();
  const [gap] = useState((width - NUMBER_OF_CARDS * theme.cardSizes[cardSize].width) / (NUMBER_OF_CARDS - 1));
  // gap을 변수로 선언했을때 적용이 안되서 상태로 변경함 물어보기!
  return (
    <CardSliderWrap>
      <CardListWrap width={width}>
        <CardList startCardIndex={startCardIndex} gap={gap} cardSize={cardSize}>
          {items.map((item, index) => (
            <CardListItem key={index}>
              <Card size={cardSize} item={item} showModal={showModal}></Card>
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
  transform: translateX(
    -${({ theme, startCardIndex, gap, cardSize }) => startCardIndex * (theme.cardSizes[cardSize].width + gap)}px
  );
  transition: 1s;
  gap: ${props => props.gap}px;
`;
const CardListItem = styled.li``;
const CardListWrap = styled.div`
  width: ${props => props.width}px;
  overflow: hidden;
`;
export default CardSlider;
