import { GlobalStyle } from "./styles/global";
import { Header } from "./components/Header";
import { BestProduct } from "./components/BestProduct";
import { CardList } from "./components/CardList";
import { useEffect, useState } from "react";
import { SIZES } from "./convention";
import React from "react";
import { useCategories, useSpecialCategories } from "./fetcher";
import { Category } from "./components/Category";

const App = () => {
  const [extended, setExtended] = useState(false);
  const cats = useCategories(extended);
  const themes = useSpecialCategories(extended);
  return (
    <>
      {cats && themes && (
        <>
          <Header cats={cats}></Header>
          <BestProduct themes={themes}></BestProduct>
          <Category cats={cats}></Category>
        </>
      )}
    </>
  );
};

export default App;
