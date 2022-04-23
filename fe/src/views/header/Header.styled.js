import styled from 'styled-components';
import { applyFlex } from '../../helper/utils';

export const GnbMenu = styled.li`
  margin-right: 24px;
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
`;

export const GnbSubMenuWrapper = styled.ul`
  margin-top: 4px;
`;

export const GnbSubMenu = styled.li`
  font-size: 14px;
  line-height: 24px;
`;

export const StyledSvgWrapper = styled.div`
  margin-left: 24px;
  width: 24px;
`;

export const StyledHeader = styled.header`
  ${props => applyFlex(props)}
  padding: 0 80px;
  border-bottom: solid 1px;
`;

export const StyledH1 = styled.h1`
  font-family: 'Outfit', serif;
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  margin: 16px 40px 16px 0;
`;

export const StyledDiv = styled.div`
  ${props => applyFlex(props)}
  margin-top: 30px;
`;

export const StyledInnerDiv = styled.div`
  ${props => applyFlex(props)}
`;

export const StyledUl = styled.ul`
  ${props => applyFlex(props)}
  margin-top: 30px;
  flex-grow: 1;
`;
