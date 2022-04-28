import styled from 'styled-components';
import { applyFlex } from '../../../../../helper/utils';

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

const StyledCostInfo = styled.div`
  ${({ flex, justify }) => applyFlex({ flex, justify })}
  padding:26px 0px;
`;
const CountArea = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

const Btn = styled.div`
  margin: 0 20px;
  color: #777777;
  font-size: 40px;
`;

const Count = styled.div`
  font-size: 30px;
`;

const TotalCost = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

const Label = styled.div`
  color: #777777;
  font-size: 20px;
`;

const Content = styled.div`
  margin-left: 20px;
  font-size: 30px;
`;
