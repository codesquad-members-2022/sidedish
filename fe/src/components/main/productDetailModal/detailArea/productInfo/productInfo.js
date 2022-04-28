import { EventWrapper } from '../../../../../common/productCard/eventWrapper/eventWrapper';
import { getWonTemplate } from '../../../../../helper/utils';
import { FinalPrice, FinalPriceInfo, OriginPrice, StyledProductInfo, Title } from './productInfo.styled';

export function ProductInfo({ props }) {
  return (
    <StyledProductInfo>
      <Title>{props.name}</Title>
      <OriginPrice>{`${props.price === props.disCountPrice ? '' : getWonTemplate(props.price)}`}</OriginPrice>
      <FinalPriceInfo flex align="start">
        <EventWrapper events={props.discountEventResponses}></EventWrapper>
        <FinalPrice>
          {props.disCountPrice ? `${getWonTemplate(props.disCountPrice)}` : `${getWonTemplate(props.price)}`}
        </FinalPrice>
      </FinalPriceInfo>
    </StyledProductInfo>
  );
}
