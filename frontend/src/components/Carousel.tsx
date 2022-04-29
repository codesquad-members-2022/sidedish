import styled from "styled-components";
import { useState } from "react";
import { useFetch } from "../fetcher";
import { CardList } from "./CardList";
import { cardNumPerPage, Queries } from "../convention";
import { LeftArrowIcon } from "../icons/LeftArrowIcon";
import { RightArrowIcon } from "../icons/RightArrowIcon";
import { SizeProp, SIZES } from "../types";

const CarouselTitle = styled.span<SizeProp>`
  ${(props) =>
    props.size === "medium" &&
    `
      line-height: 38px;
      font-size: 24px;
    `}

  ${(props) =>
    props.size === "small" &&
    `
      line-height: 30px;
      font-size: 20px;
    `}
`;

const CarouselButtonWrapper = styled.div<SizeProp & { dir: string }>`
  position: absolute;
  ${({ size, dir }) =>
    size === SIZES.medium
      ? `
        top: 310px;
        ${dir === "left" ? "left: 36px;" : "right: 36px;"}`
      : `
        top: 51px;
        ${dir === "left" ? "right: 135px;" : "right: 57px;"}
      `}
`;

type ButtonType = SizeProp & {
  dir: string;
  onBtnClick: () => void;
  isEndPage: boolean;
};

const CarouselButton = ({ size, dir, onBtnClick, isEndPage }: ButtonType) => (
  <CarouselButtonWrapper size={size} dir={dir} onClick={onBtnClick}>
    {dir === "left" ? <LeftArrowIcon isEndPage={isEndPage} /> : <RightArrowIcon isEndPage={isEndPage} />}
  </CarouselButtonWrapper>
);

export const Carousel = ({ id, title, size }: { id: number; title: string } & SizeProp) => {
  const [curIndex, setCurIndex] = useState(0);
  const { products } = useFetch(Queries.products, id);
  const lastIndex = products?.length - cardNumPerPage[size];
  const clickNext = () => {
    if (curIndex >= lastIndex) return;
    setCurIndex((prev) => Math.min(prev + cardNumPerPage[size], lastIndex));
  };
  const clickPrev = () => {
    if (curIndex === 0) return;
    setCurIndex((prev) => Math.max(0, prev - cardNumPerPage[size]));
  };

  return (
    <>
      {products && (
        <>
          <CarouselTitle size={size}>{title}</CarouselTitle>
          <CardList products={products} size={size} curIndex={curIndex} />
          <CarouselButton
            data-cy="leftArrow"
            size={size}
            onBtnClick={() => clickPrev()}
            dir={"left"}
            isEndPage={curIndex === 0}
          />
          <CarouselButton
            data-cy="rightArrow"
            size={size}
            onBtnClick={() => clickNext()}
            dir={"right"}
            isEndPage={curIndex === lastIndex}
          />
        </>
      )}
    </>
  );
};
