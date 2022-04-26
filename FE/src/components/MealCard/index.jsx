import { DISCOUNT_TYPE } from "constants";
import React from "react";
import { getMealImage } from "utils";
import { Card, CardInfo, DeliveryServiceHoverContainer, DiscoutType, PriceContainer, SpanDivider } from "./style";

const MealCard = ({ mealInfo, size }) => {
  const { productName, description, event: discountType, fixedPrice, image, originalPrice } = mealInfo;
  return (
    <Card imageSize={size}>
      <img src={getMealImage(image)} alt={productName} />
      <CardInfo>
        <h4>{productName}</h4>
        <p>{description}</p>
        <PriceContainer>
          <span>{fixedPrice}</span>
          <span>{originalPrice}</span>
        </PriceContainer>
        {discountType && (
          <DiscoutType isLaunchingDiscount={discountType === DISCOUNT_TYPE.launching}>{discountType}</DiscoutType>
        )}
      </CardInfo>
      <DeliveryServiceHoverContainer>
        <span>새벽배송</span>
        <SpanDivider />
        <span>전국택배</span>
      </DeliveryServiceHoverContainer>
    </Card>
  );
};
export default MealCard;
