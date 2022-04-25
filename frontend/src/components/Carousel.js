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

const CarouselButton = ({ dir, onClick }) => (
  <CarouselButtonWrapper dir={dir} onClick={onClick}>
    {dir === "left" ? <LeftArrowIcon /> : <RightArrowIcon />}
  </CarouselButtonWrapper>
);

export const Carousel = ({ categoryID, categoryName, size }) => {
  const [firstCardIndex, setfirstCardIndex] = useState(0);
  const categoryData = useFetch(categoryID);

  const moveSlide = (dir) => {
    console.log("hi");
    const newFirstCardIndex = firstCardIndex + cardNumPerPage[size];
    setfirstCardIndex(newFirstCardIndex);
    console.log(firstCardIndex);
  };

  return (
    <CarouselWrapper>
      <CarouselTitle size={size}>{categoryData?.full_name}</CarouselTitle>
      <CardList products={categoryData?.products} cardSize={size} firstCardIndex={firstCardIndex} />
      <CarouselButton onClick={moveSlide} dir={"left"} />
      <CarouselButton onClick={moveSlide} dir={"right"} />
    </CarouselWrapper>
  );
};
