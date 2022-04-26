import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { API_URL } from '@/Env';
import { useFetch } from '@/Hooks';

import { BestProducts } from '@/Components/BestProducts';
import { CategoryProductsList } from '@/Components/CategoryProductsList';
import { Header } from '@/Components/Header';
import { OrderPanel } from '@/Components/OrderModal';

const Root = styled.div`
  width: 1440px;
  margin: 0 auto;
`;

const App = () => {
  const [categoryList, isLoaded] = useFetch('/categories');
  // 배포용
  // const [categoryList, isLoaded] = useFetch(`${API_URL}/categories`);

  return (
    <Root>
      {isLoaded && <Header categoryList={categoryList.result_body} />}
      <BestProducts />
      {/*<CategoryProductsList categoryList={categoryList} />*/}
      <OrderPanel />
    </Root>
  );
};

export default App;
