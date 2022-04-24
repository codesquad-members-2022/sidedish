import styled from 'styled-components';

import { Tab } from './Tab';

import Colors from '@/Constants/Colors';

const StyledTabList = styled.ul`
  display: flex;
  border-bottom: 0.5px solid ${Colors.LIGHT_GREY};
  margin: 0 -80px;
  padding: 0 80px;
`;

export const TabList = ({ tabData, onClickTab }) => {
  if (!tabData) {
    return null;
  }

  return (
    <StyledTabList>
      {tabData.map(tab => (
        <Tab key={tab.id} tabData={tab} onClickTab={onClickTab} />
      ))}
    </StyledTabList>
  );
};
