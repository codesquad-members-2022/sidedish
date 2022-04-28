import styled from 'styled-components';
import RecommendProduct from 'Main/Recommend/RecommendProduct';
import DishContainer from 'Main/Dish/DishContainer';
import DishCategoryAllButton from 'Main/Dish/DishCategoryAllButton';
import { SERVER_URL } from 'constant.js';
import { useFetch } from 'useFetch';
import Loading from 'common/Loading';
import ErrorComponent from 'common/Error';

const Main = styled.main`
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

const MainContainer = () => {
  const [dishes, isLoading, isError] = useFetch(`${SERVER_URL}categories/1/`);

  if (isError) {
    return <ErrorComponent />;
  }

  if (isLoading) {
    return <Loading />;
  }

  return (
    <Main>
      <RecommendProduct />
      {!isLoading && Object.keys(dishes).length !== 0 && (
        <DishContainer items={dishes}></DishContainer>
      )}
      <DishCategoryAllButton />
    </Main>
  );
};

export default MainContainer;
