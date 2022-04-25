import styled, { css } from "styled-components";

const DEFAULT_SUBMENU_LI_HEIGHT = 24;

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #1b1b1b;
  ${({ isOpen, maxSubMenuDataSize, theme: { padding } }) =>
    css`
      padding: ${padding.regular} ${padding.large}
        ${isOpen &&
        `${
          DEFAULT_SUBMENU_LI_HEIGHT * maxSubMenuDataSize +
          parseInt(padding.regular, 10)
        }px`};
    `}
`;

export default StyledHeader;
