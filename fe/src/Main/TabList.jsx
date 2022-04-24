import styled from 'styled-components';

import { Tab } from './Tab';

import Colors from '@/Constants/Colors';

const StyledTabList = styled.ul`
  display: flex;
  border-bottom: 0.5px solid ${Colors.LIGHT_GREY};
  margin: 0 -80px;
  padding: 0 80px;

  .selected {
    border-color: ${Colors.BLACK};
  }
`;

export const TabList = ({ tabData, setClickedTabId, selectedTabId }) => {
  if (!tabData) {
    return null;
  }

  return (
    <StyledTabList>
      {tabData.map(tab => (
        <Tab
          key={tab.id}
          tabData={tab}
          setClickedTabId={setClickedTabId}
          TabClassName={tab.id === selectedTabId ? 'selected' : null}
        />
      ))}
    </StyledTabList>
  );
};
