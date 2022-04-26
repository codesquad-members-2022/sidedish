import styled, {css} from 'styled-components';

const TabItem = styled.li`
  ${({tabState, title}) => {
    return (
      tabState === title &&
      css`
        border-bottom: 1px solid;
      `
    );
  }}
`;

export {TabItem};
