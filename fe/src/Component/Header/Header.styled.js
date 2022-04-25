import styled, { css } from "styled-components";

const DEFAULT_PADDING_BOTTOM = 30;

const StyledHeader = styled.header`
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #1b1b1b;
  ${({ isOpen, maxSubMenuDataSize }) =>
    css`
      padding: 30px 80px
        ${isOpen && `${24 * maxSubMenuDataSize + DEFAULT_PADDING_BOTTOM}px`};
    `}
`;

export default StyledHeader;
