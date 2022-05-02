import DetailModal from "components/DetailModal";
import ModalPortal from "components/Portal";
import React, { useState } from "react";
import { changeNumberToKoreanLocale, getMealImage, showOriginalPrice } from "utils";
import { Conatiner, CardInfo, DeliveryServiceHoverContainer, DiscoutType, PriceContainer, SpanDivider } from "./style";

const DeliveryOnHover = () => (
  <DeliveryServiceHoverContainer>
    <span>새벽배송</span>
    <SpanDivider />
    <span>전국택배</span>
  </DeliveryServiceHoverContainer>
);

const MealCard = ({ mealInfo, size }) => {
  const { id, productName, description, event: discountType, fixedPrice, image, originalPrice } = mealInfo;
  const [isOpendModal, setIsOpendModal] = useState(false);

  const openHandler = () => {
    setIsOpendModal(true);
  };

  const closeHandler = () => {
    setIsOpendModal(false);
  };

  return (
    <>
      <Conatiner imageSize={size}>
        <img id={id} src={getMealImage(image)} alt={productName} onClick={openHandler} />
        <CardInfo>
          <h3>{productName}</h3>
          <p>{description}</p>
          <PriceContainer>
            <span>{changeNumberToKoreanLocale(fixedPrice)}</span>
            <span>{showOriginalPrice(originalPrice, fixedPrice)}</span>
          </PriceContainer>
          {discountType && <DiscoutType discountType={discountType}>{discountType}</DiscoutType>}
          <DeliveryOnHover />
        </CardInfo>
      </Conatiner>
      {isOpendModal && (
        <ModalPortal closePortal={closeHandler}>
          <DetailModal detailId={id} />
        </ModalPortal>
      )}
    </>
  );
};

export default MealCard;
