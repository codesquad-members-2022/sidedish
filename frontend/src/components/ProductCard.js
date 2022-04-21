import styled from "styled-components";

import { DiscountTag } from "./DiscountTag";
import { useState } from "react";
import { thumbnailSize } from "../convention";

export const ProductInfo = styled.div`
  padding: 0px;
  ${({ theme }) =>
    theme.custom_flex("column", "flex-start") +
    theme.custom_absolute(0, 0, 0, 0)}
`;
const SmallCard = styled.div`
  ${({ theme }) =>
    theme.custom_flex("row", "flex-start") +
    theme.flex_none(2, 8, 0) +
    theme.custom_static(200, null, null, 0) +
    theme.width_height_bypx(112, 26)}
`;
const Description = styled.span`
  ${({ theme, size }) =>
    theme.custom_static(34, null, null, 0) +
      theme.custom_font("Noto Sans KR", 14, 400, 24, -0.008) +
      ` color:${theme.colors.Grey2};` +
      theme.flex_none(1, 8, 0) +
      size ===
      "small" && `top:168px; color:${theme.colors.Grey2};`}
`;
const Name = styled.span``;
const Original = styled.span``;
const Final = styled.span``;
const Price = styled.div`
  ${({ theme, size }) =>
    theme.custom_flex("row", "center") + `width:26px;` + size !== "small"
      ? `justify-content:center;top:66px;`
      : `top:200px` +
        `${Final} {
    ${
      theme.width_height_bypx(null, 26) +
      theme.custom_static(0, null, null, 0) +
      theme.custom_font("Noto Sans KR", 16, 500, 26, -0.008) +
      theme.flex_none(0, 0, 8)
    }
  }

  ${Original} {
    ${
      theme.custom_font("Noto Sans KR", 14, 400, 24, -0.008) +
        theme.flex_none(1, 0, 8) +
        size ===
      "small"
        ? `left:64px;top:0px;`
        : `left:73px; top:1px`
    }
    color:${theme.colors.Grey3};
    text-decoration-line:line-through;
  }`}
`;

const Body = styled.div`
  ${({ theme }) =>
    theme.flex_none(1, 16, 0) +
    theme.custom_flex("column", "flex-start") +
    theme.custom_static(427, null, null, 0) +
    theme.width_height_bypx(411, 92) +
    `
  ${Name} {
    ${
      theme.custom_font("Noto Sans KR", 16, 500, 26, -0.008) +
      theme.custom_static(0, null, null, 0) +
      `color:${theme.colors.Grey1};` +
      theme.flex_none(0, 8, 0)
    }
  }
`}
`;
const Image = styled.img`
  ${({ theme, hover, size, img }) =>
    theme.width_height_bypx(size, size) +
    `background:${
      hover
        ? "linear-gradient(0deg, rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1))"
        : ""
    } url(${img});` +
    theme.flex_none(0, 16, 0)}
`;
const HoverInfo = styled.div``;
export const ProductCard = ({
  size,
  name,
  description,
  price,
  final_price,
  primary_image,
  discount,
}) => {
  const [hover, setHover] = useState(false);
  return size !== "small" ? (
    <>
      <HoverInfo></HoverInfo>
      <ProductInfo>
        <DiscountTag discount={discount}></DiscountTag>
        <Body>
          <Price>
            <span>{price}</span>
            <span>{final_price}</span>
          </Price>
          <Description>{description}</Description>
          <Name>{name}</Name>
        </Body>
        <Image
          onMouseOver={() => setHover(true)}
          onMouseLeave={() => setHover(false)}
          size={parseInt(thumbnailSize[size])}
          img={primary_image}
          hover={hover}
        ></Image>
      </ProductInfo>
    </>
  ) : (
    <SmallCard>
      <Description>{name}</Description>
      <Price>
        <Original>{price}</Original>
        <Final>{final_price}</Final>
      </Price>
    </SmallCard>
  );
};
