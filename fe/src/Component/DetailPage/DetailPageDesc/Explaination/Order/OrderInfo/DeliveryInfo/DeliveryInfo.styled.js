import styled, { css } from "styled-components";

const DeliveryInfoDiv = styled.div`
  ${({ theme: { colors, regularFonts } }) => css`
    ${regularFonts.xSmall};
    > * {
      display: flex;
      :not(:last-child) {
        margin-bottom: 8px;
      }
      > :nth-child(1) {
        width: 60px;
        margin-right: 16px;
        color: ${colors.grey2};
      }
    }

    padding-top: 17px;
    padding-bottom: 17px;
    border-top: 1px solid ${colors.grey4};
    border-bottom: 1px solid ${colors.grey4};
  `}
`;

export default DeliveryInfoDiv;
