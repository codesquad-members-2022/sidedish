import React, { useState } from "react";
import { useEffect } from "react";
import axios from "axios";
import styled from "styled-components";
import BestMealCard from "components/BestMealCard";
import Loader from "components/Loader";

import { MOCK_SERVER_URL } from "constant";

const BEST_TITLE = "한 번 주문하면 두 번 반하는 반찬";
const BEST_SUBTITLE = ["풍성한 고기 반찬", "편리한 반찬 세트", "맛있는 제철 요리", "우리 아이 영양 반찬"];

const BestMealContainerStyled = styled.div`
  display: flex;
  flex-direction: column;
`;

const BestMealCardContainer = styled.div`
  display: flex;
`;

function BestMealContainer() {
  const [meals, setMeals] = useState([]);

  async function fetchData() {
    try {
      const { data } = await axios.get(`${MOCK_SERVER_URL}/api/products/best?category=meat`, {
        validateStatus: function (status) {
          return status >= 200 && status < 300;
        },
      });
      setMeals(data);
    } catch (error) {
      console.error(error);
    }
  }

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <BestMealContainerStyled>
      <div className="BestMealHeader">{BEST_TITLE}</div>
      <div className="BestMealNavigation">
        {BEST_SUBTITLE.map((val, index) => (
          <h3 key={index}>{val}</h3>
        ))}
      </div>
      <BestMealCardContainer>
        {meals.length ? meals.map(({ id, ...meal }) => <BestMealCard key={id} meal={meal} />) : <Loader />}
      </BestMealCardContainer>
    </BestMealContainerStyled>
  );
}

export default BestMealContainer;
