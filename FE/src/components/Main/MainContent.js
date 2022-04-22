import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { FONT } from '../../constants/fonts';
import foods from '../../mocks/foods';
import tabs from '../../mocks/tabs';
import Text from '../Text';
import FoodCards from './FoodCards';
import MainTabs from './MainTabs';

const FOOD_PER_PAGE = 3;

const MainContentWrap = styled.div`
  width: 100%;
`;

const MainText = styled.div`
  padding: 0px 80px;
`;

const MainContent = () => {
  const [selectedTabIndex, setSelectedTabIndex] = useState(0);
  const [randomFoods, setRandomFoods] = useState([]);
  const updateSelectedTab = (index) => {
    setSelectedTabIndex(index);
  };

  useEffect(() => {
    const randomFoodIndex = Math.floor(
      Math.random() * (foods.length - FOOD_PER_PAGE),
    );
    const getRandomFoods = foods.slice(
      randomFoodIndex,
      randomFoodIndex + FOOD_PER_PAGE,
    );
    setRandomFoods(getRandomFoods);
  }, [selectedTabIndex]);

  return (
    <MainContentWrap>
      <MainText>
        <Text font={FONT.TITLE}>한 번 주문하면 두 번 반하는 반찬</Text>
      </MainText>
      <MainTabs
        tabs={tabs}
        selectedTabIndex={selectedTabIndex}
        onTabClick={updateSelectedTab}
      />
      <FoodCards foods={randomFoods} size={FOOD_PER_PAGE} />
    </MainContentWrap>
  );
};

export default MainContent;
