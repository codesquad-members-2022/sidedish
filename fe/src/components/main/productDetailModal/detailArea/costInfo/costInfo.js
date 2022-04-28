import { useState } from 'react';
import {
  Btn,
  Content,
  Count,
  CountArea,
  Label,
  StyledCostInfo,
  StyledStockOverFlow,
  TotalCost,
} from './costInfo.styled';

export function CostInfo({ props }) {
  const [count, setState] = useState(1);
  function handleMinusClick() {
    setState(count - 1 || 1);
  }

  function handlePlusClick() {
    if (props.stock === count) {
      return;
    }
    setState(count + 1);
  }

  function calculateTotalCost() {
    const price = props.disCountPrice || props.price;
    const totalPrice = price * count >= props.exemptionCondition ? price * count : price * count + props.shippingFee;
    return totalPrice;
  }

  return (
    <>
      <StyledCostInfo stock={props.stock} flex justify="space-between">
        <CountArea flex align="center">
          <Btn onClick={handleMinusClick}>-</Btn>
          <Count>{count}</Count>
          <Btn onClick={handlePlusClick}>+</Btn>
        </CountArea>
        <TotalCost flex align="center">
          <Label>총 주문 금액</Label>
          <Content> {`${calculateTotalCost().toLocaleString()}원`}</Content>
        </TotalCost>
      </StyledCostInfo>
      <StockOverFlow count={count} stock={props.stock}></StockOverFlow>
    </>
  );
}

function StockOverFlow({ count, stock }) {
  if (stock === 0) {
    return <StyledStockOverFlow>재고가 없는 상품입니다.</StyledStockOverFlow>;
  }
  if (count === stock) {
    return <StyledStockOverFlow> {`재고가 ${stock}개 있는 상품입니다. 추가 주문은 불가능합니다.`}</StyledStockOverFlow>;
  }
  return '';
}
