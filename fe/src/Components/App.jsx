import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { BestProducts } from '@/Components/BestProducts';
import { CategoryProductsList } from '@/Components/CategoryProductsList';
import { Header } from '@/Components/Header';
import { fetchData } from '@/Utils/Utils';

const Root = styled.div`
  width: 1440px;
  margin: 0 auto;
`;

const App = () => {
  const [categoryList, setCategoryList] = useState([]);
  const [categoryProductsList, setCategoryProductsList] = useState([]);
  const [isInitialDataLoaded, setIsInitialDataLoaded] = useState(false);
  const [error, setError] = useState(false);

  const fetchInitialData = async () => {
    const categoryListData = await fetchData('/categories');
    const firstCategoryIndex = 0;
    const { id: firstCategoryId, main: firstCategoryTitle } =
      categoryListData.content[firstCategoryIndex];
    const firstCategoryProductListData = await fetchData(
      `/category/${firstCategoryId}`
    );
    const firstCategoryProductList = {
      id: firstCategoryId,
      title: firstCategoryTitle,
      content: firstCategoryProductListData.content,
    };
    return [categoryListData.content, [firstCategoryProductList]];
  };

  useEffect(() => {
    fetchInitialData()
      .then(([initialCategoryList, initialCategoryProductList]) => {
        setCategoryList(initialCategoryList);
        // setCategoryProductsList(initialCategoryProductList);
        setIsInitialDataLoaded(true);
      })
      .catch(err => {
        console.error(err);
        setError(true);
      });
  }, []);

  return (
    <Root>
      <Header categoryList={categoryList} error={error} />
      <BestProducts />
      <CategoryProductsList
        categoryList={categoryList}
        categoryProductsList={categoryProductsList}
        setCategoryProductsList={setCategoryProductsList}
        isInitialDataLoaded={isInitialDataLoaded}
      />
    </Root>
  );
};

export default App;
