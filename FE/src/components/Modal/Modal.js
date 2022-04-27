import { useContext } from 'react';
import styled from 'styled-components';

import ModalInfoContextStore from '../../stores/ModalInfoStore';
import ProductDetail from './ProductDetail';

const HEIGHT_SIZE_OF_ORIGIN = 994;
const WIDTH_SIZE_OF_ORIGIN = 960;
const REDUCTION_RATIO = 1.3;
const HALF_OF_SIZE = 2;

const MainModal = styled.div`
  position: relative;
  background-color: white;
  width: 100%;
  height: 100%;
  margin: auto;
`;

const ModalWrap = styled.div`
  box-sizing: border-box;
  position: fixed;
  width: calc(${WIDTH_SIZE_OF_ORIGIN}px / ${REDUCTION_RATIO});
  height: calc(${HEIGHT_SIZE_OF_ORIGIN}px / ${REDUCTION_RATIO});
  top: 50%;
  margin-top: calc(
    ${HEIGHT_SIZE_OF_ORIGIN}px / ${REDUCTION_RATIO} / -${HALF_OF_SIZE}
  );
  left: 50%;
  margin-left: calc(
    ${WIDTH_SIZE_OF_ORIGIN}px / ${REDUCTION_RATIO} / -${HALF_OF_SIZE}
  );
  border: 2px solid #000000;
`;

const ModalLayer = styled.div`
  position: fixed;
  top: 0;
  display: none;
  z-index: 3;
  width: 100vw;
  height: 100vw;
  display: ${(props) => props.modalDisplay};
  background: ${(props) =>
    props.modalDisplay === 'block' ? 'rgba(0, 0, 0, 0.52)' : 'transparent'};
`;

const Modal = () => {
  const ModalInfo = useContext(ModalInfoContextStore);
  return (
    <ModalLayer modalDisplay={ModalInfo.modalDisplay}>
      <ModalWrap>
        <MainModal>
          <ProductDetail />
          {/* <relatedProduct /> */}
        </MainModal>
      </ModalWrap>
    </ModalLayer>
  );
};

export default Modal;
