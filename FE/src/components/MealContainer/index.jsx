import React from "react";
import Carousel from "components/Carousel";
import { Container, Header } from "./style";
import MealCard from "components/MealCard";
import Loader from "components/Loader";

// 캐러셀
const IMAGE_COUNT = 4;
const MEAL_IMAGE_SIZE = 300;
const parentWidth = 1280;

const MealContainer = ({ containerInfo }) => {
  const { mealHeader, mealCards } = containerInfo;
  return (
    <Container>
      <Header>{mealHeader}</Header>
      {mealCards.length ? (
        <Carousel cards={mealCards} parentWidth={parentWidth} imageCount={IMAGE_COUNT} imageSize={MEAL_IMAGE_SIZE}>
          {mealCards.map(({ id, ...mealInfo }) => (
            <MealCard key={id} mealInfo={mealInfo} size={MEAL_IMAGE_SIZE} />
          ))}
        </Carousel>
      ) : (
        <Loader />
      )}
    </Container>
  );
};

export default MealContainer;
