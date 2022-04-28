import styled from 'styled-components';
import { applyFlex } from '../../../../../helper/utils';

export const StyledDeliveryInfo = styled.div`
  padding: 17px 0;
  border-bottom: 1px solid #ebebeb;
`;

export const StyledWrapper = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  margin-bottom:8px;
`;

export const Label = styled.div`
  width: 60px;
  height: 18px;
  margin-right: 16px;
  color: #777777;
`;

export const Content = styled.div`
  font-weight: 400;
  font-size: 16px;
  line-height: 18px;
`;
