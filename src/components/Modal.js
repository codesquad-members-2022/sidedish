import React from 'react';
import styled from 'styled-components';

import { color, modal } from '../css/variables';

const Modal = ({ children }) => {
  return <StyledModal>{children}</StyledModal>;
};

const StyledModal = styled.div`
  position: absolute;
  border: 1px solid ${color.greyOne};
  font-size: 30px;
  background-color: white;
  top: 20%;
  width: ${modal.width}px;
  height: 962px;
  z-index: 10;
`;

export default Modal;
