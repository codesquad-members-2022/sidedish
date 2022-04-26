import { useCategories, useSpecialCategories } from "./fetcher";
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
  background: ${({ isOpen, theme }) => (isOpen ? theme.colors.Grey2 : "")}
  opacity: ${({ isOpen }) => (isOpen ? 0.5 : 1)}
`;

const App = () => {
  const cats = useCategories();
  const specialCategories = useSpecialCategories();
  const { openId, dispatch } = useContext(ModalContext);
  return (
    <>
      {cats && specialCategories && (
        <AppWrapper
          isOpen={openId >= 0}
          onClick={() => dispatch({ type: "close", openId: -1 })}
        >
          <Header cats={cats}></Header>
          <SpecialCategory
            specialCategories={specialCategories}
          ></SpecialCategory>
          <Category cats={cats}></Category>
          <Modal id={openId} />
        </AppWrapper>
      )}
    </>
  );
};

export default App;
