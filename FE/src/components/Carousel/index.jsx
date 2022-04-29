import React, { useCallback, useState } from "react";
import { AngleLeft, AngleRight, CarouselContainer, Container, IndexStatusContainer } from "./style";

const getCarouselChildrenGap = (width, imageCount, imageSize) => {
  const size = imageSize;
  let count = imageCount;

  while (width < count * size) {
    if (count < 2) break;
    count -= 1;
  }
  const gap = Math.floor((width - imageSize * count) / count);
  // BUG: gap값 구할 때 count가 1이면 Infinity가 출력 됨
  return gap;
};

const DEFAULT_CAROUSEL_INDEX = 0;

// FIXME: -1, +1 같은 매직넘버 줄어야할까요?
const Carousel = ({ cards, parentWidth, imageCount, imageSize, children }) => {
  const carouselLegnth = Math.ceil(cards.length / imageCount);
  const MAX_CAROUSEL_INDEX = carouselLegnth - 1;
  const gap = getCarouselChildrenGap(parentWidth, imageCount, imageSize);
  const [headIndex, setHeadIndex] = useState(DEFAULT_CAROUSEL_INDEX);
  const [currentDisplay, setCurrentDisplay] = useState(headIndex * parentWidth);
  const checkLimitIndex = useCallback(
    (newIndex) => {
      if (newIndex > MAX_CAROUSEL_INDEX) {
        newIndex = DEFAULT_CAROUSEL_INDEX;
      } else if (newIndex < DEFAULT_CAROUSEL_INDEX) {
        newIndex = MAX_CAROUSEL_INDEX;
      }
      setCurrentDisplay(newIndex * parentWidth * -1);
      return newIndex;
    },
    [MAX_CAROUSEL_INDEX, parentWidth]
  );
  const moveLeft = useCallback(() => {
    setHeadIndex((prev) => checkLimitIndex(prev - 1));
  }, [checkLimitIndex]);
  const moveRight = useCallback(() => {
    setHeadIndex((prev) => checkLimitIndex(prev + 1));
  }, [checkLimitIndex]);
  return (
    <Container>
      <AngleLeft onClick={moveLeft} gap={gap} />
      <IndexStatusContainer gap={gap} activeIndex={headIndex}>
        {Array(carouselLegnth)
          .fill(0)
          .map((_, index) => (
            <li key={index}></li>
          ))}
      </IndexStatusContainer>
      <CarouselContainer gap={gap} currentDisplay={currentDisplay}>
        <ul>{children}</ul>
      </CarouselContainer>
      <AngleRight onClick={moveRight} gap={gap} />
    </Container>
  );
};

export default Carousel;
