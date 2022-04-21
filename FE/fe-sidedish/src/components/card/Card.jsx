import { formatPrice } from '../../utils';
import {
  Container,
  Image,
  Description,
  ImageBadge,
  ImageContainer,
  Price,
  Prices,
  MainPrice,
  Title,
  Badges,
  Badge,
  ImageBackground
} from './Card.style';

const Card = ({ size, dish }) => {

  const { name, description, image, price, discountedPrice, badges } = dish;

  return (
    <Container>
      <ImageContainer>
        <Image src={image} alt={name} size={`${size}`} />
        <ImageBackground size={`${size}`}>
          <ImageBadge>
            <p>새벽 배송</p>
            <p>전국 택배</p>
          </ImageBadge>
        </ImageBackground>
      </ImageContainer>
      <Title>{name}</Title>
      <Description>{description}</Description>
      <Prices>
        {discountedPrice && <MainPrice>{formatPrice(discountedPrice)}원</MainPrice>}
        {discountedPrice ? <Price>{formatPrice(price)}원</Price> : <MainPrice>{formatPrice(price)}원</MainPrice>}
      </Prices>
      {badges?.length && (
        <Badges>
          {badges.map((badge, index) => <Badge key={index} type={`${badge}`}>{badge}</Badge>)}
        </Badges>
      )}
    </Container>
  );
};

Card.defaultProps = {
  size: 'medium',
};

export default Card;
