import React from 'react';
import ReactDom from 'react-dom';
import styled from 'styled-components';

const ModalWrapper = styled.div`
  display: ${(props) => (props.visible ? 'block' : 'none')};
  position: fixed;
  max-width: 960px;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 1000;
  overflow: auto;
  outline: 0;
  margin: 0 auto;
`;

const ModalOverlay = styled.div`
  display: ${(props) => (props.visible ? 'block' : 'none')};
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  z-index: 999;
  background-color: rgba(0, 0, 0, 0.6);
`;

const ModalInner = styled.div`
  position: relative;
  top: 50%;
  margin: 0 auto;
  padding: 32px 48px 0 48px;
  transform: translateY(-50%);
  background-color: #fff;
  box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.5);
`;

const ModalCloseBtnWrapper = styled.div`
  text-align: right;
`;

const ModalCloseBtn = styled.button`
  border: none;
  background: transparent;
  ${({ theme }) => theme.fontStyles.mediumRegular};
  color: ${({ theme }) => theme.colors.gray2};
  cursor: pointer;
`;

const Modal = ({ className, visible, children, onClose }) => {
  return ReactDom.createPortal(
    <>
      <ModalOverlay visible={visible} />
      <ModalWrapper className={className} visible={visible}>
        <ModalInner tabIndex="0" className="modal-inner">
          <ModalCloseBtnWrapper>
            <ModalCloseBtn onClick={onClose}>닫기</ModalCloseBtn>
          </ModalCloseBtnWrapper>
          {children}
        </ModalInner>
      </ModalWrapper>
    </>,
    document.querySelector('#modal-root')
  );
};

export default React.memo(Modal);
