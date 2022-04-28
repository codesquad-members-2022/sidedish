import React from 'react';
import styled from 'styled-components';

import { color } from '../css/variables';

const Modal = ({ children }) => {
  return <StyledModal>{children}</StyledModal>;
};

const StyledModal = styled.div`
  position: absolute;
  border: 1px solid ${color.greyOne};
  font-size: 30px;
  background-color: white;
  top: 20%;
  left: 10%;
  width: 1066px;
  height: 962px;
  z-index: 10;
`;

export default Modal;
