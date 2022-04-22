import styled from "styled-components";
import ItemCard from "./ItemCard";

const ItemCards = ({ dataState, len }) => {
  const itemCardList = dataState.map(({ image, title, description, n_price, s_price, badge }, ind) => (
    <ItemCard key={ind} image={image} title={title} description={description} n_price={n_price} s_price={s_price} badge={badge} len={len}></ItemCard>
  ));

  return <ItemCardContainer>{itemCardList}</ItemCardContainer>;
};

const ItemCardContainer = styled.ul`
  display: flex;
  padding: 34px 56px;
`;

export default ItemCards;
