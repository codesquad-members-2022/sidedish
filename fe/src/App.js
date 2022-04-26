import styled, { ThemeProvider } from "styled-components";
import theme from "../src/style/theme.js";
import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";
import SubTitle from "./component/SubTitle/SubTitle";
import Slides from "./component/bottom/Slides";
import GlobalStyle from "./style/globalStyle";

const Container = styled.div`
  width: 1440px;
  margin: 0 auto;
`;
function App() {
  return (
    <>
      <GlobalStyle />
      <ThemeProvider theme={theme}>
        <Container>
          <Header />
          <SubTitle />
          <Tab />
          <Slides />
        </Container>
      </ThemeProvider>
    </>
  );
}

export default App;
