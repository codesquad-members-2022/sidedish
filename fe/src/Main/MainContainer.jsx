import styled from 'styled-components';
import RecommendProduct from 'Main/Recommend/RecommendProduct';
import DishContainer from 'Main/Dish/DishContainer';
import DishCategoryAllButton from 'Main/Dish/DishCategoryAllButton';

const Main = styled.main`
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

const MainContainer = () => {
  return (
    <Main>
      <RecommendProduct />
      <DishContainer />
      <DishCategoryAllButton />
    </Main>
  );
};

export default MainContainer;
