import styled from 'styled-components';
import { applyFlex } from '../helper/utils';

export function Card({ product }) {
  return (
    <CardWrapper>
      <StyledImg src={product.src} />
      <StyledH2>{product.title}</StyledH2>
      <StyledP>{product.content}</StyledP>
      <PriceWrapper flex align="center">
        <CutPrice>{product.cutPrice}</CutPrice>
        <Price>{product.price}</Price>
      </PriceWrapper>
    </CardWrapper>
  );
}

const StyledImg = styled.img`
  width: 411px;
  height: 411px;
`;

const CardWrapper = styled.div`
  margin-right: 24px;
`;

const StyledH2 = styled.h2`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  color: #3f3f3f;
  margin-top: 16px;
`;

const StyledP = styled.p`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  letter-spacing: -0.008em;
  color: #777777;
  margin: 8px 0px;
`;

const PriceWrapper = styled.div`
  ${props => applyFlex(props)}
  font-family: 'Noto Sans KR';
  font-style: normal;
`;

const CutPrice = styled.div`
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  letter-spacing: -0.008em;
  color: #1b1b1b;
  margin-right: 8px;
`;

const Price = styled.div`
  font-weight: 400;
  font-size: 14px;
  line-height: 24px;
  letter-spacing: -0.008em;
  text-decoration-line: line-through;
  color: #bcbcbc;
`;
