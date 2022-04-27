import styled from 'styled-components';

import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { LoadingSpinner } from '@/Components/LoadingSpinner';
import { ProductCard } from '@/Components/ProductCard';

const ProductCardList = styled.ul`
  display: flex;
  margin-top: 34px;
`;

const LS_MARGIN = 260;
const LS_RADIUS = 50;
const LS_BORDER_WIDTH = 10;

export const Contents = ({ bestProductsTabId }) => {
  const [bestProducts, isLoaded, isError] = useFetch(
    `${API_URL}/events/${bestProductsTabId}/items`
  );

  if (isError) {
    return <div>데이터를 불러오는데 실패했습니다.</div>;
  }

  if (!isLoaded) {
    return <LoadingSpinner margin={LS_MARGIN} radius={LS_RADIUS} borderWidth={LS_BORDER_WIDTH}/>;
  }

  return (
    <ProductCardList>
      {bestProducts.result_body.map(productCardData => (
        <ProductCard
          size={''}
          data={productCardData}
          key={productCardData.id}
        />
      ))}
    </ProductCardList>
  );
};
