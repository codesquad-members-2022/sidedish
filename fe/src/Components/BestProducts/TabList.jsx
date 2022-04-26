import styled from 'styled-components';

import { Colors } from '@/Constants';

import { Tab } from './Tab';

const StyledTabList = styled.ul`
  display: flex;
  border-bottom: 0.5px solid ${Colors.LIGHT_GREY};
  margin: 0 -80px;
  padding: 0 80px;

  .selected {
    border-color: ${Colors.BLACK};
  }
`;

export const TabList = ({ tabData, onClickTab, selectedTabId }) => {
  if (!tabData) {
    return null;
  }

  return (
    <StyledTabList>
      {tabData.map(BestProductTab => (
        <Tab
          key={BestProductTab.id}
          tabData={BestProductTab}
          onClickTab={onClickTab}
          TabClassName={BestProductTab.id === selectedTabId ? 'selected' : null}
        />
      ))}
    </StyledTabList>
  );
};
