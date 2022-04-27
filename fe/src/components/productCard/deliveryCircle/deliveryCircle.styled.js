import styled from 'styled-components';
import { applyFlex } from '../../../helper/utils';

export const StyledCircle = styled.div`
  ${({ flex, justify, align, direction }) => applyFlex({ flex, justify, align, direction })};
  position: absolute;
  width: 120px;
  height: 120px;
  top: 5%;
  right: 10%;

  background: rgba(248, 247, 247, 0.8);

  border: 1px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 50%;
  p:last-child {
    border: none;
  }
`;

export const DeliveryInfo = styled.p`
  padding: 10px;
  border-bottom: 1px solid black;
`;
