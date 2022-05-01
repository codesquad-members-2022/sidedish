import reactDom from "react-dom";

const ModalPortal = ({ children }) => {
  const modal = document.getElementById("modal");
  return reactDom.createPortal(children, modal);
};

const AlertPortal = ({ children }) => {
  const alertPopup = document.getElementById("alertPopup");
  return reactDom.createPortal(children, alertPopup);
};

export { ModalPortal, AlertPortal };
