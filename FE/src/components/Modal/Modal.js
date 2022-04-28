import { useContext } from 'react';
import styled from 'styled-components';

import ModalInfoContextStore from '../../stores/ModalInfoStore';

const ModalWrap = styled.div`
  box-sizing: border-box;
  position: fixed;
  width: 46.25rem;
  height: 47.8rem;
  top: 50%;
  margin-top: -23.9rem;
  left: 50%;
  margin-left: -23.125rem;
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

const Modal = ({ ModalDetail }) => {
  const ModalInfo = useContext(ModalInfoContextStore);
  return (
    <ModalLayer modalDisplay={ModalInfo.modalDisplay}>
      <ModalWrap>{ModalDetail}</ModalWrap>
    </ModalLayer>
  );
};

export default Modal;
