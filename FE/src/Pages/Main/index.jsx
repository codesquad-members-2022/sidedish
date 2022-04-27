import React, { useCallback, useEffect, useState } from "react";
import axios from "axios";
import BestMealContainer from "components/BestMealContainer";
import MealContainer from "components/MealContainer";
import { MOCK_MAIN, MOCK_SERVER_URL } from "constants";
import { Container } from "./style";

const Main = () => {
  const [meals, setMeals] = useState({
    mealHeader: "",
    mealCards: [],
  });
  const fetchCategoryMeal = useCallback(async () => {
    try {
      const { data } = await axios.get(`${MOCK_SERVER_URL}/api/products?meal=main`, {
        validateStatus: (status) => {
          return status >= 200 && status < 300;
        },
      });
      setMeals({
        mealHeader: "식탁을 풍성하게 하는 정갈한 밑반찬",
        mealCards: data,
      });
    } catch (error) {
      console.error(error);
      // BUG: 개발 과정에서 mock server나 api 에러가 났을 때 constant의 mock데이터 사용
      setMeals({
        mealHeader: "식탁을 풍성하게 하는 정갈한 밑반찬",
        mealCards: MOCK_MAIN,
      });
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
