import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCards = ({
  cardClickState,
  setCardClickState,
  setCardInfoState,
  dataState,
  cardLength,
  cardMargin,
  cardContainerPadding,
}) => {
  const findMaxDiscount = (eventBadge) => {
    const eventDiscount = eventBadge.map((el) => el.discount);
    return eventDiscount.length ? Math.max(...eventDiscount) : 0;
  };

  const itemCardList = dataState.map(
    ({ mainImage, title, description, price, eventBadge, dishId }) => (
      <ItemCard
        cardClickState={cardClickState}
        setCardClickState={setCardClickState}
        setCardInfoState={setCardInfoState}
        key={dishId}
        dishId={dishId}
        image={mainImage}
        title={title}
        description={description}
        originPrice={eventBadge.length ? price : null}
        currentPrice={((100 - findMaxDiscount(eventBadge)) * price) / 100}
        badge={eventBadge.map((el) => el.eventName)}
        cardLength={cardLength}
        cardMargin={cardMargin}
      ></ItemCard>
    )
  );

  return (
    <ItemCardContainer cardContainerPadding={cardContainerPadding}>
      {itemCardList}
    </ItemCardContainer>
  );
};

const ItemCardContainer = styled.ul`
  display: flex;
  padding: 34px ${(props) => props.cardContainerPadding}px;
`;

export default ItemCards;
