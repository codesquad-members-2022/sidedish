import styled from "styled-components";
import { makePriceFormat } from "../util/makePriceFormat";

const DELIVERY_FEE_INDEX = 0;
const DELIVERY_FEE_FREE_MIN = 1;

const OrderDetail = (/* props로 data 받음*/) => {
  const data = { reserves: "126", deliveryInfo: "서울 경기 새벽 배송, 전국 택배 배송", deliveryFee: ["2500", "40000"] };
  return (
    <>
      <OrderDetailContainer>
        <OrderData>
          <OrderDataTitle>적립금</OrderDataTitle>
          <OrderDataContents>{makePriceFormat(data.reserves)}</OrderDataContents>
        </OrderData>
        <OrderData>
          <OrderDataTitle>배송정보</OrderDataTitle>
          <OrderDataContents>{data.deliveryInfo}</OrderDataContents>
        </OrderData>
        <OrderData>
          <OrderDataTitle>배송비</OrderDataTitle>
          <OrderDataContents>
            {makePriceFormat(data.deliveryFee[DELIVERY_FEE_INDEX])} ({makePriceFormat(data.deliveryFee[DELIVERY_FEE_FREE_MIN])} 이상 구매 시 무료)
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
