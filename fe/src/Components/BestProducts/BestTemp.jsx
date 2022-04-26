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
  const [bestProducts, isLoaded, isError] = useFetch(
    `${API_URL}/event/${bestProductsTabId}/items`
  );

  if (isError) return <div>데이터를 불러오는데 실패했습니다.</div>;
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
