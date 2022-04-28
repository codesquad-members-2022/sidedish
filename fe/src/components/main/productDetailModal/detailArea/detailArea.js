import { CostInfo } from './costInfo/costInfo';
import { DeliveryInfo } from './deliveryInfo/deliveryInfo';
import { DetailContainer, DetailWrapper } from './detailArea.styled';
import { OrderBtn } from './orderBtn/orderBtn';
import { ProductInfo } from './productInfo/productInfo';

export function DetailArea({ props }) {
  return (
    <DetailContainer>
      <DetailWrapper>
        <ProductInfo props={props}></ProductInfo>
        <DeliveryInfo props={props}></DeliveryInfo>
        <CostInfo props={props}></CostInfo>
      </DetailWrapper>
      <OrderBtn></OrderBtn>
    </DetailContainer>
  );
}
