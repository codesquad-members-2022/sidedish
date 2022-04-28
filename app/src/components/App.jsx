import { useState, useEffect } from "react";
import Header from "./Header.jsx";
import MainTab from "./MainTab.jsx";
import Modal from "./Modal/Modal.jsx";
import MainCategories from "./MainCategories.jsx";
import { ModalContext } from "../contexts/ModalContext.js";

const fetchDishData = async (type) => {
  const res = await fetch(`https://api.codesquad.kr/onban/${type}`);
  const data = res.json();
  return data;
};

const fetchAllDishData = async () => {
  const data = {};

  data.main = await fetchDishData("main");
  data.soup = await fetchDishData("soup");
  data.side = await fetchDishData("side");

  return data;
};

function App() {
  const [dishData, setDishData] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [productHash, setProductHash] = useState("");

  useEffect(() => {
    (async () => {
      const result = await fetchAllDishData();
      setDishData([
        { key: "MAIN", data: result.main.body },
        { key: "SOUP", data: result.soup.body },
        { key: "SIDE", data: result.side.body },
      ]);
    })();
  }, []);

  const showModalPopup = () => {
    setShowModal(!showModal);
  };

  const getAllDish = () => {
    return dishData.reduce((prev, category) => {
      return [...prev, ...category.data];
    }, []);
  };

  return (
    <>
      <Header />
      <main>
        <ModalContext.Provider
          value={{ showModal, setShowModal, setProductHash }}
        >
          <MainTab dish={getAllDish()} />
          {showModal && (
            <Modal showModalPopup={showModalPopup} productHash={productHash} />
          )}
          <MainCategories data={dishData} />
        </ModalContext.Provider>
      </main>
    </>
  );
}

export default App;
