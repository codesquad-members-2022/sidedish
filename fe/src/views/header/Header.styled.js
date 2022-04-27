import styled from 'styled-components';
import { applyFlex } from '../../helper/utils';

export const StyledH1 = styled.h1`
  font-family: 'Outfit', serif;
  font-style: normal;
  font-weight: 900;
  font-size: 40px;
  line-height: 50px;
  margin: 16px 40px 16px 0;
  cursor: pointer;
`;

export const StyledDiv = styled.div`
  margin-top: 30px;
`;

export const StyledInnerDiv = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
`;

export const StyledUl = styled.ul`
  ${({ flex }) => applyFlex({ flex })}
  margin-top: 30px;
  flex-grow: 1;
  margin-bottom: 10px;
`;

export const StyledHeader = styled.header`
  ${({ flex }) => applyFlex({ flex })}
  padding: 0 80px;
  border-bottom: solid 1px;
`;
