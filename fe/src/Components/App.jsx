import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { fetchData } from '@/Utils';

import { BestProducts } from '@/Components/BestProducts';
import { CategoryProductsList } from '@/Components/CategoryProductsList';
import { Header } from '@/Components/Header';
import { OrderPanel } from '@/Components/OrderModal';

const Root = styled.div`
  width: 1440px;
  margin: 0 auto;
`;

const App = () => {
  const [categoryList, setCategoryList] = useState([]);
  const [error, setError] = useState(false);

  const fetchInitialData = async () => {
    const categoryListData = await fetchData('/categories');
    return categoryListData.content;
  };

  useEffect(() => {
    fetchInitialData()
      .then(initialCategoryList => {
        setCategoryList(initialCategoryList);
      })
      .catch(err => {
        // TODO: 에러핸들링
        console.error(err);
        setError(true);
      });
  }, []);

  return (
    <Root>
      <Header categoryList={categoryList} error={error} />
      <BestProducts />
      <CategoryProductsList categoryList={categoryList} />
      <OrderPanel />
    </Root>
  );
};

export default App;
