import React, { useCallback, useEffect, useState } from "react";
import axios from "axios";
import BestMealContainer from "./components/BestMealContainer";
import MealContainer from "/components/MealContainer";

// TODO: contant로 빼기
const MOCK_SERVER_URL = "https://c8611651-19e0-4ab7-9b27-51a7c3fe2fa6.mock.pstmn.io/"; // TODO: .env파일로 빼기

function App() {
  const [meals, setMeals] = useState({
    mealHeader: "",
    mealCards: [],
  });
  const fetchCategoryMeal = useCallback(async () => {
    try {
      const { status, data } = await axios.get(`${MOCK_SERVER_URL}/api/products?meal=main`);
      // TODO: status 코드 300번 구간도 포함해야하나 공부해보기
      if (status >= 400) {
        throw Error(`${status}: 데이터를 받아오는 도중 에러 발생`);
      }
      console.log(data);
      setMeals({
        mealHeader: "식탁을 풍성하게 하는 정갈한 밑반찬",
        mealCards: data,
      });
    } catch (error) {
      console.error(error);
    }
  }, []);

  useEffect(() => {
    fetchCategoryMeal();
  }, []);
  return (
    <>
      <BestMealContainer />
      <MealContainer meals={meals} />
      <div className="Modal"></div>
    </>
  );
}

export default App;
