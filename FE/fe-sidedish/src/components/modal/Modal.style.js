import styled from 'styled-components';

const Background = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
`;

const Container = styled.div`
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

export { Background, Container, Content, CloseButton };
