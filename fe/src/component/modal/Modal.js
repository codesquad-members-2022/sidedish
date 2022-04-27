import React, { useState } from "react";

import styled from "styled-components";
import ProductDetails from "./ProductDetail";
import ModalSlider from "./ModalSlider";

const ModalWrapper = styled.div`
  width: 900px;
  height: 794px;
  border: 1px solid #000;
  position: absolute;
  background: #fff;
  top: 20%;
  left: 20%;
  padding: 50px 30px;

  &.hidden {
    display: none;
  }
`;

const ModalCloseButton = styled.button`
  position: absolute;
  top: 2%;
  left: 92%;
  font-size: 16px;
  color: #777;
`;

const Modal = () => {
  const [isDisplayed, setIsDisplayed] = useState(true);
  const closeBtnClickHandler = () => {
    setIsDisplayed(false);
  };
  return (
    <ModalWrapper className={isDisplayed ? "" : "hidden"}>
      <ProductDetails />
      <ModalSlider />
      <ModalCloseButton onClick={closeBtnClickHandler}>닫기</ModalCloseButton>
    </ModalWrapper>
  );
};

export default Modal;
