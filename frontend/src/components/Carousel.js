import styled from "styled-components";
import { useMemo, useState } from "react";
import { useFetch } from "../fetcher";
import { CardList } from "./CardList";
import { cardNumPerPage } from "../convention";
import { LeftArrowIcon } from "../icons/LeftArrowIcon";
import { RightArrowIcon } from "../icons/RightArrowIcon";
import { HorizontalLine } from "./HorizontalLine";

const CarouselWrapper = styled.div`
  padding: 56px 80px;
  position: relative;
`;

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
  top: 310px;
  ${({ dir }) => (dir === "left" ? "left: 36px" : "right: 36px")}
`;

const CarouselButton = ({ dir, onBtnClick, isEndPage }) => (
  <CarouselButtonWrapper dir={dir} onClick={onBtnClick}>
    {dir === "left" ? (
      <LeftArrowIcon isEndPage={isEndPage} />
    ) : (
      <RightArrowIcon isEndPage={isEndPage} />
    )}
  </CarouselButtonWrapper>
);

export const Carousel = ({ id, name, size }) => {
  const [curIndex, setCurIndex] = useState(0);
  const categoryData = useFetch(id, false);

  const clickNext = () => {
    const sliderLength = categoryData.products.length;
    if (curIndex >= sliderLength - cardNumPerPage[size]) return;
    setCurIndex((prev) =>
      curIndex + cardNumPerPage[size] > sliderLength - cardNumPerPage[size]
        ? prev + 1
        : prev + cardNumPerPage[size]
    );
  };
  const clickPrev = () => {
    if (curIndex === 0) return;
    setCurIndex((prev) =>
      curIndex - cardNumPerPage[size] < 0
        ? prev - 1
        : prev - cardNumPerPage[size]
    );
  };
  // const moveSlide = (dir) => {
  //   const slideLength = categoryData.products.length;
  //   const maxFirstCardIndex = slideLength - cardNumPerPage[size];
  //   let newFirstCardIndex;
  //   let changed, max;
  //   changed =
  //     dir === "left"
  //       ? firstCardIndex - cardNumPerPage[size]
  //       : firstCardIndex + cardNumPerPage[size];
  //   max = dir === "left" ? 0 : maxFirstCardIndex;
  //   newFirstCardIndex = Math.max(changed, max);
  //   setfirstCardIndex(newFirstCardIndex);
  //   checkPageRemain(newFirstCardIndex, maxFirstCardIndex);
  // };

  return (
    <>
      {categoryData && (
        <CarouselWrapper>
          <HorizontalLine position={0} color={"Grey4"} />
          <CarouselTitle size={size}>{categoryData?.full_name}</CarouselTitle>
          <CardList
            products={categoryData?.products}
            cardSize={size}
            curIndex={curIndex}
          />
          <CarouselButton
            onBtnClick={() => clickPrev()}
            dir={"left"}
            isEndPage={curIndex === 0}
          />
          <CarouselButton
            onBtnClick={() => clickNext()}
            dir={"right"}
            isEndPage={curIndex === categoryData.products.length}
          />
        </CarouselWrapper>
      )}
    </>
  );
};
