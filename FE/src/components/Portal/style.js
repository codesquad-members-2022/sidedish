import styled from "styled-components";

export const Modal = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 11;
  width: 100%;
  height: 100%;
`;

export const ModalContext = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
  z-index: 10;
  width: 960px;
  height: 992px;
  border: 1px solid;
  background: white;
`;

export const ModalContenxtClose = styled.div`
  display: flex;
  justify-content: flex-end;
  width: 100%;
  button {
    margin: 25px 25px 0 0;
    padding: 10px 15px;
  }
`;

export const ModalContextMain = styled.div`
  display: flex;
  padding: 1rem;
`;

export const ModalBackground = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  background: black;
  opacity: 0.5;
`;
