import React from "react";
import ModalPortal from "@/Portal.js";
import ModalContents from "@/components/organisms/ModalContents/ModalContents.jsx";
import "./Modal.scss";

const Modal = ({ card, handleModalOff, handleModal }) => {
  return (
    <ModalPortal>
      <div className="modal-background">
        <ModalContents
          card={card}
          handleModalOff={handleModalOff}
          handleModal={handleModal}
        />
      </div>
    </ModalPortal>
  );
};

export default Modal;
