import styled from 'styled-components';

import Colors from '@/Constants/Colors';

const StyledList = styled.li`
  cursor: pointer;
  padding: 16px;
  border-bottom: 1.5px solid transparent;

  .selected {
    border-color: ${Colors.BLACK};
  }

  :hover {
    border-color: ${Colors.BLACK};
  }
`;

export const Tab = ({ tabData, onClickTab }) => {
  return (
    <StyledList key={tabData.id} onClick={onClickTab}>
      {tabData.title}
    </StyledList>
  );
};
