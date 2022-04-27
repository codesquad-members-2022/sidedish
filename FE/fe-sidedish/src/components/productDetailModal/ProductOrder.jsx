import { useState, useEffect } from 'react';
import * as S from './ProductDetailModal.style';

import {
  AMOUNT_UNIT,
  DIRECTION,
  ICON_NAME,
  COST_LABEL,
  COST_ITEM_SIZE,
  DELIVERY,
} from '../../constants/productDetailModal';
import { formatPrice } from '../../utils';

import IconButton from './IconButton';
import CostItem from './CostItem';

const ProductOrder = ({ orderable, price }) => {
  const [amount, setAmount] = useState(AMOUNT_UNIT);
  const [deliveryFee, setDeliveryFee] = useState(DELIVERY.BASIC_FEE);

  const plusAmount = () => setAmount(amount + AMOUNT_UNIT);

  const minusAmount = () => {
    if (amount <= AMOUNT_UNIT) return;
    setAmount(amount - AMOUNT_UNIT);
  };

  const updateDelveryFee = () => {
    if (amount * price > DELIVERY.ORDER_PRICE_FOR_FREE) {
      setDeliveryFee(DELIVERY.FREE_FEE);
      return;
    }
    setDeliveryFee(DELIVERY.BASIC_FEE);
  };

  useEffect(() => updateDelveryFee());

  return (
    <S.PriceOrderContainer direction={DIRECTION.RIGHT}>
      <S.TotalAmount>
        <IconButton name={ICON_NAME.MINUS} handleClick={minusAmount} />
        {amount}
        <IconButton name={ICON_NAME.PLUS} handleClick={plusAmount} />
      </S.TotalAmount>
      <S.TotalCostList>
        <CostItem
          size={COST_ITEM_SIZE.BIG}
          name={COST_LABEL.TOTAL}
          cost={formatPrice(price * amount + deliveryFee)}
        />
        <CostItem
          size={COST_ITEM_SIZE.SMALL}
          name={COST_LABEL.PRODUCT}
          cost={formatPrice(price * amount)}
        />
        <CostItem
          size={COST_ITEM_SIZE.SMALL}
          name={COST_LABEL.DELIVERY_FEE}
          cost={formatPrice(deliveryFee)}
        />
      </S.TotalCostList>
      <S.SubmitButton orderable={orderable}>{orderable ? '주문하기' : '품절'}</S.SubmitButton>
    </S.PriceOrderContainer>
  );
};

export default ProductOrder;
