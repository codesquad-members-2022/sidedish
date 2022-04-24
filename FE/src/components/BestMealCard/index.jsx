import React from "react";
import styled from "styled-components";
import { setDefaultMealImage } from "util";

const BestMealCardStyled = styled.div`
  display: flex;
  flex-direction: column;
`;

const CardImage = styled.img`
  width: 200;
  height: 200px;
`;

function BestMealCard({ meal }) {
  const { image, productName, description, fixedPrice, originalPrice, event } = meal;
  return (
    <BestMealCardStyled>
      <CardImage src={setDefaultMealImage(image)} alt={productName} />
      <h3>{productName}</h3>
      <span>{description}</span>
      <div>
        <span>{originalPrice}</span>
        {originalPrice === fixedPrice ? null : <span>{fixedPrice}</span>}
      </div>
      <div>{event}</div>
    </BestMealCardStyled>
  );
}

export default BestMealCard;
