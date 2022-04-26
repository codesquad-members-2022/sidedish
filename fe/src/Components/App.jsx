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
  const [categoryList, isLoaded, isError] = useFetch(`${API_URL}/categories`);
  
  // TODO: 에러 발생시 보여줄 화면
  if (isError) return null

  // TODO: 로딩중 보여줄 화면
  if (!isLoaded) return null;

  return (
    <Root>
      <Header categoryList={categoryList.result_body} />
      <BestProducts />
      <CategoryProductsList categoryList={categoryList.result_body} />
      <OrderPanel />
    </Root>
  );
};

export default App;
