import { createContext, useReducer } from "react";

const reducer = {
  table: {
    open: (state, payload) => ({ openId: payload }),
    close: (state, payload) => ({ openId: payload }),
  },
  mapper(state, { type, payload }) {
    return this.table[type](state, payload);
  },
};
export const ModalContext = createContext(null);
export const ModalProvider = ({ children }) => {
  const [{ openId }, dispatch] = useReducer(reducer.mapper, { openId: -1 });
  return (
    <ModalContext.Provider value={{ dispatch, openId }}>
      {children}
    </ModalContext.Provider>
  );
};
