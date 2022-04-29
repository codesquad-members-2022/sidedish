import React, { useCallback, useEffect, useState } from "react";
import BestMealContainer from "components/BestMealContainer";
import MealContainer from "components/MealContainer";
import { Container, MoreBtn } from "./style";
import { useAxios } from "hooks/useAxios";
import Loader from "components/Loader";

const CATEGORY_TYPE = [
  { id: 100, title: "든든한 메인 요리", apiParams: "main" },
  { id: 200, title: "뜨끈한 국물요리", apiParams: "soup" },
  { id: 300, title: "정갈한 밑반찬", apiParams: "side" },
];

const Main = () => {
  const [currIndex, setCurrIndex] = useState(0);
  const [mealsArr, setMealsArr] = useState([]);
  const { response: meals } = useAxios({
    method: "get",
    url: `/products`,
    params: { meal: CATEGORY_TYPE[currIndex].apiParams },
  });

  const addCardHandler = useCallback(() => {
    setCurrIndex((prev) => prev + 1);
  }, []);

  const updateMealsArr = useCallback(() => {
    // FIXME: 아래와 같은 문제가 있지만 일단 동작은 하게 하기 위해 아래와 같은 코드를 짬.
    // 문제: useAxios의 response가 두 번씩 호출되는데(초기 값, 요청 응답값) 새롭게 fetch 요청을 할 때 초기 값으로 이전 요청에 대한 응답값을 가지고 있음.
    if (!meals) {
      return;
    }
    const filterSameKey = (prev) => {
      const temp = [...prev];
      const length = prev.length;
      const newData = {
        id: CATEGORY_TYPE[currIndex].id,
        mealHeader: CATEGORY_TYPE[currIndex].title,
        mealCards: meals,
      };
      if (temp[length - 1]?.id === newData.id) {
        temp.pop();
      }
      temp.push(newData);
      return temp;
    };
    setMealsArr(filterSameKey);
  }, [currIndex, meals]);

  useEffect(() => {
    updateMealsArr();
  }, [currIndex, meals, updateMealsArr]);

  return (
    <Container>
      <BestMealContainer />
      {!mealsArr.length ? (
        <Loader />
      ) : (
        mealsArr.map(({ id, ...containerInfo }) => <MealContainer key={id} containerInfo={containerInfo} />)
      )}
      {/* FIXME: 매직 넘버 수정해야함 */}
      {currIndex < 2 ? <MoreBtn onClick={addCardHandler}>더 보기</MoreBtn> : <></>}
    </Container>
  );
};

export default Main;
