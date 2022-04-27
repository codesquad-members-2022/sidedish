import styled, { css } from "styled-components";
import PropTypes from "prop-types";

const CardDiscountTypeDiv = styled.div`
  ${({ discountType, theme: { colors } }) => {
    switch (discountType) {
      case "런칭특가":
        return css`
          background-color: ${colors.orange};
        `;
      case "이벤트특가":
        return css`
          background-color: ${colors.green};
        `;
      default:
        return null;
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
