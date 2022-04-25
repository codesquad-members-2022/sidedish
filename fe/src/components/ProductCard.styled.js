import styled from 'styled-components';
import { applyFlex } from '../helper/utils';

function applyEventStyleByEventName(eventName) {
  if (eventName === '런칭특가') {
    return `
      width: 76px;
      height: 30px;
      background: #ff8e14;
    `;
  }
  if (eventName === '이벤트특가') {
    return `
      width: 87px;
      height: 30px;
      background: #6dd028;
    `;
  }
}

function applyImgStyleByCardSize(size) {
  if (size === 'large') {
    return `
      width: 411px;
      height: 411px;
    `;
  }
  if (size === 'medium') {
    return `
      width: 302px;
      height: 302px;
    `;
  }
  if (size === 'small') {
    return `
      width: 160px;
      height: 160px;
    `;
  }
}

function applyTitleStyleByCardSize(size) {
  if (size === 'small') {
    return `
      font-weight: 400;
      font-size: 14px;
      line-height: 24px;
      margin-top: 8px;
      width: 160px;
    `;
  }
  return `
    font-weight: 500;
    font-size: 16px;
    line-height: 26px;
    margin-top: 16px;
  `;
}

export const StyledImg = styled.img`
  ${({ size }) => applyImgStyleByCardSize(size)}
`;

export const StyledH2 = styled.h2`
  font-style: normal;
  ${({ size }) => applyTitleStyleByCardSize(size)}
  color: #3f3f3f;
`;

export const StyledP = styled.p`
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  color: #777777;
  margin: 8px 0;
`;

export const PriceWrapper = styled.div`
  ${({ flex, align }) => applyFlex({ flex, align })}
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
  ${({ flex }) => applyFlex({ flex })}
  margin-top:16px;
  color: #fff;
  font-weight: 500;
  font-size: 12px;
`;

export const Event = styled.div`
  ${({ flex, justify, align }) => applyFlex({ flex, justify, align })}
  ${({ eventName }) => applyEventStyleByEventName(eventName)}
  margin-right: 8px;
  border-radius: 999px;
`;

export const CardWrapper = styled.div`
  position: relative;
  margin-right: 24px;
  cursor: pointer;
`;

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
