import React, { useState } from 'react';
import styled from 'styled-components';

import CardContainer from './container/CardContainer';
import Tab from './components/Tab';

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

  return (
    <CardContainer cardInfos={mainDatas}>
      <div>
        <StyledTap>
          <span>기획전 </span>
          <h2>한 번 주문하면 두 번 반하는 반찬</h2>
        </StyledTap>
        <Tab onClick={handleClickTab} />
      </div>
    </CardContainer>
  );
};

const StyledTap = styled.ul`
  display: flex;
  padding: 20px;
  li {
    margin-left: 10px;
  }
`;

export default MainCard;
