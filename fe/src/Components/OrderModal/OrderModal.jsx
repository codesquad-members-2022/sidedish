import { useState } from 'react';
import styled, { css } from 'styled-components';

import { Colors, Fonts } from '@/Constants';

import { ProductInfo } from './ProductInfo';
import { ProductThumbnail } from './ProductThumbnail';

import { OrderButton } from '@/Components/Button';

const ModalBackGround = styled.div`
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.5);
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  z-index: 100;

  ${({ ModalOpen }) => {
    if (!ModalOpen) {
      return css`
        display: none;
      `;
    }
  }}
`;

const OrderModalWrapper = styled.div`
  display: flex;
  position: relative;
  flex-direction: column;
  background-color: beige;
  display: flex;
  width: 960px;
`;

const SelectedProduct = styled.section`
  display: flex;
  position: relative;

  margin: 48px;
  margin-top: 76px;
`;

const RelatedProduct = styled.div``;

const CloseButton = styled.button`
  position: absolute;
  color: ${Colors.GREY};
  top: 32px;
  right: 48px;
  width: 30px;
  height: 26px;
`;

export const OrderModal = () => {
  const [ModalOpen, setModalOpen] = useState(true);

  function onClickCloseBtn() {
    setModalOpen(false);
  }

  function OrderButtonEvent() {
    console.log('test OK');
  }

  return (
    <ModalBackGround ModalOpen={ModalOpen}>
      <OrderModalWrapper>
        <CloseButton onClick={onClickCloseBtn}>닫기</CloseButton>
        <SelectedProduct>
          <ProductThumbnail
            ProductThumbnailData={[
              'https://img.insight.co.kr/static/2019/06/26/700/f31l48lhp1v2tuq7ce8o.jpg',
              'https://img.insight.co.kr/static/2019/06/26/700/5nmluh24cnp5h4rb3vj4.jpg',
              'https://studyforus.com/files/attach/images/1816/212/461/aca7e1aed69a698c8896c641d77085dd.png',
            ]}
          />

          <ProductInfo />

          <OrderButton ContentsText={'주문하기'} onClick={OrderButtonEvent} />
        </SelectedProduct>

        <RelatedProduct></RelatedProduct>
      </OrderModalWrapper>
    </ModalBackGround>
  );
};
