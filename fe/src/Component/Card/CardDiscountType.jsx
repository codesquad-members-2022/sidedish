import styled, { css } from "styled-components";
import PropTypes from "prop-types";

const CardDiscountTypeDiv = styled.div`
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

  ${({ theme: { boldFonts, colors } }) => css`
    ${boldFonts.xSmall};
    color: ${colors.white};
  `}

  margin-top: 16px;
  padding: 6px 16px;
  border-radius: 100px;
  display: inline-block;
`;

const CardDiscountType = ({ discountType }) => {
  return (
    discountType && (
      <CardDiscountTypeDiv discountType={discountType}>
        {discountType}
      </CardDiscountTypeDiv>
    )
  );
};

CardDiscountType.propTypes = {
  eventCards: PropTypes.string.isRequired,
}.isRequired;

export default CardDiscountType;
