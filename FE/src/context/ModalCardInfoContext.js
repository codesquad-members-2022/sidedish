import { useState } from 'react';

import ModalInfoContextStore from '../stores/ModalInfoStore';

const CardInfoContext = (props) => {
  const [cardInfo, setCardInfo] = useState([]);
  const [modalDisplay, setModalDisplay] = useState('none');

  const ModalInfo = {
    cardInfo,
    modalDisplay,
    setModalDisplay,
    setCardInfo,
  };

  return (
    <ModalInfoContextStore.Provider value={ModalInfo}>
      {props.children}
    </ModalInfoContextStore.Provider>
  );
};
export default CardInfoContext;
