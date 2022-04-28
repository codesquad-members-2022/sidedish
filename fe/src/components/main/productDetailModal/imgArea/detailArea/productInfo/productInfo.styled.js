import styled from 'styled-components';
import { applyFlex } from '../../../../../../helper/utils';

export const StyledProductInfo = styled.div`
  padding-bottom: 24px;
  border-bottom: 1px solid #ebebeb;
`;
export const Title = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  margin-bottom: 16px;
`;

export const OriginPrice = styled.div`
  font-weight: 500;
  font-size: 18px;
  line-height: 24px;
  color: #bcbcbc;
`;

export const FinalPriceInfo = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })};
`;

export const FinalPrice = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  margin-top: 16px;
`;
