import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCards = ({ cardClickState, setCardClickState, dataState, cardLength, cardMargin, cardContainerPadding }) => {
  const itemCardList = dataState.map(({ mainImage, title, description, price, eventBadge, dishId }) => (
    <ItemCard
      cardClickState={cardClickState}
      setCardClickState={setCardClickState}
      key={dishId}
      image={mainImage}
      title={title}
      description={description}
      n_price={price}
      s_price={((100 - eventBadge[0].discount) * price) / 100}
      badge={eventBadge[0].eventName}
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
