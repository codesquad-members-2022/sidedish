import { useEffect } from 'react';
import styled from 'styled-components';

import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';

const ProductCardList = styled.ul`
  display: flex;
  margin-top: 34px;
`;

export const BestTemp = ({ bestProductsTabId }) => {
  const [bestProducts, isLoaded] = useFetch(
    `${API_URL}/event/${bestProductsTabId}/items`
  );

  useEffect(() => {
    if (!isLoaded) {
      return;
    }
  });

  if (!isLoaded) return <LoadingSpinner />;

  return (
    <ProductCardList>
      {bestProducts.content.map(productCardData => (
        <ProductCard
          size={''}
          data={productCardData}
          key={productCardData.id}
        />
      ))}
    </ProductCardList>
  );
};
