import styled from "styled-components";
import Card from "./Card.js";
import { FlexMarginCenter } from "../styles/utils.js";

const CardList = ({
  innerRef,
  cards,
  tabNumber = 0,
  index = 0,
  cardSize,
  gap,
}) => {
  return (
    <CardConatiner
      ref={innerRef}
      display={tabNumber === index ? "flex" : "none"}
      gap={gap}
    >
      {cards.map((card, index) => (
        <Card key={index} card={card} size={cardSize} />
      ))}
    </CardConatiner>
  );
};

const CardConatiner = styled(FlexMarginCenter)`
  box-sizing: border-box;
  display: ${(props) => props.display};
  gap: ${(props) => props.gap};
  padding: 3.4rem 0 5.6rem;
`;

export default CardList;
