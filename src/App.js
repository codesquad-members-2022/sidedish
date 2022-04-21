import React, { useEffect, useState } from 'react';

import { fetchData } from './utility/util';
import Header from './Header';
import MainCard from './MainCard';
import SubCard from './SubCard';
import styled from 'styled-components';

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
    <>
      <Header />
      <MainCard mainCardData={mainCardData} />
      <SubCard dishData={mainDishData} />
      {isVisible && <SubCard dishData={sideDishData} />}
      {isVisible && <SubCard dishData={soupData} />}
      <StyledButton onClick={handleClickMoreCard}>
        {isVisible ? closeBtn : openBtn}
      </StyledButton>
    </>
  );
};

const StyledButton = styled.button`
  cursor: pointer;
  display: block;
  margin: auto;
`;

export default App;
