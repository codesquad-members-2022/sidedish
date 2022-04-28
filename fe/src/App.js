import styled, { ThemeProvider } from "styled-components";
import theme from "../src/style/theme.js";
import Header from "./component/Header/Header";
import Tab from "./component/Tab/Tab";
import SubTitle from "./component/SubTitle/SubTitle";
import Slides from "./component/bottom/Slides";
import GlobalStyle from "./style/globalStyle";
import React, { useState, useEffect } from "react";
import Modal from "./component/modal/Modal.js";
import { ModalContext } from "./store/store.js";

const Container = styled.div`
  width: 1440px;
  margin: 0 auto;
`;
function App() {
  const [modalisDisplayed, setModalIsDisplayed] = useState(false);
  const [clickedId, setClickedId] = useState(1);

  return (
    <>
      <GlobalStyle />
      <ThemeProvider theme={theme}>
        <ModalContext.Provider
          value={{
            isDisplayed: modalisDisplayed,
            clickedId: clickedId,
            setClickedId: setClickedId,
            setModalIsDisplayed: setModalIsDisplayed,
          }}
        >
          <Container>
            <Header />
            <SubTitle />
            <Tab />
            <Slides />
            <Modal />
          </Container>
        </ModalContext.Provider>
      </ThemeProvider>
    </>
  );
}

export default App;
