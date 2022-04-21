import { MainPrice, PriceContainer, SubPrice } from './Card.style';
import { formatPrice } from '../../utils';

const Prices = ({ discountedPrice, price }) => {
  return (
    <PriceContainer>
      {discountedPrice && <MainPrice>{formatPrice(discountedPrice)}원</MainPrice>}
      {discountedPrice ? <SubPrice>{formatPrice(price)}원</SubPrice> : <MainPrice>{formatPrice(price)}원</MainPrice>}
    </PriceContainer>
  )
}

export default Prices;
