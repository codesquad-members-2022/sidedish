import React from "react";
import Loader from "components/Loader";
import Carousel from "components/Carousel";
import { Container, Header } from "./style";
import MealCard from "components/MealCard";

// 캐러셀
const IMAGE_COUNT = 4;
const MEAL_IMAGE_SIZE = 300;
const parentWidth = 1280;

const MealContainer = ({ meals }) => {
  const { mealHeader, mealCards } = meals;
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
