import PropTypes from "prop-types";
import { CardPriceDiv } from "./Card.styled";

const getPriceType = (price) => {
  return [String(price).slice(0, -3), ",", String(price).slice(-3), "원"].join(
    ""
  );
};

const CardPrice = ({ price, discountRate }) => {
  const originPrice = getPriceType(price);
  const discountPrice = getPriceType(price * (1 - discountRate / 100));

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
