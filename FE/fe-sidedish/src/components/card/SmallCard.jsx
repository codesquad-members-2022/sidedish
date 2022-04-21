import { formatPrice } from '../../utils';

const SmallCard = ({ name, image, price, discountedPrice }) => {

  const priceClassName = discountedPrice => `card__price ${discountedPrice ? '' : 'card__price-main'}`;

  return (
    <div className="card card--small">
      <img src={image} alt={name} className="card__image" />
      <h3 className="card__title">{name}</h3>
      <div className="card__prices">
        {discountedPrice && <span className="card__discounted-price card__price-main">{formatPrice(discountedPrice)}원</span>}
        <span className={priceClassName(discountedPrice)}>{formatPrice(price)}원</span>
      </div>
    </div>
  );
};

export default SmallCard;
