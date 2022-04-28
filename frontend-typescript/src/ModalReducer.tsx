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

export const ModalContext = createContext<State >({openedId:});
export const ModalProvider = ({ children }: { children: React.ReactNode }) => {
  const [openedId, setOpenedId] = useState<number>(-1);
  return (
    <ModalContext.Provider value={{ openedId, setOpenedId }}>
      {children}
    </ModalContext.Provider>
  );
};
