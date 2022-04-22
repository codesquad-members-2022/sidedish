import styled, { css } from 'styled-components';
import { applyFlex } from '../../helper/utils';

export const CategoryBadge = styled.div`
  font-style: normal;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  padding: 8px 8px;
  width: 76px;
  height: 42px;
  background: #f8f7f7;
  text-align: center;
  border: 2px solid #1b1b1b;
  box-sizing: border-box;
  border-radius: 999px;
`;

export const TitleWrapper = styled.div`
  ${props => applyFlex(props)}
`;

export const StyledBestProduct = styled.div`
  margin-top: 56px;
`;

export const BestProductHeader = styled.div`
  padding: 0 80px;
  border-bottom: 1px solid #ebebeb;
`;

export const Title = styled.h1`
  margin-left: 16px;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 58px;
`;

export const TapBar = styled.ul`
  ${props => applyFlex(props)};
  margin-top: 24px;
`;

export const StyledLi = styled.li`
  margin-right: 32px;
  padding-bottom: 17px;
  font-style: normal;
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
  color: #bdbdbd;
  border-bottom: 1px solid white;
  ${props => {
    if (props.curTap === props['data-menu-id']) {
      return css`
        color: #000;
      `;
    }
  }}
`;

export const StyledDiv = styled.div`
  ${props => applyFlex(props)}
  margin-top: 34px;
  padding: 0 80px;
`;
