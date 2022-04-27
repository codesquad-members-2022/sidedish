import * as S from './ProductDetailModal.style';

import Portal from '../portal/Portal';
import ProductImages from './ProductImages';
import ProductInfo from './ProductInfo';
import ProductOrder from './ProductOrder';

const ProductDetailModal = ({ productDetail, toggleModal }) => {
  const { orderable, images, menuName, originalPrice, discountedPrice, point, event } =
    productDetail;

  const PORTAL_WRAPPER_ID = 'productDetailModal';
  const BLACK = 'black';

  const modal = (
    <S.Wrapper>
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
          />
        </S.ProductDetailContainer>

        <S.HorizontalLine color={BLACK} size={2} />

        <S.RelateProductContainer>{/* 연관상품 슬라이더 */}</S.RelateProductContainer>
      </S.Modal>
      <S.Background onClick={toggleModal} />
    </S.Wrapper>
  );

  return <Portal children={modal} wrapperId={PORTAL_WRAPPER_ID} />;
};

export default ProductDetailModal;
