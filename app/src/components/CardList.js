import { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";
import Card from "./Card.js";

const CardConatiner = styled.div`
  display: flex;
`;

const CardList = (props) => {
  return (
    <ThemeProvider theme={theme}>
      <CardConatiner>
        <Card />
      </CardConatiner>
    </ThemeProvider>
  );
};

export default CardList;
