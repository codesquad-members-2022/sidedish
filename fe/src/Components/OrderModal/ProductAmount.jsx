import { useState } from 'react';
import styled from 'styled-components';

import { IconFonts } from '@/Constants';

import { AmountButton } from '@/Components/Button';

const ProductAmountWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 440px;
  margin-top: 26px;
`;

const TotalAmount = styled.div`
  display: flex;
  width: 90px;
  justify-content: space-between;
  align-items: center;
  margin-left: 6px;
`;

const TotalCost = styled.span`
  display: inline-block;
`;

const CurrentAmount = styled.span``;

export const ProductAmount = ({ priceData }) => {
  const [totalCost, setTotalCost] = useState(priceData);
  const [currentAmount, setCurrentAmount] = useState(1);

  // TODO: 상품 닫고 다시 클릭했을때 수량 가격 초기화
  const onClickPlus = () => {
    setCurrentAmount(currentAmount + 1);
    setTotalCost((currentAmount + 1) * priceData);
  };

  const onClickMinus = () => {
    if (currentAmount <= 0) {
      return;
    }
    setCurrentAmount(currentAmount - 1);
    setTotalCost((currentAmount - 1) * priceData);
  };

  return (
    <ProductAmountWrapper>
      <TotalAmount>
        <AmountButton
          iconSrc={IconFonts.PLUS}
          onClickIcon={onClickPlus}
          label={'상품 추가'}
        />

        <CurrentAmount>{currentAmount}</CurrentAmount>
        <AmountButton
          iconSrc={IconFonts.MINUS}
          onClickIcon={onClickMinus}
          label={'상품 추감'}
        />
      </TotalAmount>

      <TotalCost>{totalCost} 원</TotalCost>
    </ProductAmountWrapper>
  );
};
