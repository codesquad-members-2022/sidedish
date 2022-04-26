import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCards = ({ cardClickState, setCardClickState, dataState, cardLength, cardMargin, cardContainerPadding }) => {
  const itemCardList = dataState.map(({ image, title, description, n_price, s_price, badge }, ind) => (
    <ItemCard
      cardClickState={cardClickState}
      setCardClickState={setCardClickState}
      key={ind}
      image={image}
      title={title}
      description={description}
      n_price={n_price}
      s_price={s_price}
      badge={badge}
      cardLength={cardLength}
      cardMargin={cardMargin}
    ></ItemCard>
  ));

  return <ItemCardContainer cardContainerPadding={cardContainerPadding}>{itemCardList}</ItemCardContainer>;
};

const ItemCardContainer = styled.ul`
  display: flex;
  padding: 34px ${(props) => props.cardContainerPadding}px;
`;

export default ItemCards;
