import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard";
import { thumbnailSize } from "../convention";
import { width_height_bypx } from "../styles/global";

const ShowingArea = styled.div`
  margin-top: 34px;
  overflow: hidden;
  ${(props) => props.size === "large" && width_height_bypx(1281, 565)}

  ${(props) => props.size === "medium" && width_height_bypx(1280, 479)}

  ${(props) => props.size === "small" && width_height_bypx(864, 226)}
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
          <ProductCard
            key={product.id}
            cardSize={cardSize}
            {...product}
          ></ProductCard>
        ))}
      </ProductCardsWrapper>
    </ShowingArea>
  );
};
