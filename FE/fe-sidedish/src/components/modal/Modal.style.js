import styled from 'styled-components';

const Modal = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 270px;
  height: 130px;
  border: 1px solid ${({ theme }) => theme.color.black};
  background-color: ${({ theme }) => theme.color.white};
`;

const Content = styled.p`
  display: flex;
  align-items: center;
  flex-grow: 1;
  text-align: center;
  white-space: pre-wrap;
  word-break: keep-all;
`;

const CloseButton = styled.button`
  width: 270px;
  height: 45px;
  color: ${({ theme }) => theme.color.white};
  background-color: ${({ theme }) => theme.color.black};
  margin-bottom: -2px;
`;

export { Modal, Content, CloseButton };
