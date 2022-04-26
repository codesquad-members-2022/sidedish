import styled from 'styled-components';

export const TabMenuLi = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  font-style: normal;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  color: #bdbdbd;
  border-bottom: 1px solid white;
  cursor: pointer;
  ${props => {
    if (props.curTab === props['data-menu-id']) {
      return `
        color: #000;
      `;
    }
  }}
`;
