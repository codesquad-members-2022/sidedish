import {
  Container,
  Image,
  Title
} from './Card.style';
import Prices from './Prices';

const SmallCard = ({ menuName, image, originalPrice, saledPrice }) => {

  const SMALL = 'small';

  return (
    <Container>
      <Image src={image} alt={menuName} cardSize={SMALL} />
      <Title cardSize={SMALL}>{menuName}</Title>
      <Prices originalPrice={originalPrice} saledPrice={saledPrice} />
    </Container>
  );
};

export default SmallCard;
