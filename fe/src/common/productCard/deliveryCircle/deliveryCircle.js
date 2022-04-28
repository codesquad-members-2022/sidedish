import { DeliveryInfo, StyledCircle } from './deliveryCircle.styled';

export function DeliveryCircle({ shippingInfo, hover, size }) {
  if (!shippingInfo || !hover || size === 'small') {
    return;
  }
  const deliveryType = parseShippingInfo(shippingInfo);

  return (
    <StyledCircle flex direction="column" justify="center" align="center">
      {deliveryType
        .filter(delivery => delivery)
        .map((delivery, idx) => (
          <DeliveryInfo key={`${delivery}-${idx}`}>{delivery}</DeliveryInfo>
        ))}
    </StyledCircle>
  );
}

function parseShippingInfo(shippingInfo) {
  shippingInfo = shippingInfo.replace('새벽배송', '새벽 배송');
  shippingInfo = shippingInfo.replace('전국택배', '전국 택배');
  const checkDeliveryType = str => {
    return shippingInfo.includes(str) && str;
  };
  const [earlyDelivery, everywhereDelivery] = [checkDeliveryType('새벽 배송'), checkDeliveryType('전국 택배')];
  return [earlyDelivery, everywhereDelivery];
}
