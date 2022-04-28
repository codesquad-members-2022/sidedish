import { DetailArea } from './imgArea/detailArea/detailArea';
import { ImgArea } from './imgArea/imgArea';
import { DimLayer, ModalContainer } from './productDetailModal.styled';

export function ProductDetailModal({ sideDishData }) {
  sideDishData = mockData;
  return (
    <DimLayer>
      <ModalContainer flex>
        <ImgArea urls={sideDishData.imageUrls}></ImgArea>
        <DetailArea props={sideDishData}></DetailArea>
      </ModalContainer>
    </DimLayer>
  );
}

var mockData = {
  sideDishId: 19,
  imageUrls: [
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_1.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_2.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_3.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_1.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_2.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_1.png',
    'https://naneun-220320.s3.ap-northeast-2.amazonaws.com/terria/%EB%AF%B8%EC%97%AD%EC%B4%88%EB%AC%B4%EC%B9%A8_2.png',
  ],
  name: '미역초무침',
  description: '새콤달콤 부들부들한 식감의',
  disCountPrice: 3150,
  price: 3500,
  stock: 3,
  accumulatedAmount: 35,
  shippingInfo: '서울 경기 새벽 배송, 전국 택배 배송',
  shippingFee: 2500,
  exemptionCondition: 40000,
  discountEventResponses: [
    {
      discountEventId: 1,
      title: '이벤트특가',
    },
  ],
};
