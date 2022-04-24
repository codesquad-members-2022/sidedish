import {
  Container,
  ImageContainer,
  Image,
  Title,
  Description,
} from './Card.style';
import Badges from './Badges';
import DeliveryBadge from './DeliveryBadge';
import Prices from './Prices';

const Card = ({ cardSize, dish }) => {

  const { menuName, description, image, originalPrice, saledPrice, event } = dish;

  return (
    <Container>
      <ImageContainer>
        <Image src={image} alt={menuName} cardSize={`${cardSize}`} />
        <DeliveryBadge />
      </ImageContainer>
      <Title>{menuName}</Title>
      <Description>{description}</Description>
      <Prices originalPrice={originalPrice} saledPrice={saledPrice} />
      {event.length && <Badges badges={event} />}
    </Container>
  );
};

Card.defaultProps = {
  size: 'medium',
};

export default Card;
