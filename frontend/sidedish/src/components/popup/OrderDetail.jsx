import styled from "styled-components";
import { makePriceFormat } from "../../util/makePriceFormat";

const OrderDetail = ({ deliveryArea, deliveryMorning, deliveryPrice, point }) => {
  return (
    <>
      <OrderDetailContainer>
        <OrderData>
          <OrderDataTitle>적립금</OrderDataTitle>
          <OrderDataContents>{makePriceFormat(point)}</OrderDataContents>
        </OrderData>
        <OrderData>
          <OrderDataTitle>배송정보</OrderDataTitle>
          <OrderDataContents>
            {(deliveryMorning ? "서울 경기 새벽 배송, " : "") + deliveryArea}
          </OrderDataContents>
        </OrderData>
        <OrderData>
          <OrderDataTitle>배송비</OrderDataTitle>
          <OrderDataContents>
            {makePriceFormat(deliveryPrice)} ({makePriceFormat(40000)} 이상 구매 시 무료)
          </OrderDataContents>
        </OrderData>
      </OrderDetailContainer>
    </>
  );
};

const OrderDetailContainer = styled.div`
  padding: 13px 0;
  align-items: baseline;
`;

const OrderData = styled.div`
  display: flex;
  padding: 4px 0;
`;

const OrderDataTitle = styled.div`
  width: 60px;
  color: #777;
  font-size: 12px;
  line-height: 18px;
`;

const OrderDataContents = styled.div`
  font-size: 12px;
  line-height: 18px;
`;

export default OrderDetail;
