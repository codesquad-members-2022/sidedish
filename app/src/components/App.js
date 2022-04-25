import styled from "styled-components";
import { useState, useEffect } from "react";
import { Reset } from "styled-reset";
import Header from "./Header.js";
import MainTab from "./MainTab.js";
import Modal from "./Modal.js";
import setData from "../store/store.js";
import Category from "./Category.js";
import { ModalContext } from "../contexts/ModalContext.js";

function App() {
  const [dishData, setDishData] = useState([]);
  const [mainDish, setMainDish] = useState([]);
  const [sideDish, setSideDish] = useState([]);
  const [soupDish, setSoupDish] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [dishHash, setDishHash] = useState("");

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

  const hideModal = () => {
    setShowModal(!showModal);
  };

  return (
    <>
      <Reset />
      <Header />
      <main>
        <ModalContext.Provider value={{ showModal, setShowModal, setDishHash }}>
          <MainTab dish={dishData} />
          {showModal && <Modal hideModal={hideModal} dishHash={dishHash} />}
          {/* <Category dish={sideDish} category={"side"} />
        <Category dish={soupDish} category={"soup"} />
        <Category dish={mainDish} category={"main"} /> */}
        </ModalContext.Provider>
      </main>
    </>
  );
}

export default App;
