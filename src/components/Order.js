import React, { useState } from 'react';
import styled from 'styled-components';

const Order = ({ price }) => {
  const [orderNum, setOrderNum] = useState(1);

  return (
    <>
      <div>
        <QuantityBtnIcon>- </QuantityBtnIcon>
        <span>{orderNum}</span>
        <QuantityBtnIcon> +</QuantityBtnIcon>
      </div>

      <div>
        <span>총 주문금액 : </span>
        <span>{price * Number(orderNum)}</span>
      </div>
    </>
  );
};

const QuantityBtnIcon = styled.span`
  padding: 10px;
  font-size: 50px;
`;

export default Order;
