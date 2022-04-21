import { formatPrice } from '../../utils';
import {
  Container,
  Image,
  Price,
  Prices,
  MainPrice,
  Title
} from './Card.style';

const SmallCard = ({ name, image, price, discountedPrice }) => {

  return (
    <Container>
      <Image src={image} alt={name} size="small" />
      <Title size="small">{name}</Title>
      <Prices>
        {discountedPrice && <MainPrice>{formatPrice(discountedPrice)}원</MainPrice>}
        {discountedPrice ? <Price>{formatPrice(price)}원</Price> : <MainPrice>{formatPrice(price)}원</MainPrice>}
      </Prices>
    </Container>
  );
};

export default SmallCard;
