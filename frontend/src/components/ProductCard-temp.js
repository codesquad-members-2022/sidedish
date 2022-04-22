import styled, { css } from "styled-components";
import { DiscountTag } from "./DiscountTag";
import { useState } from "react";
import { SIZES, thumbnailSize } from "../convention";

const CardWrapper = styled.div`
  ${(props) =>
    css`
      width: ${thumbnailSize[props.size]}px;
    `}
`;

const CardImage = styled.div`
  ${(props) => css`
    width: ${thumbnailSize[props.size]}px;
    height: ${thumbnailSize[props.size]}px;
    background: url(${props.src});
    background-size: cover;
  `}
`;

const CardInfo = styled.div`
  margin-top: 16px;
`;

const CardName = styled.div`
  ${(props) =>
    props.size === SIZES.small
      ? `font-weight: 500;
            line-height: 26px;
        `
      : `font-weight: 400;
            line-height: 24px;
        `}
`;

const CardDescription = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  margin-top: 8px;
  color: #777777;
`;

const CardPriceWrapper = styled.div`
  margin-top: 8px;
`;

const CardFinalPrice = styled.span`
  font-weight: 500;
  line-height: 26px;
  margin-right: 8px;
`;

const CardPrice = styled.span`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  text-decoration-line: line-through;
  color: #bcbcbc;
`;

export const ProductCard = ({ size, productData }) => {
  const [hover, setHover] = useState(false);
  return (
    <CardWrapper>
      <CardImage size={size} src={productData.primary_image}></CardImage>
      <CardInfo>
        <CardName size={size}>{productData.name}</CardName>
        {size !== SIZES.small && (
          <CardDescription>{productData.description}</CardDescription>
        )}
        <CardPriceWrapper>
          <CardFinalPrice>{productData.final_price + "원"}</CardFinalPrice>
          <CardPrice>${productData.price + "원" || ""}</CardPrice>
        </CardPriceWrapper>
      </CardInfo>
      <DiscountTag discount={productData.discount} />
    </CardWrapper>
  );
};
