import { Btn, Content, Count, CountArea, Label, StyledCostInfo, TotalCost } from './costInfo.styled';

export function CostInfo({ props }) {
  return (
    <StyledCostInfo flex justify="space-between">
      <CountArea flex align="center">
        <Btn>-</Btn>
        <Count>1</Count>
        <Btn>+</Btn>
      </CountArea>
      <TotalCost flex align="center">
        <Label>총 주문 금액</Label>
        <Content> {props.disCountPrice}</Content>
      </TotalCost>
    </StyledCostInfo>
  );
}
