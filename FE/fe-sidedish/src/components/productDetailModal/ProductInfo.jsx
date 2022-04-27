import * as S from './ProductDetailModal.style';
import { formatPrice } from '../../utils';
import Badges from './Badges';

const ProductInfo = ({ menuName, originalPrice, discountedPrice, point, event }) => {
  const RIGHT = 'right';
  return (
    <S.FloatContainer direction={RIGHT}>
      <S.ProductTitle>{menuName}</S.ProductTitle>
      <S.ProductPrice>
        {discountedPrice ? (
          <>
            <S.OriginalPrice>{formatPrice(originalPrice)}원</S.OriginalPrice>
            <Badges badges={event} />
            <S.SaledPrice>{formatPrice(discountedPrice)}원</S.SaledPrice>
          </>
        ) : (
          <>
            <S.SaledPrice>{formatPrice(originalPrice)}원</S.SaledPrice>
          </>
        )}
      </S.ProductPrice>
      <S.ProductInfoList>
        <li>
          <span>적립금</span>
          <span>{formatPrice(point)}원</span>
        </li>
        <li>
          <span>배송정보</span>
          <span>서울 경기 새벽 배송, 전국 택배 배송</span>
        </li>
        <li>
          <span>배송비</span>
          <span>2,500원 (40,000원 이상 구매 시 무료)</span>
        </li>
      </S.ProductInfoList>
    </S.FloatContainer>
  );
};

export default ProductInfo;
