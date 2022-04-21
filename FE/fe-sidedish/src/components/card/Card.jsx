import '../../styles/components/card.scss';
import { formatPrice } from '../../utils';

const Card = ({ size, dish }) => {

  const { name, description, image, price, discountedPrice, badges } = dish;

  const EVENT = "이벤트특가";
  const LARGE = "large";

  const cardClassName = size => `card ${size === LARGE ? 'card--large' : ''}`;
  const badgeClassName = badge => `card__badge ${badge === EVENT ? 'card__badge-event' : 'card__badge-launch'}`;
  const priceClassName = discountedPrice => `card__price ${discountedPrice ? '' : 'card__price-main'}`;

  return (
    <div className={cardClassName(size)}>
      <div className="card__image-container">
        <img src={image} alt={name} className="card__image" />
        <div className="card__image-background">
          <div className="card__image-badge">
            <p>새벽 배송</p>
            <p>전국 택배</p>
          </div>
        </div>
      </div>
      <h3 className="card__title">{name}</h3>
      <p className="card__description">{description}</p>
      <div className="card__prices">
        {discountedPrice && <span className="card__discounted-price card__price-main">{formatPrice(discountedPrice)}원</span>}
        <span className={priceClassName(discountedPrice)}>{formatPrice(price)}원</span>
      </div>
      {badges?.length && (
        <div className="card__badges">
          {badges.map((badge, index) => <span className={badgeClassName(badge)} key={index}>{badge}</span>)}
        </div>
      )}
    </div>
  );
};

Card.defaultProps = {
  size: 'medium',
};

export default Card;
