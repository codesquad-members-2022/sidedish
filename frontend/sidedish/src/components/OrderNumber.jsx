import { useState } from "react";
import styled from "styled-components";
import MinusBtn from "../core/MinusBtn";
import PlusBtn from "../core/PlusBtn";
import { makePriceFormat } from "../util/makePriceFormat";

const OrderNumber = () => {
  const price = 12640;
  const [wantedNumber, setWantedNumber] = useState(1);
  const handleClickMinusBtn = (e) => {
    if (wantedNumber > 1) {
      setWantedNumber(wantedNumber - 1);
    }
  };
  const handleClickPlusBtn = (e) => {
    setWantedNumber(wantedNumber + 1);
  };
  return (
    <>
      <OrderNumberContainer>
        <NumberChangeContainer>
          <MinusBtn handler={handleClickMinusBtn} />
          <WantedNumber>{wantedNumber}</WantedNumber>
          <PlusBtn handler={handleClickPlusBtn} />
        </NumberChangeContainer>
        <TotalPriceContainer>
          <TotalPriceTitle>총 주문금액</TotalPriceTitle>
          <TotalPrice>{makePriceFormat(price * wantedNumber)}원</TotalPrice>
        </TotalPriceContainer>
      </OrderNumberContainer>
    </>
  );
};

const OrderNumberContainer = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 26px 0;
`;

const NumberChangeContainer = styled.div`
  display: flex;
  align-items: center;
`;

const WantedNumber = styled.div`
  padding: 5px 10px 0 10px;
`;

const TotalPriceContainer = styled.div`
  display: flex;
  align-items: center;
  line-height: 26px;
`;

const TotalPriceTitle = styled.div`
  color: #777;
  padding-right: 16px;
`;

const TotalPrice = styled.div`
  font-size: 20px;
  font-weight: 500;
`;
export default OrderNumber;
