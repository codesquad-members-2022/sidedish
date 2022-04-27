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
  left: 15%;
  top: 10%;
  width: 75%;
  height: 70%;
  z-index: 10;
`;

export default Modal;
