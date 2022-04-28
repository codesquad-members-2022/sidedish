import { useState, useEffect } from "react";
import Header from "./Header.js";
import MainTab from "./MainTab.js";
import Modal from "./Modal/Modal.js";
import MainCategories from "./MainCategories.js";
import { ModalContext } from "../contexts/ModalContext.js";

const fetchDishData = (type) => {
  return fetch(`https://api.codesquad.kr/onban/${type}`)
    .then((res) => res.json())
    .then((data) => data);
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
