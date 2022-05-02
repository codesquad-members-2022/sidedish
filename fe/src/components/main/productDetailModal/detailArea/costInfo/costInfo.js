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
import { getWonTemplate } from '../../../../../helper/utils';

export function CostInfo({ props, count, setCount, calculateTotalCost }) {
  function handleMinusClick() {
    setCount(count - 1 || 1);
  }

  function handlePlusClick() {
    if (props.stock === count) {
      return;
    }
    setCount(count + 1);
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
          <Content> {`${getWonTemplate(calculateTotalCost())}`}</Content>
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
    return (
      <StyledStockOverFlow> {`재고가 ${stock}개 있는 상품입니다. 더이상 수량을 늘릴 수 없어요 ^^`}</StyledStockOverFlow>
    );
  }
  return '';
}
