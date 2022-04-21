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

  const { name, description, image, price, discountedPrice, badges } = dish;

  return (
    <Container>
      <ImageContainer>
        <Image src={image} alt={name} cardSize={`${cardSize}`} />
        <DeliveryBadge />
      </ImageContainer>
      <Title>{name}</Title>
      <Description>{description}</Description>
      <Prices discountedPrice={discountedPrice} price={price} />
      {badges?.length && <Badges badges={badges} />}
    </Container>
  );
};

Card.defaultProps = {
  size: 'medium',
};

export default Card;
