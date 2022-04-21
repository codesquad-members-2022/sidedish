import styled, { css } from 'styled-components';
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
      <EventWrapper events={product.events}></EventWrapper>
    </CardWrapper>
  );
}

function EventWrapper(props) {
  const events = props.events;
  if (!events) {
    return;
  }
  return (
    <StyledWrapper flex>
      {events.map((eventName, idx) => {
        return (
          <Event key={idx} flex align="center" justify="center" eventName={eventName}>
            {eventName}
          </Event>
        );
      })}
    </StyledWrapper>
  );
}

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

const StyledWrapper = styled.div`
  ${props => applyFlex(props)}
  margin-top:16px;
  color: #fff;
  font-weight: 500;
  font-size: 12px;
`;

const Event = styled.div`
  ${props => applyFlex(props)}
  ${props => styleColorToEvent(props)}
  margin-right: 8px;
  border-radius: 999px;
`;
