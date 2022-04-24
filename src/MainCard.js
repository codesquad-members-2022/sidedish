import React, { useState } from 'react';
import styled from 'styled-components';

import CardContainer from './container/CardContainer';
import Tab from './components/Tab';
import CategoryTitle from './components/CategoryTitle';

const MainCard = ({ mainCardData }) => {
  const [tabId, setTabId] = useState(0);

  const handleClickTab = ({ target }) => {
    const selectedItem = target.closest('li');
    if (!selectedItem) return;

    const selectedId = selectedItem.dataset.id;
    setTabId(selectedId);
  };

  const startId = tabId === 0 ? 0 : tabId * 3;
  const endId = startId + 3;
  const mainDatas = mainCardData.slice(startId, endId);

  const banner = '기획전';
  const title = '한 번 주문하면 두 번 반하는 반찬';
  const cardNum = 3;

  return (
    <CardContainer cardInfos={mainDatas} cardNum={cardNum}>
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

export default MainCard;
