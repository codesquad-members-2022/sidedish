import { useEffect, useState } from 'react';

import { Header } from '@Header';
import { Main } from '@Main';

import { fetchData } from '@/Utils/Utils';

const App = () => {
  const [categoryList, setCategoryList] = useState([]);
  const [loadedCategoryProductList, setLoadedCategoryProductList] = useState(
    []
  );
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
        setLoadedCategoryProductList(initialCategoryProductList);
      })
      .catch(err => {
        console.error(err);
        setError(true);
      });
  }, []);

  return (
    <>
      <Header categories={categoryList} error={error} />
      <Main
        error={error}
        categories={categoryList}
        loadedCategories={loadedCategoryProductList}
        setLoadedCategories={setLoadedCategoryProductList}
      />
    </>
  );
};

export default App;
