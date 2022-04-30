import styled from 'styled-components';

import FoodCard from './FoodCard';

const CardsWrap = styled.ul`
  ${(props) =>
    props.type === 'modal'
      ? `padding-top: 67px;
  padding-left: 20px;
  padding-right: 20px;`
      : 'padding: 80px;'}
  display: grid;
  grid-template-columns: ${(props) => `repeat(${props.size}, 1fr)`};
`;

const FoodCards = ({ foods, size, type = '' }) => (
  <CardsWrap size={size} type={type}>
    {foods?.map((food) => (
      <FoodCard key={food.title + food.id} food={food} type={type} />
    ))}
  </CardsWrap>
);

export default FoodCards;
