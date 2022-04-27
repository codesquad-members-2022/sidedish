import { createPortal } from 'react-dom';
import { Background, Container, Content, CloseButton } from './Modal.style';

const AlertModal = ({ alertContent, setIsAlertModalOpen }) => {

  const closeAlertModal = () => setIsAlertModalOpen(false);

  return createPortal(
    <Background>
      <Container>
        <Content>{alertContent}</Content>
        <CloseButton onClick={closeAlertModal}>확인</CloseButton>
      </Container>
    </Background>,
    document.getElementById('portal'),
  );
};

export default AlertModal;
