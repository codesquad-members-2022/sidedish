import React from 'react';

const ShoppingInfo = ({ price }) => {
  return (
    <p>
      적립금 : {Math.floor(price * 0.01)}
      <br />
      배송정보 : 서울 경기 새벽 배송, 전국 택배 배송
      <br />
      배송비 : 2500원 (40,000원 이상 구매 시 무료)
    </p>
  );
};

export default ShoppingInfo;
