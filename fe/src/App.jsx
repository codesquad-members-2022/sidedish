import { Header } from './Header/Header';
import { Main } from './Main/Main';
import { useState, useEffect } from 'react';

function App() {
  const [categories, setCategories] = useState(null);
  const [loadedCategories, setLoadedCategories] = useState(null);

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
    if (!categories) return;
    const firstCategoryId = categories[0].id;
    const firstCategoryTitle = categories[0].main;
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
      {loadedCategories && (
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
