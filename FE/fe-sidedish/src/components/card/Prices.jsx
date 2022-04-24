import { MainPrice, PriceContainer, SubPrice } from './Card.style';
import { formatPrice } from '../../utils';

const Prices = ({ originalPrice, saledPrice }) => {

  return (
    <PriceContainer>
      {saledPrice ? <MainPrice>{formatPrice(saledPrice)}원</MainPrice> : ''}
      {saledPrice ? <SubPrice>{formatPrice(originalPrice)}원</SubPrice> : <MainPrice>{formatPrice(originalPrice)}원</MainPrice>}
    </PriceContainer>
  )
}

export default Prices;
