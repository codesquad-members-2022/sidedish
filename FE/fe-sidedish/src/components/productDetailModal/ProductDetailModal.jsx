import React, { useState } from 'react';
import * as S from './ProductDetailModal.style';

import { COLOR, LINE_SIZE } from '../../constants/productDetailModal';
import { CARD_SIZE } from '../../constants/card';
import { MODAL_TYPE } from '../../constants/portal';
import { dish10 } from '../../data/dishes';

import Portal from '../portal/Portal';
import ProductImages from './ProductImages';
import ProductInfo from './ProductInfo';
import ProductOrder from './ProductOrder';
import Category from '../category/Category';
import AlertModal from '../modal/AlertModal';

const ProductDetailModal = ({ productDetail, toggleModal, modalRef }) => {

  const [isAlertModalOpen, setIsAlertModalOpen] = useState(false);

  const { orderable, images, menuName, originalPrice, discountedPrice, point, event } =
    productDetail;

  const openAlertModal = () => setIsAlertModalOpen(true);

  return (
    <Portal type={MODAL_TYPE.PRODUCT} toggleModal={toggleModal} modalRef={modalRef}>
      <S.Modal>
        <S.CloseButton onClick={toggleModal}>닫기</S.CloseButton>
        <S.ProductDetailContainer>
          <ProductImages images={images} />
          <ProductInfo
            menuName={menuName}
            originalPrice={originalPrice}
            discountedPrice={discountedPrice}
            point={point}
            event={event}
          />
          <ProductOrder
            orderable={orderable}
            price={discountedPrice ? discountedPrice : originalPrice}
            openAlertModal={openAlertModal}
          />
        </S.ProductDetailContainer>

        <S.HorizontalLine color={COLOR.BLACK} size={LINE_SIZE.THICK} />

        <S.RelateProductContainer>
          <Category cardSize={CARD_SIZE.SMALL} {...dish10} />
        </S.RelateProductContainer>
      </S.Modal>
      {isAlertModalOpen && (
        <AlertModal
          alertContent={`오류가 발생했습니다.\n다시 주문해주세요.`}
          setIsAlertModalOpen={setIsAlertModalOpen}
        />
      )}
    </Portal>
  );
};

export default ProductDetailModal;
