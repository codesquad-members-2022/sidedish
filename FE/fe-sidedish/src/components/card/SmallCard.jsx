import * as S from './Card.style';
import Prices from './Prices';

const SmallCard = ({ menuName, image, originalPrice, saledPrice }) => {

  const SMALL = 'small';

  return (
    <S.Container>
      <S.Image src={image} alt={menuName} cardSize={SMALL} />
      <S.Title cardSize={SMALL}>{menuName}</S.Title>
      <Prices originalPrice={originalPrice} saledPrice={saledPrice} />
    </S.Container>
  );
};

export default SmallCard;
