import { Event, StyledWrapper } from './eventWrapper.styled';

export function EventWrapper({ events, size }) {
  if (size === 'small') {
    return;
  }
  if (!events) {
    return;
  }
  return (
    <StyledWrapper flex>
      {events.map(event => {
        return (
          <Event key={event.discountEventId} flex align="center" justify="center" eventId={event.discountEventId}>
            {event.title}
          </Event>
        );
      })}
    </StyledWrapper>
  );
}
