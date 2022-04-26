import styled from "styled-components";

import { ProductCard } from '@Components/ProductCard';

const ProductCardList = styled.ul`
  display: flex;
  margin-top: 34px;
`;

export const BestTemp = ({ cardData }) => {
  return (
    <ProductCardList>
      {cardData.map(productCardData => (
        <ProductCard
          size={''}
          data={productCardData}
          key={productCardData.id}
        />
      ))}
    </ProductCardList>
  );
};
