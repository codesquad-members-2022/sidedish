import { useContext } from 'react';
import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import Text from '../Text';
import OrderButton from './OrderButton';
import ProductImg from './ProductImg';
import ProductInfo from './ProductInfo';
import TotalAmount from './TotalAmount';
import TotalCost from './TotalCost';

const ProductDetailWrap = styled.div`
  width: 100%;
  height: 60%;
  background-color: ${colors.white};
  display: flex;
  padding-top: 2%;
  padding-right: 3%;
  padding-left: 3%;
  justify-content: space-between;
`;

const Close = styled.div`
  cursor: pointer;
  text-align: right;
`;
const ProductInfoWrap = styled.div`
  display: flex;
  flex-direction: column;
  width: 48.5%;
`;

const AmountAndCost = styled.div`
  display: flex;
  margin-top: 6%;
  justify-content: space-between;
`;

const ProductDetail = () => {
  const ModalInfo = useContext(ModalInfoContextStore);
  const onCloseClick = () => {
    if (ModalInfo.modalDisplay === 'block') {
      ModalInfo.setModalDisplay('none');
      ModalInfo.setModalDetail('');
    }
    ModalInfo.setAmount(1);
  };
  return (
    <ProductDetailWrap>
      <ProductImg />
      <ProductInfoWrap>
        <Close onClick={onCloseClick}>
          <Text font={FONT.MEDIUM}>닫기</Text>
        </Close>
        <ProductInfo />
        <AmountAndCost>
          <TotalAmount />
          <TotalCost />
        </AmountAndCost>
        <OrderButton />
      </ProductInfoWrap>
    </ProductDetailWrap>
  );
};

export default ProductDetail;
