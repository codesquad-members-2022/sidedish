import React from "react";
import styled from "styled-components";
import { getMealImage } from "utils";

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
      <img src={getMealImage(image)} alt={productName} />
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
