import { useEffect, useState } from 'react';
import styled from 'styled-components';

import categoriesApi from '../../apis/categoriesApi';
import { FONT } from '../../constants/fonts';
import mainTabs from '../../mocks/mainTabs';
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

const firstTabId = mainTabs.data[0].id;

const MainContent = () => {
  const [selectedTabId, setSelectedTabId] = useState(firstTabId);
  const [randomFoods, setRandomFoods] = useState([]);
  const updateSelectedTab = (id) => {
    setSelectedTabId(id);
  };

  useEffect(() => {
    const fetchMainContent = async () => {
      const seletedTab = mainTabs.data.find((tab) => tab.id === selectedTabId);
      const { data: newRandomFoods } =
        await categoriesApi.getRandFoodsByMainTab(seletedTab.title);
      setRandomFoods(newRandomFoods);
    };
    fetchMainContent();
  }, [selectedTabId]);

  return (
    <MainContentWrap>
      <MainText>
        <Text font={FONT.TITLE}>한 번 주문하면 두 번 반하는 반찬</Text>
      </MainText>
      <MainTabs
        tabs={mainTabs.data}
        selectedTabId={selectedTabId}
        onTabClick={updateSelectedTab}
      />
      <FoodCards foods={randomFoods} size={FOOD_PER_PAGE} />
    </MainContentWrap>
  );
};

export default MainContent;
