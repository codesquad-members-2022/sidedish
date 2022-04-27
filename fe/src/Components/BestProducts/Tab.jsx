import styled from 'styled-components';

import { Colors } from '@/Constants';

const StyledList = styled.li`
  cursor: pointer;
  padding: 16px;
  border-bottom: 1.5px solid transparent;

  :hover {
    border-color: ${Colors.BLACK};
  }
`;

const checkSelected = tabClassName => {
  if (tabClassName) {
    return 'selected';
  }
  return null;
};

export const Tab = ({ tabData, onClickTab, TabClassName }) => {
  const tabId = tabData.id;

  return (
    <StyledList
      key={tabData.id}
      onClick={onClickTab(tabId)}
      className={checkSelected(TabClassName)}
    >
      {tabData.title}
    </StyledList>
  );
};
