import React from 'react';
import styled from 'styled-components';
import ProductDetail from './ProductDetail';

const ModalWrap = styled.div`
  position: fixed;
  width: 100vw;
  height: 100vh;
  background-color: rgba(73, 68, 68, 0.5);
  z-index: 5;
  /* display: none; */
  display: flex;
  justify-content: center;
  align-items: center;
`;
const PopupBox = styled.div`
  /* width: 960px;
  height: 994px; */
  width: 700px;
  height: 700px;
  background-color: #ffffff;
  border: 2px solid #000000;
`;
const PopupCloseButtonWrap = styled.div`
  display: flex;
  align-items: center;
  justify-content: flex-end;
  box-sizing: border-box;
  padding: 32px 18px 48px;
  height: 76px;
`;
const PopupCloseButton = styled.button`
  font-family: 'Noto Sans KR';
  font-style: normal;
  font-weight: 400;
  font-size: 16px;
  line-height: 26px;
  color: #777777;
`;
function Modal({ dishes }) {
  const relatedDishes = dishes.related_dishes;
  return (
    <ModalWrap>
      <PopupBox>
        <PopupCloseButtonWrap>
          <PopupCloseButton>닫기</PopupCloseButton>
          <ProductDetail dishes={dishes}></ProductDetail>
        </PopupCloseButtonWrap>
      </PopupBox>
    </ModalWrap>
  );
}

export default Modal;
