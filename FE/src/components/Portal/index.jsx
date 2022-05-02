import React, { useEffect, useRef, useState } from "react";
import { createPortal } from "react-dom";
import { Modal, ModalBackground, ModalContenxtClose, ModalContext, ModalContextMain } from "./style";

const ModalPortal = ({ children, closePortal }) => {
  const [mounted, setMounted] = useState(false);
  const ref = useRef(null);

  useEffect(() => {
    setMounted(true);
    if (document) {
      const parentDom = document.getElementById("root-modal");
      ref.current = parentDom;
    }
    return () => {
      setMounted(false);
    };
  }, []);

  if (ref.current && mounted) {
    return createPortal(
      <Modal>
        <ModalBackground role="presentation" onClick={closePortal} />
        <ModalContext>
          <ModalContenxtClose>
            <button onClick={closePortal}>닫기</button>
          </ModalContenxtClose>
          <ModalContextMain>{children}</ModalContextMain>
        </ModalContext>
      </Modal>,
      ref.current
    );
  }
  return <></>;
};

export default ModalPortal;
