import { useContext } from 'react';
import styled from 'styled-components';

import colors from '../../constants/colors';
import { FONT } from '../../constants/fonts';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import Text from '../Text';

const SIZE_OF_ORIGIN = 596;
const REDUCTION_RATIO = 1.3;

const ProductDetailWrap = styled.div`
  position: absolute;
  width: 100%;
  height: calc(${SIZE_OF_ORIGIN}px / ${REDUCTION_RATIO});
  background-color: ${colors.offWhite};
`;

const Close = styled.div`
  width: 36px;
  height: 30px;
  position: absolute;
  top: 32px;
  left: 650px;
  cursor: pointer;
`;
const ProductDetail = () => {
  const ModalInfo = useContext(ModalInfoContextStore);
  const onCloseClick = () => {
    if (ModalInfo.modalDisplay === 'block') {
      ModalInfo.setModalDisplay('none');
    }
  };
  return (
    <ProductDetailWrap>
      <Close onClick={onCloseClick}>
        <Text font={FONT.MEDIUM}>닫기</Text>
      </Close>
    </ProductDetailWrap>
  );
};

export default ProductDetail;
