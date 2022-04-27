import ReactDOM from 'react-dom';
import * as S from './Portal.style';

import { PORTAL_WRAPPER_ID } from '../../constants/productDetailModal';

const Portal = ({ modalType, children, toggleModal, modalRef }) => {
  const wrapperEl = document.getElementById(PORTAL_WRAPPER_ID);
  return ReactDOM.createPortal(
    <S.Background modalType={modalType} onClick={toggleModal} ref={modalRef}>
      {children}
    </S.Background>,
    wrapperEl,
  );
};

export default Portal;
