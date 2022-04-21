import { useState } from "react";
import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";
import Card from "./Card.js";
import { FlexMarginCenter } from "../styles/utils.js";

const CardConatiner = styled(FlexMarginCenter)`
  width: 144rem;
  display: ${(props) => props.display};
  gap: 2.4rem;
  padding-top: 3.4rem;
  padding-bottom: 5.6rem;
`;

const CardList = ({ tabCards, tabNumber, index }) => {
  return (
    <ThemeProvider theme={theme}>
      <CardConatiner display={tabNumber === index ? "flex" : "none"}>
        {tabCards.map((card) => (
          <Card card={card} />
        ))}
      </CardConatiner>
    </ThemeProvider>
  );
};

export default CardList;
