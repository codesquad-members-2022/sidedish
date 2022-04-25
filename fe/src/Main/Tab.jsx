import styled from 'styled-components';

import Colors from '@/Constants/Colors';

const StyledList = styled.li`
  cursor: pointer;
  padding: 16px;
  border-bottom: 1.5px solid transparent;

  :hover {
    border-color: ${Colors.BLACK};
  }
`;

function checkSelected(tabClassName) {
  if (tabClassName) {
    return 'selected';
  }
  return null;
}

export const Tab = ({ tabData, clickTab, TabClassName }) => {
  const tabId = tabData.id;

  const onClickTab = event => {
    clickTab(tabId);
  };

  return (
    <StyledList
      key={tabData.id}
      onClick={onClickTab}
      className={checkSelected(TabClassName)}
    >
      {tabData.title}
    </StyledList>
  );
};
