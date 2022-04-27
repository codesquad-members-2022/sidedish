import styled, { css } from "styled-components";
import { ProductCard } from "./ProductCard";
import { cardListArea, thumbnailSize } from "../convention";
import { width_height_bypx } from "../styles/global";
import { useEffect, useRef } from "react";

const ShowingArea = styled.div`
  margin-top: 34px;
  overflow: hidden;
  ${({ size }) => width_height_bypx(...cardListArea[size])}
`;

const ProductCardsWrapper = styled.div`
  display: flex;
`;

export const CardList = ({ products, cardSize, curIndex = 0 }) => {
  const sliderRef = useRef(null);
  useEffect(() => {
    sliderRef.current.style.transition = `0.4s ease-out`;
    sliderRef.current.style.transform = `translateX(-${
      curIndex * (24 + thumbnailSize[cardSize])
    }px)`;
  }, [curIndex]);
  return (
    <ShowingArea size={cardSize}>
      <ProductCardsWrapper cardSize={cardSize} ref={sliderRef}>
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
