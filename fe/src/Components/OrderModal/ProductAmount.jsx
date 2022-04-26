import styled from 'styled-components';

import { Colors } from '@/Constants';

const ProductAmountWrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 440px;
  margin-top: 26px;
`;

const AmountButton = styled.button`
  color: ${Colors.GREY};
  width: 24px;
  height: 24px;

  i {
    font-size: 20px;
  }
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

const Icon = styled.i`
  color: ${Colors.GREY};
`;

export const ProductAmount = () => {
  return (
    <ProductAmountWrapper>
      <TotalAmount>
        <AmountButton>
          <Icon className={'ic-plus'} aria-label={'상품 추가'} />
        </AmountButton>
        <CurrentAmount>0</CurrentAmount>
        <AmountButton>
          <Icon className={'ic-minus'} aria-label={'상품 '} />
        </AmountButton>
      </TotalAmount>

      <TotalCost>최종 가격</TotalCost>
    </ProductAmountWrapper>
  );
};
