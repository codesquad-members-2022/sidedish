import { Content, Label, StyledDeliveryInfo, StyledWrapper } from './deliveryInfo.styled';

export function DeliveryInfo({ props }) {
  return (
    <StyledDeliveryInfo>
      <StyledWrapper flex>
        <Label>적립금</Label>
        <Content>{`${props.accumulatedAmount.toLocaleString()}원`}</Content>
      </StyledWrapper>
      <StyledWrapper flex>
        <Label>배송정보</Label>
        <Content>{props.shippingInfo}</Content>
      </StyledWrapper>
      <StyledWrapper flex>
        <Label>배송비</Label>
        <Content>{`${props.shippingFee.toLocaleString()}원 (${props.exemptionCondition.toLocaleString()}원 이상 구매시 무료)`}</Content>
      </StyledWrapper>
    </StyledDeliveryInfo>
  );
}
