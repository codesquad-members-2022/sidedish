import styled from "styled-components";
import { useState, useEffect } from "react";
import { Reset } from "styled-reset";
import Header from "./Header.js";
import MainTab from "./MainTab.js";
import setData from "../store/store.js";

function App() {
  const [dishData, setDishData] = useState([]);

  useEffect(() => {
    (async () => {
      const result = await setData();
      setDishData([
        ...result.main.body,
        ...result.soup.body,
        ...result.side.body,
      ]);
    })();
  }, []);

  return (
    <>
      <Reset />
      <Header />
      <main>
        <MainTab dish={dishData} />
      </main>
    </>
  );
}

export default App;
