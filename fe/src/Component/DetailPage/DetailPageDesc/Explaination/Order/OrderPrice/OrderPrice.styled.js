import styled, { css } from "styled-components";

const OrderPriceDiv = styled.div`
  height: 70px;
`;

const OriginPriceDiv = styled.div`
  margin-top: 16px;

  ${({ discountType, theme: { boldFonts, colors } }) => {
    return css`
      ${boldFonts.large}
      color:${colors.black};

      ${discountType &&
      css`
        ${boldFonts.small}
        color:${colors.grey3};
        text-decoration: line-through;
      `}
    `;
  }}
`;

const DiscountTypeDiv = styled.div`
  ${({ theme: { colors, boldFonts } }) =>
    css`
      ${boldFonts.xSmall};
      color: ${colors.white};
    `};

  ${({ discountType, theme: { colors } }) => {
    switch (discountType) {
      case "런칭 특가":
        return css`
          background-color: ${colors.orange};
        `;
      case "이벤트 특가":
        return css`
          background-color: ${colors.green};
        `;
      default:
        return css`
          background-color: ${colors.grey3};
        `;
    }
  }}
  padding: 6px 16px;
  border-radius: 100px;
  display: inline-block;

  margin-right: 8px;
  margin-top: 8px;
`;

export { OrderPriceDiv, OriginPriceDiv, DiscountTypeDiv };
