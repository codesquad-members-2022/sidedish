import { useState } from 'react';
import { API } from '../../helper/constants';
import { fetchData, getUrlWithIdPage } from '../../helper/utils';
import { DeliveryCircle } from './deliveryCircle/deliveryCircle';
import { EventWrapper } from './eventWrapper/eventWrapper';
import { CardWrapper, CutPrice, Price, PriceWrapper, StyledH2, StyledImg, StyledP } from './ProductCard.styled';

export function ProductCard({ product, size, onClick }) {
  const [hover, setHover] = useState(false);

  function handleMouseEnter() {
    setHover(true);
  }

  function handleMouseLeave() {
    setHover(false);
  }

  async function handleMouseClick() {
    if (size === 'small') {
      return;
    }
    const { sideDishId } = product;
    const URL = getUrlWithIdPage({ url: API.sideDish, id: sideDishId, page: 0 });
    const sideDishData = await fetchData(URL);
    onClick(sideDishData);
  }
  return (
    <CardWrapper
      data-id={product.sideDishId}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}
      onClick={handleMouseClick}
    >
      <StyledImg src={product.imageUrl} size={size} />
      <StyledH2 size={size}>{product.name}</StyledH2>
      {size !== 'small' ? <StyledP size={size}>{product.description}</StyledP> : ``}
      <PriceWrapper flex align="center">
        <CutPrice>{`${product.disCountPrice.toLocaleString()}원`}</CutPrice>
        <Price>{`${product.price.toLocaleString()}원`}</Price>
      </PriceWrapper>
      <EventWrapper events={product.discountEventResponses} size={size} />
      <DeliveryCircle size={size} hover={hover} shippingInfo={product.shippingInfo} />
    </CardWrapper>
  );
}
