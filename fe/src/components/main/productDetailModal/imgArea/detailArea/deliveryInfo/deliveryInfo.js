import styled from 'styled-components';
import { applyFlex } from '../../../../../../helper/utils';

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

const StyledDeliveryInfo = styled.div`
  padding: 17px 0;
  border-bottom: 1px solid #ebebeb;
`;

const StyledWrapper = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  margin-bottom:8px;
`;

const Label = styled.div`
  width: 60px;
  height: 18px;
  margin-right: 16px;
  color: #777777;
`;

const Content = styled.div`
  font-weight: 400;
  font-size: 16px;
  line-height: 18px;
`;
