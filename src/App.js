import React, { useEffect, useState } from 'react';

import { fetchData } from './utility/util';
import Header from './Header';
import MainCard from './MainCard';
import SubCard from './SubCard';
import styled from 'styled-components';
import { maxWidthBody } from './css/variables';
import Modal from './components/Modal';
import CardOrderPage from './components/CardOrderPage';

const App = () => {
  const [mainCardData, setMainCardData] = useState([]);
  const [mainDishData, setMainDishData] = useState([]);
  const [sideDishData, setSideDishData] = useState([]);
  const [soupData, setSoupData] = useState([]);
  const [isButtonVisible, setIsButtonVisible] = useState(false);
  const [selectedCardInfo, setSelectedCardInfo] = useState({});
  const [isModalVisible, setIsModalVisible] = useState(false);

  const handleModal = (cardInfo) => {
    setSelectedCardInfo(cardInfo);
    setIsModalVisible(true);
  };

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

  const handleClickMoreCard = () => {
    setIsButtonVisible(!isButtonVisible);
  };

  const btn = {
    open: '모든 카테고리 보기',
    close: '열린 카테고리 닫기',
  };

  const title = {
    first: '식탁을 풍성하게 하는 정갈한 밑반찬',
    second: '정성이 가득한 뜨끈뜨끈한 국물',
    third: '모두가 좋아하는 든든한 메인 요리',
  };

  return (
    <StyledApp>
      <Header />
      {isModalVisible && (
        <Modal>
          <CardOrderPage selectedCardInfo={selectedCardInfo} />
        </Modal>
      )}
      <MainCard mainCardData={mainCardData} handleModal={handleModal} />
      <SubCard dishData={mainDishData} title={title.first} />
      {isButtonVisible && <SubCard dishData={soupData} title={title.second} />}
      {isButtonVisible && (
        <SubCard dishData={sideDishData} title={title.third} />
      )}
      <StyledButton onClick={handleClickMoreCard}>
        {isButtonVisible ? btn.close : btn.open}
      </StyledButton>
    </StyledApp>
  );
};

const StyledApp = styled.div`
  width: ${maxWidthBody.width}px;
  margin: 0 auto;
  position: relative;
`;

const StyledButton = styled.button`
  cursor: pointer;
  display: block;
  margin: auto;
`;

export default App;
