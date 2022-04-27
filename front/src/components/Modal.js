import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { fetchDishItem } from '../api';
import ProductDetail from './ProductDetail';
import RelatedProduct from './RelatedProduct';

const ModalWrap = styled.div`
  position: fixed;
  width: 100vw;
  height: 100vh;
  background-color: rgba(73, 68, 68, 0.5);
  z-index: 5;
  display: flex;
  justify-content: center;
  align-items: center;
`;
const PopupBox = styled.div`
  width: 960px;
  height: 994px;
  background-color: #ffffff;
  border: 2px solid #000000;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
const PopupCloseButtonWrap = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: flex-end;
  box-sizing: border-box;
  padding: 32px 48px 18px 48px;
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

function Modal({ dishId, hideModal, showModal }) {
  const [dish, setDish] = useState(null);
  function closeModal(e) {
    if (e.target !== e.currentTarget) {
      return;
    } // 질문해보기!
    hideModal();
  }
  useEffect(() => {
    async function fetchAndSetDish() {
      const data = await fetchDishItem(dishId);
      setDish(data);
    }
    fetchAndSetDish();
  }, [dishId]);
  return (
    <>
      {dish && (
        <ModalWrap onClick={closeModal}>
          <PopupBox>
            <PopupCloseButtonWrap>
              <PopupCloseButton onClick={closeModal}>닫기</PopupCloseButton>
            </PopupCloseButtonWrap>
            <ProductDetail dishes={dish}></ProductDetail>
            <RelatedProduct relatedDishes={dish.related_dishes} showModal={showModal}></RelatedProduct>
          </PopupBox>
        </ModalWrap>
      )}
    </>
  );
}

export default Modal;
