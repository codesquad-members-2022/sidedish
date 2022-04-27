import { useState, useEffect } from 'react';
import * as S from './ProductDetailModal.style';

import IconButton from './IconButton';
import CostItem from './CostItem';
import { formatPrice } from '../../utils';

const ProductOrder = ({ orderable, price }) => {
  const RIGHT = 'right';
  const MINUS = 'minus';
  const PLUS = 'plus';
  const SMALL = 'small';
  const BIG = 'big';
  const TOTAL_COST = '총 주문금액';
  const PRODUCT_COST = '상품금액';
  const DELIVERY_FEE = '배송비';
  const INITIAL_AMOUNT = 1;
  const INITIAL_DELIVERY_FEE = 2500;
  const FREE_DELIVERY_FEE = 0;
  const ORDER_PRICE_FOR_FREE_DELIVERY = 40000;

  const [amount, setAmount] = useState(INITIAL_AMOUNT);
  const [deliveryFee, setDeliveryFee] = useState(INITIAL_DELIVERY_FEE);

  const plusAmount = () => setAmount(amount + 1);

  const minusAmount = () => {
    if (amount <= INITIAL_AMOUNT) return;
    setAmount(amount - 1);
  };

  const updateDelveryFee = () => {
    if (amount * price > ORDER_PRICE_FOR_FREE_DELIVERY) {
      setDeliveryFee(FREE_DELIVERY_FEE);
      return;
    }
    setDeliveryFee(INITIAL_DELIVERY_FEE);
  };

  useEffect(() => updateDelveryFee());

  return (
    <S.PriceOrderContainer direction={RIGHT}>
      <S.TotalAmount>
        <IconButton name={MINUS} handleClick={minusAmount} />
        {amount}
        <IconButton name={PLUS} handleClick={plusAmount} />
      </S.TotalAmount>
      <S.TotalCostList>
        <CostItem size={BIG} name={TOTAL_COST} cost={formatPrice(price * amount + deliveryFee)} />
        <CostItem size={SMALL} name={PRODUCT_COST} cost={formatPrice(price * amount)} />
        <CostItem size={SMALL} name={DELIVERY_FEE} cost={formatPrice(deliveryFee)} />
      </S.TotalCostList>
      <S.SubmitButton orderable={orderable}>{orderable ? '주문하기' : '품절'}</S.SubmitButton>
    </S.PriceOrderContainer>
  );
};

export default ProductOrder;
