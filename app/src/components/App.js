import { ThemeProvider } from "styled-components";
import { useState, useEffect } from "react";
import { Reset } from "styled-reset";
import theme from "../styles/theme.js";
import Header from "./Header.js";
import MainTab from "./MainTab.js";
import Modal from "./Modal/Modal.js";
import setData from "../store/store.js";
import MainCategories from "./MainCategories.js";
import { ModalContext } from "../contexts/ModalContext.js";

function App() {
  const [dishData, setDishData] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [productHash, setProductHash] = useState("");

  useEffect(() => {
    (async () => {
      const result = await setData();
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
      <Reset />
      <ThemeProvider theme={theme}>
        <Header />
        <main>
          <ModalContext.Provider
            value={{ showModal, setShowModal, setProductHash }}
          >
            <MainTab dish={getAllDish()} />
            {showModal && (
              <Modal
                showModalPopup={showModalPopup}
                productHash={productHash}
              />
            )}
            <MainCategories data={dishData} />
          </ModalContext.Provider>
        </main>
      </ThemeProvider>
    </>
  );
}

export default App;
