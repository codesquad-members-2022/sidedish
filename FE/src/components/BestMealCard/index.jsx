import React from "react";
import styled from "styled-components";
import { getMealImage } from "utils";

const Container = styled.div`
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
    <Container>
      <CardImage src={getMealImage(image)} alt={productName} />
      <h3>{productName}</h3>
      <span>{description}</span>
      <div>
        <span>{originalPrice}</span>
        {originalPrice === fixedPrice ? <></> : <span>{fixedPrice}</span>}
      </div>
      <div>{event}</div>
    </Container>
  );
}

export default BestMealCard;
