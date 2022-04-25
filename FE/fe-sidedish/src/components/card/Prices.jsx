import * as S from './Card.style';
import { formatPrice } from '../../utils';

const Prices = ({ originalPrice, saledPrice }) => {

  return (
    <S.PriceContainer>
      {saledPrice ? <S.MainPrice>{formatPrice(saledPrice)}원</S.MainPrice> : ''}
      {saledPrice ? <S.SubPrice>{formatPrice(originalPrice)}원</S.SubPrice> : <S.MainPrice>{formatPrice(originalPrice)}원</S.MainPrice>}
    </S.PriceContainer>
  )
}

export default Prices;
