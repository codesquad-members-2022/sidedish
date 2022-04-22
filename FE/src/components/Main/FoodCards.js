import styled from 'styled-components';

import FoodCard from './FoodCard';

const CardsWrap = styled.ul`
  padding: 80px;
  display: grid;
  grid-template-columns: ${(props) => `repeat(${props.size}, 1fr)`};
`;

const FoodCards = ({ foods, size }) => (
  <CardsWrap size={size}>
    {foods.map((food) => (
      <FoodCard key={food.detail_hash} food={food} />
    ))}
  </CardsWrap>
);

export default FoodCards;
