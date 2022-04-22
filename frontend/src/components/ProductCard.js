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

const ProductImage = styled.div`
  ${(props) => css`
    width: ${thumbnailSize[props.size]}px;
    height: ${thumbnailSize[props.size]}px;
    background: url(${props.src});
    background-size: cover;
  `}
`;

const ProductInfo = styled.div`
  margin-top: 16px;
`;

const ProductName = styled.div`
  ${(props) =>
    props.size === SIZES.small
      ? `font-weight: 500;
            line-height: 26px;
        `
      : `font-weight: 400;
            line-height: 24px;
        `}
`;

const ProductDescription = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  margin-top: 8px;
  color: #777777;
`;

const ProductPriceWrapper = styled.div`
  margin-top: 8px;
`;

const ProductFinalPrice = styled.span`
  font-weight: 500;
  line-height: 26px;
  margin-right: 8px;
`;

const ProductPrice = styled.span`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  text-decoration-line: line-through;
  color: #bcbcbc;
`;

export const ProductCard = ({
  size,
  primary_image,
  name,
  description,
  discount,
  final_price,
  price,
}) => {
  const [hover, setHover] = useState(false);

  return (
    <CardWrapper>
      <ProductImage size={size} src={primary_image}></ProductImage>
      <ProductInfo>
        <ProductName size={size}>{name}</ProductName>
        {size !== SIZES.small && (
          <ProductDescription>{description}</ProductDescription>
        )}
        <ProductPriceWrapper>
          <ProductFinalPrice>{final_price + "원"}</ProductFinalPrice>
          <ProductPrice>{price + "원" || ""}</ProductPrice>
        </ProductPriceWrapper>
      </ProductInfo>
      <DiscountTag discount={discount} />
    </CardWrapper>
  );
};
