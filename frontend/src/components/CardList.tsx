import styled from "styled-components";
import { ProductCard } from "./ProductCard";
import { thumbnailSize, cardGapLength, cardListArea } from "../convention";
import { width_height_bypx } from "../styles/global";
import { useEffect, useRef } from "react";
import { Product, SizeProp } from "../types";

const ShowingArea = styled.div<SizeProp>`
  margin-top: 34px;
  overflow: hidden;
  ${({ size }) => width_height_bypx(...cardListArea[size])}
`;

const ProductCardsWrapper = styled.div`
  display: flex;
`;

type ListProp = SizeProp & {
  products: Product[];
  curIndex?: number;
};

export const CardList = ({
  products,
  size: cardSize,
  curIndex = 0,
}: ListProp) => {
  const sliderRef = useRef<HTMLDivElement>(null);
  useEffect(() => {
    if (sliderRef.current) {
      sliderRef.current.style.transition = `0.4s ease-out`;
      sliderRef.current.style.transform = `translateX(-${
        curIndex * (cardGapLength[cardSize] + thumbnailSize[cardSize])
      }px)`;
    }
  }, [curIndex]);
  return (
    <ShowingArea data-cy="cardList" size={cardSize}>
      <ProductCardsWrapper ref={sliderRef}>
        {products?.map((product) => (
          <ProductCard
            key={product.id}
            size={cardSize}
            {...product}
          ></ProductCard>
        ))}
      </ProductCardsWrapper>
    </ShowingArea>
  );
};
