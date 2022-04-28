import React, { useState, useEffect, useContext } from "react";
import ReactDOM from "react-dom";
import styled from "styled-components";
import ProductDetails from "./ProductDetail";
import ModalSlider from "./ModalSlider";
import { ModalContext } from "../../store/store";
import { myfetch } from "../../utils/utils";

const ModalWrapper = styled.div`
  width: 900px;
  height: 794px;
  border: 1px solid #000;
  position: absolute;
  background: #fff;
  top: 20%;
  left: 20%;
  padding: 50px 30px;
  z-index: 99;
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
  const ctx = useContext(ModalContext);
  const onClickHandler = () => {
    ctx.setModalIsDisplayed(false);
  };

  const [modalInfor, setModalInfor] = useState([]);

  useEffect(() => {
    myfetch(
      `http://15.165.204.34:8080/api/v1/products/${ctx.clickedId}/detail`
    ).then((data) => setModalInfor(data.data));
  }, [ctx.clickedId]);

  return (
    <>
      {ReactDOM.createPortal(
        <ModalWrapper className={ctx.isDisplayed ? "" : "hidden"}>
          <ProductDetails data={modalInfor} />
          <ModalSlider />
          <ModalCloseButton onClick={onClickHandler}>닫기</ModalCloseButton>
        </ModalWrapper>,
        document.getElementById("modal")
      )}
    </>
  );
};
export default Modal;
