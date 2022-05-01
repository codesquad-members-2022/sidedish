import React from 'react';
import styled from 'styled-components';

import Button from './Button';
import { color } from '../css/variables';

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
      <OrderConatiner>
        <div>
          <StyledQuantityButton
            onClick={handleClickDecreaseQuantity}
            icon={' - '}
          />
          <span> {orderNum} </span>
          <StyledQuantityButton
            onClick={handleClickIncreaseQuantity}
            icon={' + '}
          />
        </div>

        <div>
          <span>총 주문금액 : </span>
          <span>{price * Number(orderNum)}원</span>
        </div>
      </OrderConatiner>
      <StyledButton icon={'주문하기'} onClick={handleClickOrder}></StyledButton>
    </>
  );
};

const OrderConatiner = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 50px;
`;

const StyledQuantityButton = styled(Button)`
  font-size: 30px;
  cursor: pointer;
`;

const StyledButton = styled(Button)`
  margin-top: 50px;
  font-size: 26px;
  color: ${color.white};
  background-color: ${color.black};
  border-radius: 5px;
  padding: 10px;
`;

export default Order;
