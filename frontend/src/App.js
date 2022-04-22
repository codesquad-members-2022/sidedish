import { GlobalStyle } from "./styles/global";
import { Header } from "./components/Header";
import { BestProduct } from "./components/BestProduct";
import { Category } from "./components/Category";
import { useEffect, useState } from "react";
import { SIZES } from "./convention";
import React from "react";
import { useCategories, useThemes } from "./fetcher";

const App = () => {
  const [extended, setExtended] = useState(false);
  const cats = useCategories(extended);
  const themes = useThemes(extended);

  return (
    <>
      {cats && (
        <>
          <Header cats={cats}></Header>
          <BestProduct themes={themes}></BestProduct>
        </>
      )}
    </>
  );
};

export default App;
