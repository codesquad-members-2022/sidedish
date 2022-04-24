import styled, { ThemeProvider } from "styled-components";
import theme from "../styles/theme.js";
import Card from "./Card.js";
import { FlexMarginCenter } from "../styles/utils.js";

const CardConatiner = styled(FlexMarginCenter)`
  box-sizing: border-box;
  display: ${(props) => props.display};
  gap: 2.4rem;
  padding: 3.4rem 8rem 5.6rem;
  width: 144rem;
`;

const CardList = ({ cards, tabNumber, index, cardSize }) => {
  return (
    <ThemeProvider theme={theme}>
      <CardConatiner display={tabNumber === index ? "flex" : "none"}>
        {cards.map((card, index) => (
          <Card key={index} card={card} size={cardSize} />
        ))}
      </CardConatiner>
    </ThemeProvider>
  );
};

export default CardList;
