import { createContext, useReducer, useState } from "react";

export const ModalContext = createContext(null);
export const ModalProvider = ({ children }) => {
  const [openedId, setOpenedId] = useState(-1);
  return (
    <ModalContext.Provider value={{ openedId, setOpenedId }}>
      {children}
    </ModalContext.Provider>
  );
};
