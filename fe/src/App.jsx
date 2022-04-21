import styled, { ThemeProvider } from 'styled-components';
import RecommendProduct from 'Main/Recommend/RecommendProduct';
import HeaderTemplate from 'Header/HeaderTemplate';
import DishContainer from 'Main/Dish/DishContainer';
import DishCategoryAllButton from 'Main/Dish/DishCategoryAllButton';
import GlobalStyles from 'GlobalStyles';
import theme from 'theme';

const Main = styled.main`
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyles />
        <HeaderTemplate></HeaderTemplate>
        <Main>
          <RecommendProduct></RecommendProduct>
          <DishContainer></DishContainer>
          <DishCategoryAllButton></DishCategoryAllButton>
        </Main>
      </ThemeProvider>
    </>
  );
}

export default App;
