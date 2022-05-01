import styled, { css } from "styled-components";

const OrderDiv = styled.div`
  width: 440px;

  .name {
    ${({ theme: { boldFonts } }) => css`
      ${boldFonts.large}
    `}
  }
`;

export default OrderDiv;
