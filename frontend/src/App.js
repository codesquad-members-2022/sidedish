import { GlobalStyle } from "./styles/global";
import { Header } from "./components/Header";
import { BestProduct } from "./components/BestProduct";
import { Category } from "./components/Category";
import { useEffect, useState } from "react";
import { SIZES } from "./convention";
import React from "react";
import { useCategories, useThemes } from "./fetcher";

const App = () => {
  const cats = useCategories();
  const themes = useThemes();
  const [extended, setExtended] = useState(false);
  console.log(cats);
  return (
    <>
      {cats && (
        <>
          <Header cats={cats}></Header>
          <BestProduct themes={themes}></BestProduct>
          <Category size={SIZES.medium} {...cats[0]}></Category>
        </>
      )}
    </>
  );
};

export default App;
