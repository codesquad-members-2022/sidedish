import styled from "styled-components";
import { useState } from "react";
import { useFetch } from "../fetcher";
import { CardList } from "./CardList";
import { cardNumPerPage } from "../convention";
import { LeftArrowIcon } from "../icons/LeftArrowIcon";
import { RightArrowIcon } from "../icons/RightArrowIcon";

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
    {dir === "left" ? <LeftArrowIcon isEndPage={isEndPage} /> : <RightArrowIcon isEndPage={isEndPage} />}
  </CarouselButtonWrapper>
);

export const Carousel = ({ categoryID, categoryName, size }) => {
  const [firstCardIndex, setfirstCardIndex] = useState(0);
  const [isFirstPage, setIsFirstPage] = useState(true);
  const [isLastPage, setIsLastPage] = useState(false);
  const categoryData = useFetch(categoryID);

  const moveSlide = (dir) => {
    const slideLength = categoryData.products.length;
    const maxFirstCardIndex = slideLength - cardNumPerPage[size];
    let newFirstCardIndex;
    if (dir === "left") {
      newFirstCardIndex = Math.max(firstCardIndex - cardNumPerPage[size], 0);
    } else if (dir === "right") {
      newFirstCardIndex = Math.min(firstCardIndex + cardNumPerPage[size], maxFirstCardIndex);
    }
    setfirstCardIndex(newFirstCardIndex);
    checkPageRemain(newFirstCardIndex, maxFirstCardIndex);
  };

  const checkPageRemain = (firstCardIndex, maxFirstCardIndex) => {
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
    <CarouselWrapper>
      <CarouselTitle size={size}>{categoryData?.full_name}</CarouselTitle>
      <CardList products={categoryData?.products} cardSize={size} firstCardIndex={firstCardIndex} />
      <CarouselButton onBtnClick={() => moveSlide("left")} dir={"left"} isEndPage={isFirstPage} />
      <CarouselButton onBtnClick={() => moveSlide("right")} dir={"right"} isEndPage={isLastPage} />
    </CarouselWrapper>
  );
};
