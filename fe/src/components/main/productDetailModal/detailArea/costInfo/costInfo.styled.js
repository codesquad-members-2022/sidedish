import styled from 'styled-components';
import { applyFlex } from '../../../../../helper/utils';

export const StyledCostInfo = styled.div`
  ${({ flex, justify }) => applyFlex({ flex, justify })}
  padding:26px 0px;
`;

export const CountArea = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

export const Btn = styled.div`
  margin: 0 20px;
  color: #777777;
  font-size: 40px;
  cursor: pointer;
`;

export const Count = styled.div`
  font-size: 30px;
`;

export const TotalCost = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

export const Label = styled.div`
  color: #777777;
  font-size: 20px;
`;

export const Content = styled.div`
  margin-left: 20px;
  font-size: 30px;
`;
