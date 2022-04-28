import { useContext } from 'react';
import styled, { css } from 'styled-components';

import { Colors, Fonts } from '@/Constants';

import { ModalContext } from './ModalContext';
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
  background-color: ${Colors.OFF_WHITE};
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
  const { ModalDisplay, productDetail, reset } = useContext(ModalContext);

  function onClickCloseBtn() {
    reset();
  }
  function OrderButtonEvent() {}

  if (!productDetail) {
    return;
  }

  return (
    <ModalBackGround ModalOpen={ModalDisplay}>
      <OrderModalWrapper>
        <CloseButton onClick={onClickCloseBtn}>닫기</CloseButton>
        <SelectedProduct>
          {productDetail && (
            <ProductThumbnail ProductThumbnailData={productDetail.images} />
          )}

          {productDetail && <ProductInfo productData={productDetail} />}

          <OrderButton ContentsText={'주문하기'} onClick={OrderButtonEvent} />
        </SelectedProduct>

        <RelatedProduct></RelatedProduct>
      </OrderModalWrapper>
    </ModalBackGround>
  );
};
