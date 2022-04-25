import * as S from './Card.style';
import { CARD_SIZE } from '../../constants/card';
import Badges from './Badges';
import DeliveryBadge from './DeliveryBadge';
import Prices from './Prices';

const Card = ({ cardSize, dish }) => {

  const { menuName, description, image, originalPrice, saledPrice, event } = dish;

  return (
    <S.Container>
      <S.ImageContainer>
        <S.Image src={image} alt={menuName} cardSize={`${cardSize}`} />
        <DeliveryBadge>
          <p>새벽 배송</p>
          <p>전국 택배</p>
        </DeliveryBadge>
      </S.ImageContainer>
      <S.Title>{menuName}</S.Title>
      <S.Description>{description}</S.Description>
      <Prices originalPrice={originalPrice} saledPrice={saledPrice} />
      {event.length && <Badges badges={event} />}
    </S.Container>
  );
};

Card.defaultProps = {
  cardSize: CARD_SIZE.MEDIUM,
};

export default Card;
