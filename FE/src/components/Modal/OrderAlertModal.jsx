import React from 'react';
import * as S from './OrderAlertModal.style';

const OrderAlertModal = ({ onClose }) => {
  return (
    <S.OrderAlertModalStyle>
      <S.OrderContent>{`해당 상품을\n주문했습니다.`}</S.OrderContent>
      <S.CheckBtn onClick={onClose}>확인</S.CheckBtn>
    </S.OrderAlertModalStyle>
  );
};

export default OrderAlertModal;
