import styled from 'styled-components';
import Card from './Card';

function CardSlider({ items, showModal, startCardIndex }) {
  return (
    <CardSliderWrap>
      <CardListWrap>
        <CardList startCardIndex={startCardIndex}>
          {items.map((item, index) => (
            <CardListItem>
              <Card key={index} size={'medium'} item={item} showModal={showModal}></Card>
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
  transform: translateX(-${({ startCardIndex }) => startCardIndex * (302 + 24)}px);
  transition: 1s;
  gap: 24px;
`;
const CardListItem = styled.li``;
const CardListWrap = styled.div`
  width: 1280px;
  overflow: hidden;
`;
export default CardSlider;
