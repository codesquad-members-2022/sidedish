import { useEffect, useState } from 'react';

import { Header } from '@Components/Header';
import { Main } from '@Components/Main';

import { fetchData } from '@/Utils/Utils';

const App = () => {
  const [categoryList, setCategoryList] = useState([]);
  const [categoryProductList, setCategoryProductList] = useState([]);
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
        setCategoryProductList(initialCategoryProductList);
      })
      .catch(err => {
        console.error(err);
        setError(true);
      });
  }, []);

  return (
    <>
      <Header categoryList={categoryList} error={error} />
      <Main
        error={error}
        categoryList={categoryList}
        categoryProductList={categoryProductList}
        setCategoryProductList={setCategoryProductList}
      />
    </>
  );
};

export default App;
