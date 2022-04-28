import { useContext } from 'react';
import styled, { css } from 'styled-components';

import { Colors } from '@/Constants';

import { ModalContext } from './ModalContext';
import { ProductInfo } from './ProductInfo';
import { ProductThumbnail } from './ProductThumbnail';
import { RelatedProducts } from './RelatedProducts';

const ModalBackGround = styled.div`
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: ${Colors.BLACK}90;
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

  padding: 48px;

  .order-button {
    display: block;
  }
`;

const CloseButton = styled.button`
  position: absolute;
  z-index: 1000;
  color: ${Colors.GREY};
  top: 32px;
  right: 48px;
  width: 30px;
  height: 26px;

  &:hover {
    opacity: 0.7;
  }
`;

export const OrderModal = ({ categoryId }) => {
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
        </SelectedProduct>

        <RelatedProducts categoryId={categoryId} />
      </OrderModalWrapper>
    </ModalBackGround>
  );
};
