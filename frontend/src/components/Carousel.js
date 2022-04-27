import styled from "styled-components";
import { useMemo, useState } from "react";
import { useFetch } from "../fetcher";
import { CardList } from "./CardList";
import { cardNumPerPage, SIZES } from "../convention";
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
  ${({size, dir}) => 
    size === SIZES.medium 
    ? `
      top: 310px;
      ${(dir === "left" ? "left: 36px;" : "right: 36px;")}` 
    : `
      top: 51px;
      ${(dir === "left" ? "right: 135px;" : "right: 57px;")}`
    }
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
