import styled, { css } from "styled-components";
import { DiscountTag } from "./DiscountTag";
import { useContext, useState } from "react";
import { SIZES, thumbnailSize, cardGapLength } from "../convention";
import { ModalContext } from "../ModalReducer";
import {
  custom_absolute,
  custom_flex,
  custom_font,
  width_height_bypx,
} from "../styles/global";
import { HorizontalLine } from "./HorizontalLine";

const CardWrapper = styled.div`
  margin-right: ${({ size }) => `${cardGapLength[size]}px`};
`;

const ProductImage = styled.div`
  width: 100%;
  height: 100%;
  ${({ src, hover }) => css`
    background: url(${src});
    background-size: cover;
    ${hover &&
    `
      background-color: rgba(0, 0, 0, 0.1);
      background-blend-mode: multiply;
    `}
  `}
`;

const ProductInfo = styled.div`
  margin: ${({ size }) => (size === SIZES.small ? "8px" : "16px")} 0px;
`;

const ProductName = styled.div`
  ${({ size }) =>
    size === SIZES.small
      ? `${custom_font("Noto Sans KR", 14, 400, 24, -0.008)}`
      : `${custom_font("Noto Sans KR", 16, 500, 26, -0.008)}`}
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

const ThumbnailWrapper = styled.div`
  position: relative;
  ${(props) => css`
    width: ${thumbnailSize[props.size]}px;
    height: ${thumbnailSize[props.size]}px;
  `}
`;
const HoverInfoWrapper = styled.div`
  ${custom_absolute(20, 20)}
  ${width_height_bypx(142, 149)}
  ${custom_flex("column", "center", "center")}
  border: 1px solid ${({ theme }) => theme.colors.Black};
  background-color: ${({ theme }) => theme.colors.Grey4};
  border-radius: 999px;
  opacity: 0.8;
`;
const HoverInfoTextWrapper = styled.div`
  position: relative;

  ${custom_flex("column", "center", "center")}
  ${custom_font("Noto Sans KR", 16, 500, 26)}
  span {
    margin: 8px;
  }
`;

const HoverInfo = ({ earlyMorningDelivery, nationwideDelivery }) => (
  <HoverInfoWrapper>
    <HoverInfoTextWrapper>
      {earlyMorningDelivery && <span>새벽 배송</span>}
      {earlyMorningDelivery && nationwideDelivery && <HorizontalLine position={50} color={"Black"} />}
      {nationwideDelivery && <span>전국 택배</span>}
    </HoverInfoTextWrapper>
  </HoverInfoWrapper>
);

export const ProductCard = ({
  cardSize,
  id,
  primaryImage,
  name,
  description,
  discounts,
  finalPrice,
  basePrice,
  earlyMorningDelivery,
  nationwideDelivery
}) => {
  const [hover, setHover] = useState(false);
  const { setOpenedId } = useContext(ModalContext);
  return (
    <CardWrapper size={cardSize}>
      <ThumbnailWrapper
        size={cardSize}
        onMouseEnter={() => setHover(true)}
        onMouseLeave={() => setHover(false)}
        onClick={(e) => setOpenedId(id)}
      >
        <ProductImage hover={hover} src={primaryImage} />
        {hover && cardSize !== SIZES.small && (
          <HoverInfo earlyMorningDelivery={earlyMorningDelivery} nationwideDelivery={nationwideDelivery} />
        )}
      </ThumbnailWrapper>

      <ProductInfo size={cardSize}>
        <ProductName
          size={cardSize}
          onClick={(e) => {
            e.stopPropagation();
            setOpenedId(id);
          }}
        >
          {name}
        </ProductName>
        {cardSize !== SIZES.small && <ProductDescription>{description}</ProductDescription>}
        <ProductPriceWrapper>
          <ProductFinalPrice>{finalPrice.toLocaleString() + "원"}</ProductFinalPrice>
          <ProductPrice>{basePrice.toLocaleString() + "원" || ""}</ProductPrice>
        </ProductPriceWrapper>
      </ProductInfo>
      <DiscountTag discount={discounts} />
    </CardWrapper>
  );
};
