import styled from 'styled-components';

import { MODAL_TYPE, MODAL_Z_INDEX } from '../../constants/portal';

const Background = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.3);
  z-index: ${({ modalType }) =>
    modalType === MODAL_TYPE.ALERT ? MODAL_Z_INDEX.ALERT : MODAL_Z_INDEX.PRODUCT};
`;

export { Background };
