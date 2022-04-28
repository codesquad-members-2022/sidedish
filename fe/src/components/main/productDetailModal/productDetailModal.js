import { CloseBtn } from './closeBtn/closeBtn';
import { DetailArea } from './detailArea/detailArea';
import { ImgArea } from './imgArea/imgArea';
import { DimLayer, ModalArea, ProductArea } from './productDetailModal.styled';
import { RecommendArea } from './recommendArea/recommendArea';

export function ProductDetailModal({ sideDishData, setModal }) {
  if (!sideDishData) {
    return;
  }
  return (
    <DimLayer>
      <ModalArea flex direction="column">
        <ProductArea flex>
          <ImgArea urls={sideDishData.imageUrls}></ImgArea>
          <DetailArea props={sideDishData}></DetailArea>
        </ProductArea>
        <RecommendArea></RecommendArea>
        <CloseBtn onClick={setModal}></CloseBtn>
      </ModalArea>
    </DimLayer>
  );
}
