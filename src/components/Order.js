import React from 'react';
import styled from 'styled-components';

import Button from './Button';

const Order = ({
  price,
  orderNum,
  title,
  handleClickDecreaseQuantity,
  handleClickIncreaseQuantity,
  closeModal,
}) => {
  const handleClickOrder = () => {
    if (
      window.confirm(`${title} 을(를) ${orderNum}개 주문 하시겠습니까?
가격은 ${price * Number(orderNum)}원 입니다.`)
    ) {
      closeModal();
    }
  };

  return (
    <>
      <div>
        <QuantityBtnIcon onClick={handleClickDecreaseQuantity}>
          -
        </QuantityBtnIcon>
        <span>{orderNum}</span>
        <QuantityBtnIcon onClick={handleClickIncreaseQuantity}>
          +
        </QuantityBtnIcon>
      </div>

      <div>
        <span>총 주문금액 : </span>
        <span>{price * Number(orderNum)}</span>
      </div>
      <Button icon={'주문하기'} onClick={handleClickOrder}></Button>
    </>
  );
};

const QuantityBtnIcon = styled.span`
  padding: 10px;
  font-size: 50px;
  cursor: pointer;
`;

export default Order;
