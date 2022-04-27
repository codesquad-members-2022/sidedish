import { useState, useCallback, useEffect } from 'react';
import styled from 'styled-components';
import RecommendProduct from 'Main/Recommend/RecommendProduct';
import DishContainer from 'Main/Dish/DishContainer';
import DishCategoryAllButton from 'Main/Dish/DishCategoryAllButton';
import axios from 'axios';
import { SERVER_URL } from 'constant.js';

const Main = styled.main`
  margin: 0 auto;
  max-width: 1440px;
  padding: 0 80px;
`;

const MainContainer = () => {
  const [dishes, setDishes] = useState({});
  const fetchData = useCallback(async () => {
    try {
      const { data } = await axios.get(`${SERVER_URL}categories/1/`);
      if (data) {
        setDishes(data);
      }
    } catch (error) {
      throw new Error(error);
    }
  }, []);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  return (
    <Main>
      <RecommendProduct />
      {Object.keys(dishes).length !== 0 && <DishContainer items={dishes}></DishContainer>}
      <DishCategoryAllButton />
    </Main>
  );
};

export default MainContainer;
