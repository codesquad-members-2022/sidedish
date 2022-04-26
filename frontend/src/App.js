import { useCategories, useFetch1, useSpecialCategories } from "./fetcher";
import { Header } from "./components/Header";
import { SpecialCategory } from "./components/SpecialCategory";
import { Category } from "./components/Category";
import styled from "styled-components";
import { Modal } from "./components/Modal";
import { ModalContext } from "./ModalReducer";
import { useContext } from "react";

const AppWrapper = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const App = () => {
  const cats = useCategories();
  const specialCategories = useSpecialCategories();
  const { openedId, setOpenedId } = useContext(ModalContext);

  return (
    <>
      {cats && specialCategories && (
        <AppWrapper isOpen={openedId >= 0} onClick={() => setOpenedId(-1)}>
          <Header cats={cats}></Header>
          <SpecialCategory
            specialCategories={specialCategories}
          ></SpecialCategory>
          <Category cats={cats}></Category>
          {openedId >= 0 && <Modal openId={openedId} />}
        </AppWrapper>
      )}
    </>
  );
};

export default App;
