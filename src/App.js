import React, { useEffect, useState } from 'react';

import { fetchData } from './utility/util';
import Header from './Header';
import MainCard from './MainCard';
import SubCard from './SubCard';
import styled from 'styled-components';
import { maxWidthBody } from './css/variables';

const App = () => {
  const [mainCardData, setMainCardData] = useState([]);
  const [mainDishData, setMainDishData] = useState([]);
  const [sideDishData, setSideDishData] = useState([]);
  const [soupData, setSoupData] = useState([]);

  const getSideDishData = async (url, setData) => {
    const response = await fetchData(url);

    setData(response.data);
  };

  useEffect(() => {
    const mainCardUrl = 'data/mainCard.json';
    const mainDishUrl = 'data/mainDish.json';
    const sideDishUrl = 'data/sideDish.json';
    const soupUrl = 'data/soup.json';

    getSideDishData(mainCardUrl, setMainCardData);
    getSideDishData(mainDishUrl, setMainDishData);
    getSideDishData(sideDishUrl, setSideDishData);
    getSideDishData(soupUrl, setSoupData);
  }, []);

  const [isVisible, setIsVisible] = useState(false);

  const handleClickMoreCard = () => {
    setIsVisible(!isVisible);
  };

  const openBtn = '모든 카테고리 보기';
  const closeBtn = '열린 카테고리 닫기';

  return (
    <StyledApp>
      <Header />
      <MainCard mainCardData={mainCardData} />
      <SubCard
        dishData={mainDishData}
        title={'식탁을 풍성하게 하는 정갈한 밑반찬'}
      />
      {isVisible && (
        <>
          <SubCard
            dishData={soupData}
            title={'정성이 가득한 뜨끈뜨끈한 국물'}
          />
          <SubCard
            dishData={sideDishData}
            title={'모두가 좋아하는 든든한 메인 요리'}
          />
        </>
      )}
      <StyledButton onClick={handleClickMoreCard}>
        {isVisible ? closeBtn : openBtn}
      </StyledButton>
    </StyledApp>
  );
};

const StyledApp = styled.div`
  width: ${maxWidthBody.width}px;
  margin: 0 auto;
`;

const StyledButton = styled.button`
  cursor: pointer;
  display: block;
  margin: auto;
`;

export default App;
