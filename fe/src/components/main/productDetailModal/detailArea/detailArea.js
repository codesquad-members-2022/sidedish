import { CostInfo } from './costInfo/costInfo';
import { DeliveryInfo } from './deliveryInfo/deliveryInfo';
import { DetailContainer, DetailWrapper } from './detailArea.styled';
import { OrderBtn } from './orderBtn/orderBtn';
import { ProductInfo } from './productInfo/productInfo';
import { useEffect, useState } from 'react';
import { fetchData } from '../../../../helper/utils';
import { API } from '../../../../helper/constants';

export function DetailArea({ props, setModal }) {
  const [orderState, setOrderState] = useState(false);
  const [count, setCount] = useState(1);

  function calculateTotalCost() {
    const price = props.disCountPrice || props.price;
    const totalPrice = price * count >= props.exemptionCondition ? price * count : price * count + props.shippingFee;
    return totalPrice;
  }

  useEffect(() => {
    if (!orderState) {
      return;
    }
    const data = {
      memberId: 1,
      quantity: count,
      sideDishId: props.sideDishId,
      totalAmount: calculateTotalCost(),
    };
    fetchData(API.order, { method: 'POST', bodyData: data });
    setOrderState(false);
    setModal(null);
  }, [orderState]);

  return (
    <DetailContainer>
      <DetailWrapper>
        <ProductInfo props={props} />
        <DeliveryInfo props={props} />
        <CostInfo props={props} count={count} setCount={setCount} calculateTotalCost={calculateTotalCost} />
      </DetailWrapper>
      <OrderBtn onClick={setOrderState} />
    </DetailContainer>
  );
}
