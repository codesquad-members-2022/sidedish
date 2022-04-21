import React from "react";
import styled from "styled-components";

// TODO: style.js로 분리하기
const MealCardStyled = styled.li`
  display: flex;
  flex-direction: column;
  img {
    width: 200px;
    height: 200px;
  }
`;

function MealCard({ mealInfo }) {
  const { productName, description, event, fixedPrice, image, originalPrice } = mealInfo;
  return (
    <MealCardStyled>
      <img src={image || "default image url"} alt="food" />
      <h4>{productName}</h4>
      <p>{description}</p>
      <div>
        <span>{fixedPrice}</span>
        <span>{originalPrice}</span>
      </div>
      <div>{event}</div>
    </MealCardStyled>
  );
}
export default MealCard;
