import { ThemeProvider } from 'styled-components';
import RecommendProduct from './Main/Recommend/RecommendProduct.jsx';
import HeaderTemplate from './Header/HeaderTemplate';
import GlobalStyles from './GlobalStyles.jsx';
import theme from './theme';

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyles />
        <HeaderTemplate></HeaderTemplate>
        <RecommendProduct></RecommendProduct>
      </ThemeProvider>
    </>
  );
}

export default App;
