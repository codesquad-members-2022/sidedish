import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard";
import { thumbnailSize } from "../convention";

const ShowingArea = styled.div`
  margin-top: 34px;
  overflow: hidden;
  ${(props) =>
    props.size === "large" &&
    css`
      width: 1281px;
      height: 565px;
    `}

  ${(props) =>
    props.size === "medium" &&
    css`
      width: 1280px;
      height: 479px;
    `}

  ${(props) =>
    props.size === "small" &&
    css`
      width: 864px;
      height: 226px;
    `}
`;

const ProductCardsWrapper = styled.div`
  display: flex;
  transition: 0.4s ease-out;
  transform: ${({ cardSize, firstCardIndex }) =>
    `translateX(-${firstCardIndex * (24 + thumbnailSize[cardSize])}px)`};
`;

export const CardList = ({ products, cardSize, firstCardIndex = 0 }) => {
  return (
    <ShowingArea size={cardSize}>
      <ProductCardsWrapper cardSize={cardSize} firstCardIndex={firstCardIndex}>
        {products?.map((product) => (
          <ProductCard key={product.id} cardSize={cardSize} {...product}></ProductCard>
        ))}
      </ProductCardsWrapper>
    </ShowingArea>
  );
};
