import { useState } from 'react';
import { DeliveryCircle } from './deliveryCircle/deliveryCircle';
import { EventWrapper } from './eventWrapper/eventWrapper';
import { CardWrapper, CutPrice, Price, PriceWrapper, StyledH2, StyledImg, StyledP } from './ProductCard.styled';

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
      {size !== 'small' ? <StyledP size={size}>{product.description}</StyledP> : ``}
      <PriceWrapper flex align="center">
        <CutPrice>{`${product.disCountPrice.toLocaleString()}원`}</CutPrice>
        <Price>{`${product.price.toLocaleString()}원`}</Price>
      </PriceWrapper>
      <EventWrapper events={product.discountEventResponses} size={size} />
      <DeliveryCircle hover={hover} shippingInfo={product.shippingInfo} />
    </CardWrapper>
  );
}
