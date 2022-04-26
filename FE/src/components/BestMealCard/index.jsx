import React from "react";
import { getMealImage } from "utils";
import { CardContent, CardImage, Container, EventBadge, PriceContainer } from "./style";

function BestMealCard({ meal }) {
  const { image, productName, description, fixedPrice, originalPrice, event } = meal;

  return (
    <Container>
      <CardImage src={getMealImage(image)} alt={productName} />
      <CardContent>
        <h3>{productName}</h3>
        <span>{description}</span>
        <PriceContainer>
          <span>{originalPrice.toLocaleString("ko-KR")}원</span>
          {originalPrice === fixedPrice ? <></> : <span>{fixedPrice.toLocaleString("ko-KR")}원</span>}
        </PriceContainer>
        <EventBadge event={event}>{event}</EventBadge>
      </CardContent>
    </Container>
  );
}

export default BestMealCard;
