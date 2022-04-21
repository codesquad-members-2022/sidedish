import {
  Container,
  Image,
  Title
} from './Card.style';
import Prices from './Prices';

const SmallCard = ({ name, image, price, discountedPrice }) => {

  const SMALL = 'small';

  return (
    <Container>
      <Image src={image} alt={name} cardSize="small" />
      <Title cardSize={SMALL}>{name}</Title>
      <Prices discountedPrice={discountedPrice} price={price} />
    </Container>
  );
};

export default SmallCard;
