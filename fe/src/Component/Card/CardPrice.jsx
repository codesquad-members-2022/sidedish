import PropTypes from "prop-types";
import getPriceType from "Util/util";
import { CardPriceDiv } from "./Card.styled";

const CardPrice = ({ price, discountRate }) => {
  const originPrice = getPriceType(price);
  const discountPrice = getPriceType(price, discountRate);

  return (
    <CardPriceDiv discountRate={discountRate}>
      {!!discountRate && <span>{discountPrice}</span>}
      <span>{originPrice}</span>
    </CardPriceDiv>
  );
};

CardPrice.propTypes = {
  price: PropTypes.number.isRequired,
  discountRate: PropTypes.number.isRequired,
}.isRequired;

export default CardPrice;
