import { useCategories, useSpecialCategories } from "./fetcher";
import { Header } from "./components/Header";
import { SpecialCategory } from "./components/SpecialCategory";
import { Category } from "./components/Category";
import styled from "styled-components";

const AppWrapper = styled.div`
  width: 100vw;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const App = () => {
  const cats = useCategories();
  const specialCategories = useSpecialCategories();
  return (
    <>
      {cats && specialCategories && (
        <AppWrapper>
          <Header cats={cats}></Header>
          <SpecialCategory specialCategories={specialCategories}></SpecialCategory>
          <Category cats={cats}></Category>
        </AppWrapper>
      )}
    </>
  );
};

export default App;
