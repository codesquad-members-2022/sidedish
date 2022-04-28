import React, { useCallback, useEffect, useState } from "react";
import axios from "axios";
import BestMealContainer from "components/BestMealContainer";
import MealContainer from "components/MealContainer";
import { MOCK_SERVER_URL } from "constants";
import { Container } from "./style";
import { CAROUSEL_DATA } from "constants";

const Main = () => {
  const [meals, setMeals] = useState({
    mealHeader: "",
    mealCards: [],
  });
  const fetchCategoryMeal = useCallback(async () => {
    try {
      const { data } = await axios.get(`${MOCK_SERVER_URL}/products?meal=main`, {
        validateStatus: (status) => {
          return !(status >= 300);
        },
      });
      setMeals({
        mealHeader: "식탁을 풍성하게 하는 정갈한 밑반찬",
        mealCards: data,
      });
    } catch (error) {
      setMeals({
        mealHeader: "식탁을 풍성하게 하는 정갈한 밑반찬",
        mealCards: CAROUSEL_DATA,
      });

      console.error(error);
    }
  }, []);
  useEffect(() => {
    fetchCategoryMeal();
  }, [fetchCategoryMeal]);
  return (
    <Container>
      <BestMealContainer />
      <MealContainer meals={meals} />
    </Container>
  );
};

export default Main;
