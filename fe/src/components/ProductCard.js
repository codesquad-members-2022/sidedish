import { useState } from 'react';
import {
  CardWrapper,
  CutPrice,
  DeliveryInfo,
  Event,
  Price,
  PriceWrapper,
  StyledCircle,
  StyledH2,
  StyledImg,
  StyledP,
  StyledWrapper,
} from './ProductCard.styled';

export function ProductCard({ product, size }) {
  const [hover, setHover] = useState(false);
  function handleMouseEnter() {
    setHover(true);
  }
  function handleMouseLeave() {
    setHover(false);
  }
  return (
    <CardWrapper onMouseEnter={handleMouseEnter} onMouseLeave={handleMouseLeave}>
      <StyledImg src={product.imageUrl} size={size} />
      <StyledH2 size={size}>{product.name}</StyledH2>
      <CardContent content={product.description} size={size} />
      <PriceWrapper flex align="center">
        <CutPrice>{`${product.disCountPrice.toLocaleString()}원`}</CutPrice>
        <Price>{`${product.price.toLocaleString()}원`}</Price>
      </PriceWrapper>
      <EventWrapper events={product.discountEventResponses} size={size} />
      <DeliveryCircle hover={hover} shippingInfo={product.shippingInfo} />
    </CardWrapper>
  );
}

function CardContent({ content, size }) {
  if (size === 'small') {
    return;
  }
  return <StyledP size={size}>{content}</StyledP>;
}

function EventWrapper({ events, size }) {
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

function DeliveryCircle({ shippingInfo, hover }) {
  if (!shippingInfo) {
    return;
  }
  if (!hover) {
    return;
  }
  const deliveryType = parseShippingInfo(shippingInfo);

  return (
    <StyledCircle flex direction="column" justify="center" align="center">
      {deliveryType.map((delivery, idx) => {
        if (!delivery) {
          return false;
        }
        return <DeliveryInfo key={`${delivery}-${idx}`}>{delivery}</DeliveryInfo>;
      })}
    </StyledCircle>
  );
}

function parseShippingInfo(shippingInfo) {
  shippingInfo = shippingInfo.replace('새벽배송', '새벽 배송');
  shippingInfo = shippingInfo.replace('전국택배', '전국 택배');
  const checkDeliveryType = str => {
    return shippingInfo.includes(str) && str;
  };
  const [earlyDelivery, allCountryDelivery] = [checkDeliveryType('새벽 배송'), checkDeliveryType('전국 택배')];
  return [earlyDelivery, allCountryDelivery];
}
