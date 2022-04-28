import styled from "styled-components";
import { useContext } from "react";
import { ModalContext } from "./ModalReducer";
import { Queries } from "./convention";
import { useFetch } from "./fetcher";
import { Header } from "./components/Header";
import { SpecialCategory } from "./components/SpecialCategory";
import { Category } from "./components/Category";
import { Modal } from "./components/Modal";

const AppWrapper = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const App = () => {
  const { categories } = useFetch(Queries.categories);
  const { themes } = useFetch(Queries.specialCategories);
  //이름 specialCategories로 바뀌어야하는데 백엔드에 아직 반영이 안됨.
  const { openedId } = useContext(ModalContext);

  return (
    <>
      {categories && themes && (
        <AppWrapper>
          <Header categories={categories} />
          <SpecialCategory specialCategories={themes} />
          <Category categories={categories} />
          {openedId >= 0 && <Modal openId={openedId} />}
        </AppWrapper>
      )}
    </>
  );
};

export default App;
