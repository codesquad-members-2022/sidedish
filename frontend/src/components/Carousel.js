import styled from "styled-components";
import { useState } from "react";
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

export const Carousel = ({ categoryID, size }) => {
  const [firstCardIndex, setfirstCardIndex] = useState(0);
  const [isFirstPage, setIsFirstPage] = useState(true);
  const [isLastPage, setIsLastPage] = useState(false);
  const categoryData = useFetch(categoryID);

  const moveSlide = (dir) => {
    const slideLength = categoryData.products.length;
    const maxFirstCardIndex = slideLength - cardNumPerPage[size];
    let newFirstCardIndex;
    // let changed, max;
    // changed = dir==='left'? firstCardIndex-cardNumPerPage[size]: firstCardIndex+maxFirstCardIndex
    // max = dir==="left"?0:maxFirstCardIndex;
    // newFirstCardIndex= Math.max(changed,max);

    if (dir === "left") {
      newFirstCardIndex = Math.max(firstCardIndex - cardNumPerPage[size], 0);
    } else if (dir === "right") {
      newFirstCardIndex = Math.min(
        firstCardIndex + cardNumPerPage[size],
        maxFirstCardIndex
      );
    }
    setfirstCardIndex(newFirstCardIndex);
    checkPageRemain(newFirstCardIndex, maxFirstCardIndex);
  };

  const checkPageRemain = (firstCardIndex, maxFirstCardIndex) => {
    // setIsFirstPage(firstCardIndex===0);
    // setIsLastPage(firstCardIndex===maxFirstCardIndex);
    if (firstCardIndex === 0) {
      setIsFirstPage(true);
    } else if (firstCardIndex === maxFirstCardIndex) {
      setIsLastPage(true);
    } else {
      setIsFirstPage(false);
      setIsLastPage(false);
    }
  };

  return (
    <>
      <CarouselTitle size={size}>{categoryData?.full_name}</CarouselTitle>
      <CardList
        products={categoryData?.products}
        cardSize={size}
        firstCardIndex={firstCardIndex}
      />
      <CarouselButton
        size={size}
        onBtnClick={() => moveSlide("left")}
        dir={"left"}
        isEndPage={isFirstPage}
      />
      <CarouselButton
        size={size}
        onBtnClick={() => moveSlide("right")}
        dir={"right"}
        isEndPage={isLastPage}
      />
    </>
  );
};
