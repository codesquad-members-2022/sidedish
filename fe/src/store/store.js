import React, { createContext } from "react";

const ModalContext = createContext({
  isDisplayed: false,
  clickedCardId: 1,
});

export { ModalContext };
