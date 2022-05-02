import styled from 'styled-components';
import { applyFlex } from '../../../../helper/utils';

export const RecommendContainer = styled.div`
  margin-top: 48px;
`;

export const Header = styled.div`
  ${({ flex, justify }) => applyFlex({ flex, justify })};
`;

export const Main = styled.div`
  ${({ flex }) => applyFlex({ flex })}
  margin-top:50px;
  * {
    margin-right: 16px;
  }
  last-child {
    margin-bottom: 0;
  }
`;

export const Title = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
`;

export const SliderArea = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

export const Btn = styled.div`
  path {
    stroke: #1b1b1b;
  }
  margin: 0 20px;
  cursor: pointer;
`;

export const HeaderContent = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 24px;
`;
