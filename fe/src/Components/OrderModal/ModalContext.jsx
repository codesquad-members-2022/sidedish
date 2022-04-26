import { createContext, useState } from 'react';

export const ModalContext = createContext(null);

export const ModalStore = props => {
  const [ModalDisplay, setModalDisplay] = useState(true);
  return (
    <ModalContext.Provider value={[ModalDisplay, setModalDisplay]}>
      {props.children}
    </ModalContext.Provider>
  );
};
