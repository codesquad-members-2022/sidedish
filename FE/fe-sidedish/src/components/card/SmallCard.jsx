import * as S from './Card.style';
import { CARD_SIZE } from '../../constants/card';
import Prices from './Prices';

const SmallCard = ({ menuName, image, originalPrice, saledPrice }) => {
  return (
    <S.Container>
      <S.Image src={image} alt={menuName} cardSize={CARD_SIZE.SMALL} />
      <S.Title cardSize={CARD_SIZE.SMALL}>{menuName}</S.Title>
      <Prices originalPrice={originalPrice} saledPrice={saledPrice} />
    </S.Container>
  );
};

export default SmallCard;
