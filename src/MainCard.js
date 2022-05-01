import React, { useState } from 'react';
import styled from 'styled-components';

import CardContainer from './container/CardContainer';
import Tab from './components/Tab';
import CategoryTitle from './components/CategoryTitle';

const MainCard = ({ mainCardData, handleModal, isModalVisible }) => {
  const [tabId, setTabId] = useState(0);

  const handleClickTab = (id) => {
    setTabId(id);
  };

  const startId = tabId === 0 ? 0 : tabId * 3;
  const endId = startId + 3;
  const mainDatas = mainCardData.slice(startId, endId);

  const banner = '기획전';
  const title = '한 번 주문하면 두 번 반하는 반찬';
  const showingSlideCardNum = 3;

  return (
    <CardContainer
      cardInfos={mainDatas}
      handleModal={handleModal}
      showingSlideCardNum={showingSlideCardNum}
      isModalVisible={isModalVisible}
    >
      <StyledTap>
        <CategoryTitle title={title} banner={banner} />
      </StyledTap>
      <Tab onClick={handleClickTab} />
    </CardContainer>
  );
};

const StyledTap = styled.div`
  display: flex;
`;

export default React.memo(MainCard);
