import { Header } from './Header/Header';
import { Main } from './Main/Main';
import { useState, useEffect } from 'react';

function App() {
  const [categories, setCategories] = useState(null);
  const [loadedCategories, setLoadedCategories] = useState({});

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
    fetch(`/category/${firstCategoryId}`)
      .then(response => response.json())
      .then(
        data => {
          const obj = {};
          obj[firstCategoryId] = data.content;
          setLoadedCategories(obj);
        },
        err => {
          console.log(err);
        }
      );
  }, [categories]);

  return (
    <>
      {categories && <Header categories={categories} />}
      {/*<Main*/}
      {/*  loadedCategories={loadedCategories}*/}
      {/*  setLoadedCategories={setLoadedCategories}*/}
      {/*/>*/}
    </>
  );
}

export default App;
