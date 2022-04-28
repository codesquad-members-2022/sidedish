import { ThemeProvider } from 'styled-components';
import MainContainer from 'Main/MainContainer';
import HeaderTemplate from 'Header/HeaderTemplate';
import GlobalStyles from 'GlobalStyles';
import theme from 'theme';

function App() {
  return (
    <>
      <ThemeProvider theme={theme}>
        <GlobalStyles />
        <HeaderTemplate></HeaderTemplate>
        <MainContainer></MainContainer>
      </ThemeProvider>
    </>
  );
}

export default App;
