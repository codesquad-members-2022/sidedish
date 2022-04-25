import React, { useRef, useState } from 'react';
import styled from 'styled-components';
const DishDetail = styled.div`
  width: 860px;
  height: 520px;
  box-sizing: border-box;
  padding: 0 48xp 48px 48px;
  display: flex;
  justify-content: center;
`;
const ProductImages = styled.div`
  width: 392px;
  height: 392px;
  gap: 8px;
`;

const MainImage = styled.img`
  width: 392px;
  height: 392px;
  margin-bottom: 8px;
  background-size: cover;
`;
const SubImages = styled.div`
  width: 100%;
  height: 72px;
  display: flex;
  justify-content: flex-start;
  gap: 8px;
`;
const SubImage = styled.img`
  width: 72px;
  height: 72px;
`;
const ProductInfo = styled.div`
  width: 440px;
  margin-left: 32px;
`;
const ProductName = styled.div`
  font-weight: 800;
  font-size: 20px;
  line-height: 30px;
  margin-bottom: 16px;
`;
const PrimeCost = styled.div`
  font-size: 14px;
  line-height: 24px;
  margin-bottom: 8px;
  color: #bcbcbc;
`;
const BadgeAndPrice = styled.div`
  display: flex;
  height: 30px;
  gap: 8px;
  margin-bottom: 24px;
`;
const Badge = styled.div`
  box-sizing: border-box;
  padding: 6px 16px;
  display: grid;
  place-content: center center;
  background: #ff8e14;
  border-radius: 999px;
  font-size: 12px;
  line-height: 18px;
  color: #ffffff;
`;
const Price = styled.div`
  font-size: 20px;
  line-height: 30px;
`;
const Info = styled.div`
  display: flex;
  justify-content: flex-start;
  border-top: 1px solid #ebebeb;
  border-bottom: 1px solid #ebebeb;
  box-sizing: border-box;
  padding: 17px 0;
  margin-bottom: 26px;
`;
const InfoTitles = styled.div`
  width: 76px;
  height: 103px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
`;
const PointTitle = styled.div`
  color: #777777;
  font-weight: 400;
  font-size: 12px;
  line-height: 18px;
`;
const DeliveryTitle = styled(PointTitle)``;
const DeliveryPriceTitle = styled(PointTitle)``;
const InfoDetails = styled(InfoTitles)`
  width: 364px;
  height: 103px;
`;
const Point = styled(PointTitle)`
  color: #1b1b1b;
`;
const Delivery = styled(Point)``;
const DeliveryPrice = styled(Point)``;
const AmountAndCost = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 83px;
`;
const AmountButtons = styled.div`
  display: flex;
  align-items: center;
  gap: 7px;
`;
const MinusButton = styled.button`
  font-weight: bold;
  font-size: 25px;
  display: grid;
  place-content: center start;
  color: #777777;
`;
const Amount = styled.div`
  font-size: 16px;
  display: grid;
  place-content: center center;
  line-height: 16px;
`;
const PlusButton = styled(MinusButton)``;
const CostInfo = styled.div`
  display: flex;
  gap: 16px;
`;
const TotalCostTitle = styled.div`
  font-weight: 400;
  font-size: 16px;
  display: grid;
  place-content: center center;
  color: #777777;
`;
const TotalCost = styled.div`
  font-size: 20px;
  line-height: 30px;
`;
const OrderButton = styled.button`
  width: 440px;
  height: 58px;
  left: 472px;
  display: grid;
  place-content: center center;
  background: #1b1b1b;
  color: #ffffff;
  font-weight: 700;
  font-size: 18px;
`;
function ProductDetail({ dishes }) {
  const mainImage = useRef(dishes.images[0]);
  const [amount, setAmount] = useState(1);
  function addAmount() {
    setAmount(amount + 1);
  }
  function decreaseAmount() {
    if (amount > 1) setAmount(amount - 1);
  }

  function changeImage({ target }) {
    mainImage.current.src = target.src;
  }

  return (
    <DishDetail>
      <ProductImages>
        <MainImage src={dishes.images[0]} ref={mainImage}></MainImage>
        <SubImages>
          {dishes.images.map((src, index) => (
            <SubImage key={index} src={src} onMouseEnter={changeImage}></SubImage>
          ))}
        </SubImages>
      </ProductImages>
      <ProductInfo>
        <ProductName>{dishes.name}</ProductName>
        <PrimeCost>{dishes.price.toLocaleString()}원</PrimeCost>
        <BadgeAndPrice>
          <Badge>{dishes.badge_title}</Badge>
          <Price>{dishes.discount_price.toLocaleString()}원</Price>
        </BadgeAndPrice>
        <Info>
          <InfoTitles>
            <PointTitle>적립금</PointTitle>
            <DeliveryTitle>배송정보</DeliveryTitle>
            <DeliveryPriceTitle>배송비</DeliveryPriceTitle>
          </InfoTitles>
          <InfoDetails>
            <Point>{(dishes.discount_price * dishes.mileage_ratio).toLocaleString()}원</Point>
            <Delivery>{dishes.early_delivery ? '서울 경기 새벽배송, ' : ''}전국 택배 배송</Delivery>
            <DeliveryPrice>{dishes.delivery_price.toLocaleString()}원</DeliveryPrice>
          </InfoDetails>
        </Info>
        <AmountAndCost>
          <AmountButtons>
            <MinusButton onClick={decreaseAmount}>-</MinusButton>
            <Amount>{amount}</Amount>
            <PlusButton onClick={addAmount}>+</PlusButton>
          </AmountButtons>
          <CostInfo>
            <TotalCostTitle>총 주문금액</TotalCostTitle>
            <TotalCost>{(dishes.discount_price * amount).toLocaleString()}원</TotalCost>
          </CostInfo>
        </AmountAndCost>
        <OrderButton>주문하기</OrderButton>
      </ProductInfo>
    </DishDetail>
  );
}

export default ProductDetail;
