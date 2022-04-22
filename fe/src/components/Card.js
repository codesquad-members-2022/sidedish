import {
  CardWrapper,
  CutPrice,
  Event,
  Price,
  PriceWrapper,
  StyledH2,
  StyledImg,
  StyledP,
  StyledWrapper,
} from './Card.styled';

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
      <EventWrapper events={product.events} />
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
