import React from "react";
import styled from "styled-components";
import Loader from "components/Loader";
import MealCard from "components/MealCard";

// TODO: style.js로 분리하기
const MealContainerStyled = styled.div``;

const MealCarouselStyled = styled.div`
  display: flex;
`;

// TODO: component로 분리하기
function Carousel({ cards }) {
  return (
    <MealCarouselStyled>
      <button>⬅️</button>
      {cards.map(({ id, ...mealInfo }) => (
        <MealCard key={id} mealInfo={mealInfo} />
      ))}
      <button>➡️</button>
    </MealCarouselStyled>
  );
}

function MealContainer({ meals }) {
  const { mealHeader, mealCards } = meals;
  return (
    <MealContainerStyled>
      <h2>{mealHeader}</h2>
      {mealCards.length ? <Carousel cards={mealCards} /> : <Loader />}
    </MealContainerStyled>
  );
}

export default MealContainer;
