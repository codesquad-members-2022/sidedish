import PropTypes from "prop-types";

const getPriceType = (price) => {
  return [String(price).slice(0, -3), ",", String(price).slice(-3), "원"].join(
    ""
  );
};

const EventCardPrice = ({ price, discountType, discountRate }) => {
  const originPrice = getPriceType(price);
  const discountPrice = getPriceType(price * (1 - discountRate / 100));

  return !discountType ? (
    <div className="price">
      <span>{originPrice}</span>
    </div>
  ) : (
    <>
      <div className="price">
        <span>{discountPrice}</span>
        <span className="originPrice">{originPrice}</span>
      </div>
      <div className="discountType">{discountType}</div>
    </>
  );
};

EventCardPrice.propTypes = {
  price: PropTypes.number.isRequired,
  discountType: PropTypes.string.isRequired,
  discountRate: PropTypes.number.isRequired,
}.isRequired;

export default EventCardPrice;
