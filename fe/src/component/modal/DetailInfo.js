import React, { useState } from "react";
import styled, { css } from "styled-components";
import { PlusIcon, MinusIcon } from "../icons/ModalIcon";
import { priceToString } from "../../utils/utils";

const InforWrapper = styled.div`
  width: 470px;
  height: 472px;
`;

const TextWrapper = styled.div`
  height: 90%;
`;

const InforTitle = styled.span`
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  margin-top: 5px;
`;

const InforOriginPrice = styled.p`
  color: ${({ theme }) => theme.colors.grey2};
  font-size: ${({ theme }) => theme.fontSize.small};
  margin: 10px 0px;
`;

const InforBadge = styled.span`
  width: 76px;
  height: 40px;
  line-height: 30px;
  border-radius: 20px;
  color: ${({ theme }) => theme.colors.white};
  text-align: center;
  margin-top: 25px;
  margin-right: 10px;
  padding: 8px 15px;

  ${({ children }) =>
    children === "런칭특가"
      ? css`
          background: ${({ theme }) => theme.colors.orange};
        `
      : css`
          background: ${({ theme }) => theme.colors.green};
        `}
`;

const SaledPrice = styled.span`
  font-size: ${({ theme }) => theme.fontSize.large};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  margin-top: 5px;
`;

const ProductInfoWrapper = styled.div`
  width: 95%;
  border-bottom: 1px solid #000;
  padding-bottom: 15px;
`;

// ProductInfoWrapper

const ProductPriceWrapper = styled.div`
  display: flex;
  height: 80px;
  width: 95%;
  padding: 10px 0;
  border-bottom: 1px solid #000;
`;

const ProductPriceTextWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
`;

const ProductPriceText = styled.span`
  font-size: 12px;
`;

const ProductPriceList = styled.span`
  color: ${({ theme }) => theme.colors.grey2};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  margin-right: 20px;
`;

const ProductAmountWrapper = styled.div`
  width: 95%;
  display: flex;
  justify-content: space-between;
  padding-top: 20px;
  height: 180px;
`;

const ProductAmountCountWrapper = styled.div`
  width: 75px;
  height: 30px;
  justify-content: space-between;
  align-items: center;

  display: flex;
`;

const ProductAmountCount = styled.div`
  margin-left: 10px;
  margin-right: 3px;
`;

const ProductAmountText = styled.span`
  font-size: 16px;
  margin-right: 15px;
  color: grey;
`;

const ProductAmount = styled.span`
  font-size: 20px;
`;

const OrderButton = styled.button`
  width: 440px;
  height: 58px;
  background-color: black;
  color: wheat;
`;

const DetailInfo = ({ infoData }) => {
  const [orderNumber, SetOrderNumber] = useState(1);

  const orderNumberMinus = () => {
    SetOrderNumber((prev) => (prev === 1 ? prev : prev - 1));
  };

  const orderNumberPlus = () => {
    SetOrderNumber((prev) => prev + 1);
  };

  return (
    <InforWrapper>
      <TextWrapper>
        <ProductInfoWrapper>
          <InforTitle>{infoData.name}</InforTitle>
          <InforOriginPrice>{priceToString(infoData.price)}</InforOriginPrice>
          <InforBadge>런칭특가</InforBadge>
          <SaledPrice>{priceToString(infoData.discountPrice)}</SaledPrice>
        </ProductInfoWrapper>

        <ProductPriceWrapper>
          <ProductPriceTextWrapper>
            <ProductPriceList>적립금</ProductPriceList>
            <ProductPriceList>배송정보</ProductPriceList>
            <ProductPriceList>배송비</ProductPriceList>
          </ProductPriceTextWrapper>

          <ProductPriceTextWrapper>
            <ProductPriceText>
              {Math.floor(infoData.discountPrice * 0.01).toString()}
            </ProductPriceText>
            <ProductPriceText>
              {infoData.shippingInfo && infoData.shippingInfo.deliveryInfo}
            </ProductPriceText>
            <ProductPriceText>
              {infoData.shipInfo &&
                infoData.shipInfo.deliveryCharge.toString() + " "}
              (40,000원 이상 구매 시 무료)
            </ProductPriceText>
          </ProductPriceTextWrapper>
        </ProductPriceWrapper>

        <ProductAmountWrapper>
          <ProductAmountCountWrapper>
            <MinusIcon onClick={orderNumberMinus} />
            <ProductAmountCount>{orderNumber}</ProductAmountCount>
            <PlusIcon onClick={orderNumberPlus} />
          </ProductAmountCountWrapper>
          <div>
            <ProductAmountText>총 주문금액</ProductAmountText>
            <ProductAmount>
              {priceToString(infoData.discountPrice * orderNumber)}
            </ProductAmount>
          </div>
        </ProductAmountWrapper>
        <OrderButton>주문하기</OrderButton>
      </TextWrapper>
    </InforWrapper>
  );
};

export default DetailInfo;
