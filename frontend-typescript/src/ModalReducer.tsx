import React, {
  createContext,
  Dispatch,
  ReactChildren,
  useReducer,
  useState,
} from "react";

type State = {
  openedId: number;
  setOpenedId: Dispatch<React.SetStateAction<number>>;
};

export const ModalContext = createContext<State | any>(null);
export const ModalProvider = ({ children }: { children: React.ReactNode }) => {
  const [openedId, setOpenedId] = useState(-1);
  return (
    <ModalContext.Provider value={{ openedId, setOpenedId }}>
      {children}
    </ModalContext.Provider>
  );
};
