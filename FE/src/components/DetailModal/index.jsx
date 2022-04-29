import Loader from "components/Loader";
import { CardInfo, DiscoutType, PriceContainer } from "components/MealCard/style";
import { useAxios } from "hooks/useAxios";
import React from "react";
import { changeNumberToKoreanLocale, getMealImage, showOriginalPrice } from "utils";
import { DetailImg } from "./style";

const DetailModal = ({ detailId }) => {
  const { response: detailData } = useAxios({
    method: "get",
    url: `/products/${detailId}`,
  });

  if (!detailData) {
    return <Loader />;
  }

  const {
    id,
    productName,
    images,
    description,
    fixedPrice,
    originalPrice,
    deliveryCharge,
    deliveryInfo,
    event: discountType,
    freeDeliveryOverAmount,
    mileage,
  } = detailData;

  console.log(detailData);
  return (
    <div>
      {/* FIXME index: 0 매직넘버 */}
      <DetailImg src={getMealImage(images[0].imageUrl)} alt={productName} />
      <CardInfo>
        <h3>{productName}</h3>
        <p>{description}</p>
        <PriceContainer>
          <span>{changeNumberToKoreanLocale(+fixedPrice)}</span>
          <span>{showOriginalPrice(originalPrice, fixedPrice)}</span>
        </PriceContainer>
        {discountType && <DiscoutType discountType={discountType}>{discountType}</DiscoutType>}
        <span>{deliveryInfo}</span>
        <span>{deliveryCharge}</span>
        <span>{freeDeliveryOverAmount}</span>
        <span>{mileage}</span>
      </CardInfo>
    </div>
  );
};

export default DetailModal;
