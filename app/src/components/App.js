import styled from "styled-components";
import { useState, useEffect } from "react";
import { Reset } from "styled-reset";
import Header from "./Header.js";
import MainTab from "./MainTab.js";
import Modal from "./Modal.js";
import setData from "../store/store.js";
import Category from "./Category.js";

function App() {
  const [dishData, setDishData] = useState([]);
  const [mainDish, setMainDish] = useState([]);
  const [sideDish, setSideDish] = useState([]);
  const [soupDish, setSoupDish] = useState([]);

  useEffect(() => {
    (async () => {
      const result = await setData();
      setDishData([
        ...result.main.body,
        ...result.soup.body,
        ...result.side.body,
      ]);
      setMainDish([...result.main.body]);
      setSideDish([...result.side.body]);
      setSoupDish([...result.soup.body]);
    })();
  }, []);

  return (
    <>
      <Reset />
      <Header />
      <main>
        <MainTab dish={dishData} />
        <Modal />
        <Category dish={sideDish} category={"side"} />
        <Category dish={soupDish} category={"soup"} />
        <Category dish={mainDish} category={"main"} />
      </main>
    </>
  );
}

export default App;
