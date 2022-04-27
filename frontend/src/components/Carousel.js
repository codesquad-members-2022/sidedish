import styled from "styled-components";
import { useState } from "react";
import { useFetch } from "../fetcher";
import { CardList } from "./CardList";
import { cardNumPerPage, Queries, SIZES } from "../convention";
import { LeftArrowIcon } from "../icons/LeftArrowIcon";
import { RightArrowIcon } from "../icons/RightArrowIcon";

const CarouselTitle = styled.span`
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

const CarouselButtonWrapper = styled.div`
  position: absolute;
  ${({ size, dir }) =>
    size === SIZES.medium
      ? `
      top: 310px;
      ${dir === "left" ? "left: 36px;" : "right: 36px;"}`
      : `
      top: 51px;
      ${dir === "left" ? "right: 135px;" : "right: 57px;"}`}
`;

const CarouselButton = ({ size, dir, onBtnClick, isEndPage }) => (
  <CarouselButtonWrapper size={size} dir={dir} onClick={onBtnClick}>
    {dir === "left" ? (
      <LeftArrowIcon isEndPage={isEndPage} />
    ) : (
      <RightArrowIcon isEndPage={isEndPage} />
    )}
  </CarouselButtonWrapper>
);

export const Carousel = ({ id, name, size }) => {
  const [curIndex, setCurIndex] = useState(0);
  const categoryData = useFetch(Queries.categoryProducts, id);
  const lastIndex = categoryData?.products.length - cardNumPerPage[size];
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
      <CarouselTitle size={size}>{categoryData?.full_name}</CarouselTitle>
      <CardList
        products={categoryData?.products}
        cardSize={size}
        curIndex={curIndex}
      />
      <CarouselButton
        size={size}
        onBtnClick={() => clickPrev()}
        dir={"left"}
        isEndPage={curIndex === 0}
      />
      <CarouselButton
        size={size}
        onBtnClick={() => clickNext()}
        dir={"right"}
        isEndPage={curIndex === lastIndex}
      />
    </>
  );
};
