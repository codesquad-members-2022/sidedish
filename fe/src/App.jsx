import { useState, useEffect } from 'react';

import { Header } from '@Header';
import { Main } from '@Main';

function App() {
  const [categories, setCategories] = useState([]);
  const [loadedCategories, setLoadedCategories] = useState([]);

  useEffect(() => {
    fetch('/categories')
      .then(response => response.json())
      .then(
        data => {
          setCategories(data.content);
        },
        err => console.log(err)
      );
  }, []);

  useEffect(() => {
    if (!categories.length) return;
    const firstCategoryIndex = 0;
    const firstCategoryId = categories[firstCategoryIndex].id;
    const firstCategoryTitle = categories[firstCategoryIndex].main;
    fetch(`/category/${firstCategoryId}`)
      .then(response => response.json())
      .then(
        data => {
          const obj = {
            id: firstCategoryId,
            title: firstCategoryTitle,
            content: data.content,
          };
          setLoadedCategories([obj]);
        },
        err => {
          console.log(err);
        }
      );
  }, [categories]);

  return (
    <>
      {categories && <Header categories={categories} />}
      {loadedCategories.length && (
        <Main
          categories={categories}
          loadedCategories={loadedCategories}
          setLoadedCategories={setLoadedCategories}
        />
      )}
    </>
  );
}

export default App;
