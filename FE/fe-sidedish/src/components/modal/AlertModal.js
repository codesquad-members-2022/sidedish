import * as S from './Modal.style';

import { MODAL_TYPE } from '../../constants/portal';

import Portal from '../portal/Portal';

const AlertModal = ({ alertContent, setIsAlertModalOpen }) => {
  const closeAlertModal = () => setIsAlertModalOpen(false);

  return (
    <Portal modalType={MODAL_TYPE.ALERT}>
      <S.Modal>
        <S.Content>{alertContent}</S.Content>
        <S.CloseButton onClick={closeAlertModal}>확인</S.CloseButton>
      </S.Modal>
    </Portal>
  );
};

export default AlertModal;
