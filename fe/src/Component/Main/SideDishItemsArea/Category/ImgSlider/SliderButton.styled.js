import styled, { css } from "styled-components";

const BUTTON_POSITION = css`
  ${({ theme: { padding } }) => `${parseInt(padding.large, 10) / 2}`}
`;

const Button = styled.button`
  position: absolute;
  ${({ isClickable, theme: { colors } }) =>
    css`
      stroke: ${isClickable ? colors.black : colors.grey3};
      cursor: ${isClickable ? "pointer" : "default"};
    `};

  &.left {
    top: 50%;
    left: ${BUTTON_POSITION}px;
  }

  &.right {
    top: 50%;
    right: ${BUTTON_POSITION}px;
  }
`;

export default Button;
