import React from "react";
import { getMealImage } from "utils";
import { Conatiner, CardInfo, DeliveryServiceHoverContainer, DiscoutType, PriceContainer, SpanDivider } from "./style";

const changeNumberToKoreanLocale = (number) => `${number.toLocaleString("ko-KR")}원`;

const showOriginalPrice = (originalPrice, fixedPrice) =>
  originalPrice === fixedPrice ? <></> : <span>{changeNumberToKoreanLocale(fixedPrice)}</span>;

const DeliveryOnHover = () => (
  <DeliveryServiceHoverContainer>
    <span>새벽배송</span>
    <SpanDivider />
    <span>전국택배</span>
  </DeliveryServiceHoverContainer>
);

const MealCard = ({ mealInfo, size }) => {
  const { productName, description, event: discountType, fixedPrice, image, originalPrice } = mealInfo;
  return (
    <Conatiner imageSize={size}>
      <img src={getMealImage(image)} alt={productName} />
      <CardInfo>
        <h3>{productName}</h3>
        <p>{description}</p>
        <PriceContainer>
          <span>{changeNumberToKoreanLocale(fixedPrice)}</span>
          <span>{showOriginalPrice(originalPrice, fixedPrice)}</span>
        </PriceContainer>
        {discountType && <DiscoutType discountType={discountType}>{discountType}</DiscoutType>}
      </CardInfo>
      <DeliveryOnHover />
    </Conatiner>
  );
};

export default MealCard;
