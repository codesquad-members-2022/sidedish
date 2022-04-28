import { EventWrapper } from '../../../../../../common/productCard/eventWrapper/eventWrapper';
import { FinalPrice, FinalPriceInfo, OriginPrice, StyledProductInfo, Title } from './productInfo.styled';

export function ProductInfo({ props }) {
  return (
    <StyledProductInfo>
      <Title>{props.name}</Title>
      <OriginPrice>{`${props.price.toLocaleString()}원`}</OriginPrice>
      <FinalPriceInfo flex align="start">
        <EventWrapper events={props.discountEventResponses}></EventWrapper>
        <FinalPrice>
          {props.disCountPrice ? `${props.disCountPrice.toLocaleString()}원` : `${props.price.toLocaleString()}원`}
        </FinalPrice>
      </FinalPriceInfo>
    </StyledProductInfo>
  );
}
