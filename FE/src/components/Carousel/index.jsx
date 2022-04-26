import React from "react";
import MealCard from "components/MealCard";
import { AngleLeft, AngleRigth, Container } from "./style";

function Carousel({ cards }) {
  return (
    <Container>
      <AngleLeft />
      {cards.map(({ id, ...mealInfo }) => (
        <MealCard key={id} mealInfo={mealInfo} />
      ))}
      <AngleRigth />
    </Container>
  );
}

export default Carousel;
