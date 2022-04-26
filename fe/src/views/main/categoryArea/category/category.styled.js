import styled from 'styled-components';
import { applyFlex } from '../../../../helper/utils';

export const CategoryWrapper = styled.div`
  position: relative;
  margin-top: 56px;
  margin-bottom: 50px;
`;

export const CategoryTitle = styled.h3`
  font-size: 24px;
  line-height: 38px;
  padding: 0 80px;
`;

export const CategoryCardWrapper = styled.div`
  width: 1300px;
  position: relative;
  margin-top: 40px;
  padding: 0 56px 0 80px;
  ${props => applyFlex(props)}
`;

export const LeftButton = styled.div`
  position: absolute;
  left: 35px;
  top: 150px;

  path {
    stroke: #1b1b1b;
  }
`;

export const RightButton = styled.div`
  position: absolute;
  right: 35px;
  top: 150px;

  path {
    stroke: #1b1b1b;
  }
`;
