import PropTypes from "prop-types";
import CardDiscountTypeDiv from "./CardDiscountType.styled";

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
