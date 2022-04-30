import styled from "styled-components";
import MinusBtn from "../../core/MinusBtn";
import PlusBtn from "../../core/PlusBtn";
import { makePriceFormat } from "../../util/makePriceFormat";

const OrderNumber = ({ wantedNumber, setWantedNumber, salePrice, stockQuantity }) => {
  const handleClickMinusBtn = () => {
    if (wantedNumber > 1) {
      setWantedNumber(wantedNumber - 1);
    }
  };
  const handleClickPlusBtn = () => {
    if (wantedNumber < stockQuantity) {
      setWantedNumber(wantedNumber + 1);
    }
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
          <TotalPrice>{makePriceFormat(salePrice * wantedNumber)}</TotalPrice>
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
