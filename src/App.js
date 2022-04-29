import React, { useCallback, useEffect, useState } from 'react';

import { fetchData } from './utility/util';
import Header from './Header';
import MainCard from './MainCard';
import SubCard from './SubCard';
import styled from 'styled-components';
import { body, color } from './css/variables';
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

  const getSideDishData = async (url, setData) => {
    const response = await fetchData(url);

    setData(response.data);
  };

  const handleModal = useCallback(
    (cardInfo) => {
      if (isModalVisible) {
        return;
      }

      setSelectedCardInfo(cardInfo);
      setIsModalVisible(true);
    },

    [isModalVisible]
  );

  const handleClickMoreCard = useCallback(() => {
    setIsButtonVisible(!isButtonVisible);
  }, [isButtonVisible]);

  const btn = {
    open: '모든 카테고리 보기',
    close: '열린 카테고리 닫기',
  };

  const title = {
    first: '식탁을 풍성하게 하는 정갈한 밑반찬',
    second: '정성이 가득한 뜨끈뜨끈한 국물',
    third: '모두가 좋아하는 든든한 메인 요리',
    fourth: '함께하면 더욱 맛있는 상품',
  };

  return (
    <StyledApp>
      <Header />

      {isModalVisible && (
        <Modal>
          <CardOrderPage
            selectedCardInfo={selectedCardInfo}
            onClick={() => setIsModalVisible(false)}
            slideTitle={title.fourth}
            cardInfos={sideDishData}
            isModalVisible={isModalVisible}
          />
        </Modal>
      )}

      <MainCard
        mainCardData={mainCardData}
        handleModal={handleModal}
        isModalVisible={isModalVisible}
      />

      <SubCard
        dishData={mainDishData}
        title={title.first}
        handleModal={handleModal}
        isModalVisible={isModalVisible}
      />

      {isButtonVisible && (
        <>
          <SubCard
            dishData={soupData}
            title={title.second}
            handleModal={handleModal}
            isModalVisible={isModalVisible}
          />

          <SubCard
            dishData={sideDishData}
            title={title.third}
            handleModal={handleModal}
            isModalVisible={isModalVisible}
          />
        </>
      )}

      <StyledButton onClick={handleClickMoreCard}>
        {isButtonVisible ? btn.close : btn.open}
      </StyledButton>
    </StyledApp>
  );
};

const StyledApp = styled.div`
  width: ${body.width}px;
  position: relative;
  margin: 0 auto;
`;

const StyledButton = styled.button`
  cursor: pointer;
  display: block;
  margin: 0 auto;
  margin-top: 50px;
  margin-bottom: 30px;
  padding: 10px;
  background-color: transparent;
  border: 1px solid ${color.greyThree};
  border-radius: 10px;
`;

export default App;
