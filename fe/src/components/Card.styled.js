import styled, { css } from 'styled-components';
import { applyFlex } from '../helper/utils';

function styleColorToEvent({ eventName }) {
  if (eventName === '런칭특가') {
    return css`
      width: 76px;
      height: 30px;
      background: #ff8e14;
    `;
  }
  if (eventName === '이벤트특가') {
    return css`
      width: 87px;
      height: 30px;
      background: #6dd028;
    `;
  }
}

export const StyledImg = styled.img`
  width: 411px;
  height: 411px;
`;

export const CardWrapper = styled.div`
  margin-right: 24px;
`;

export const StyledH2 = styled.h2`
  font-style: normal;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  color: #3f3f3f;
  margin-top: 16px;
`;

export const StyledP = styled.p`
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  letter-spacing: -0.008em;
  color: #777777;
  margin: 8px 0;
`;

export const PriceWrapper = styled.div`
  ${props => applyFlex(props)}
  font-family: 'Noto Sans KR';
  font-style: normal;
`;

export const CutPrice = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  color: #1b1b1b;
  margin-right: 8px;
`;

export const Price = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  letter-spacing: -0.008em;
  text-decoration-line: line-through;
  color: #bcbcbc;
`;

export const StyledWrapper = styled.div`
  ${props => applyFlex(props)}
  margin-top:16px;
  color: #fff;
  font-weight: 500;
  font-size: 12px;
`;

export const Event = styled.div`
  ${props => applyFlex(props)}
  ${props => styleColorToEvent(props)}
  margin-right: 8px;
  border-radius: 999px;
`;
