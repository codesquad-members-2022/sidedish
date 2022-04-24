import { useEffect, useState } from 'react';

import { Header } from '@Header';
import { Main } from '@Main';

const App = () => {
  const [categoryList, setCategoryList] = useState([]);
  const [loadedCategoryProductList, setLoadedCategoryProductList] = useState(
    []
  );

  const fetchCategoryList = async () => {
    try {
      const response = await fetch('/categories');
      return await response.json();
    } catch (err) {
      // TODO: 에러 핸들링
      console.error(err);
      return [];
    }
  };

  const fetchFirstCategoryProductList = async id => {
    const fetchUrl = `/category/${id}`;
    try {
      const response = await fetch(fetchUrl);
      return await response.json();
    } catch (err) {
      // TODO: 에러 핸들링
      console.error(err);
      return [];
    }
  };

  const loadCategoryListAndFirstCategoryProductList = async () => {
    const categoryListData = await fetchCategoryList();
    const firstCategoryIndex = 0;
    const { id: firstCategoryId, main: firstCategoryTitle } =
      categoryListData.content[firstCategoryIndex];
    const firstCategoryProductListData = await fetchFirstCategoryProductList(
      firstCategoryId
    );
    const firstCategoryProductList = {
      id: firstCategoryId,
      title: firstCategoryTitle,
      content: firstCategoryProductListData.content,
    };
    setCategoryList(categoryListData.content);
    setLoadedCategoryProductList([firstCategoryProductList]);
  };

  useEffect(() => {
    loadCategoryListAndFirstCategoryProductList();
  }, []);

  return (
    <>
      <Header categories={categoryList} />
      <Main
        categories={categoryList}
        loadedCategories={loadedCategoryProductList}
        setLoadedCategories={setLoadedCategoryProductList}
      />
    </>
  );
}

export default App;
