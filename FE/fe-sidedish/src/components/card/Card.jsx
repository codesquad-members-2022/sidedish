import '../../styles/components/card.scss';

const Card = ({ size, dish }) => {

  const { name, description, image, price, discountedPrice, badges } = dish;

  return (
    <div className={`card ${size === 'large' ? 'card--large' : ''}`}>
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
        {discountedPrice && <span className="card__discounted-price card__price-main">{discountedPrice}원</span>}
        <span className={`card__price ${discountedPrice ? '' : 'card__price-main'}`}>{price}원</span>
      </div>
      {badges?.length && (
        <div className="card__badges">
          {badges.map((badge, index) => <span className={`card__badge ${badge === "이벤트특가" ? 'card__badge-event' : 'card__badge-launch'}`} key={index}>{badge}</span>)}
        </div>
      )}
    </div>
  );
};

Card.defaultProps = {
  size: 'medium',
};

export default Card;
