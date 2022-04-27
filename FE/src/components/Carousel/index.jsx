import React from "react";
import MealCard from "components/MealCard";
import { AngleLeft, AngleRight, CarouselContainer, Container } from "./style";

function getCarouselDesign(width, imageCount, imageSize) {
  const size = imageSize;
  let count = imageCount;

  while (width < count * size) {
    if (count < 2) break;
    count -= 1;
  }
  const gap = Math.floor((1280 - imageSize * count) / (count - 1));
  // BUG: gap값 구할 때 count가 1이면 Infinity가 출력 됨
  return { gap, size };
}

const IMAGE_COUNT = 4;
const IMAGE_SIZE = 300;

function Carousel({ cards }) {
  const { gap, size } = getCarouselDesign(1280, IMAGE_COUNT, IMAGE_SIZE);
  return (
    <Container>
      <AngleLeft />
      <CarouselContainer gap={gap}>
        {cards.map(({ id, ...mealInfo }) => (
          <MealCard key={id} mealInfo={mealInfo} size={size} />
        ))}
      </CarouselContainer>
      <AngleRight />
    </Container>
  );
}

export default Carousel;
