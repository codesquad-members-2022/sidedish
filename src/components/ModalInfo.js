import React from 'react';
import styled from 'styled-components';

import Order from './Order';
import Infos from './Infos';
import ShoppingInfo from './ShoppingInfo';
import { fontSize } from '../css/variables';

const ModalInfo = ({
  cardInfo,
  price,
  orderNum,
  title,
  handleClickDecreaseQuantity,
  handleClickIncreaseQuantity,
  closeModal,
}) => {
  return (
    <StyledDiv2>
      <Infos cardInfo={cardInfo} />
      <ShoppingInfo price={price} orderNum={orderNum} />
      <Order
        price={price}
        orderNum={orderNum}
        title={title}
        handleClickDecreaseQuantity={handleClickDecreaseQuantity}
        handleClickIncreaseQuantity={handleClickIncreaseQuantity}
        closeModal={closeModal}
      />
    </StyledDiv2>
  );
};

const StyledDiv2 = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 30px;
  font-size: ${fontSize.xl};
`;

export default ModalInfo;
