import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCards = ({ cardClickState, setCardClickState, dataState, len }) => {
  const handleCardClick = () => {
    setCardClickState(!cardClickState);
  };
  const itemCardList = dataState.map(({ image, title, description, n_price, s_price, badge }, ind) => (
    <ItemCard key={ind} image={image} title={title} description={description} n_price={n_price} s_price={s_price} badge={badge} len={len}></ItemCard>
  ));

  return <ItemCardContainer onClick={handleCardClick}>{itemCardList}</ItemCardContainer>;
};

const ItemCardContainer = styled.ul`
  display: flex;
  padding: 34px 56px;
`;

export default ItemCards;
