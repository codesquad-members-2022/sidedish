import "./App.css";
import styled, { ThemeProvider } from "styled-components";
import theme from "../src/style/theme.js";
import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";
import SubTitle from "./component/SubTitle/SubTitle";
import Slide from "./component/bottom/Slide";
import GlobalStyle from "./style/globalStyle";
function App() {
  return (
    <>
      <GlobalStyle />
      <ThemeProvider theme={theme}>
        <div className="app">
          <Header />
          <SubTitle />
          <Tab />
          <Slide />
        </div>
      </ThemeProvider>
    </>
  );
}

export default App;
