import {
  useCategories,
  useFetch,
  useFetch1,
  useSpecialCategories,
} from "./fetcher";
import { Header } from "./components/Header";
import { SpecialCategory } from "./components/SpecialCategory";
import { Category } from "./components/Category";
import styled from "styled-components";
import { Modal } from "./components/Modal";
import { ModalContext } from "./ModalReducer";
import { useContext } from "react";
import { Queries } from "./convention";

const AppWrapper = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const App = () => {
  const { categories } = useFetch(Queries.categories) || {};
  const { specialCategories } = useFetch(Queries.specialCategories) || {};

  const { openedId, setOpenedId } = useContext(ModalContext);

  return (
    <>
      {categories && specialCategories && (
        <AppWrapper>
          <Header categories={categories}></Header>
          <SpecialCategory
            specialCategories={specialCategories}
          ></SpecialCategory>
          <Category categories={categories}></Category>
          {openedId >= 0 && <Modal openId={openedId} />}
        </AppWrapper>
      )}
    </>
  );
};

export default App;
