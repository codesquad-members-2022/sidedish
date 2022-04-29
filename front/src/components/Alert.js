import React from 'react';
import styled from 'styled-components';

function Alert({ message, hideAlert }) {
  return (
    <StyledAlert>
      <Message>{message}</Message>
      <Button onClick={hideAlert}>확인</Button>
    </StyledAlert>
  );
}

const StyledAlert = styled.div`
  width: 270px;
  background: ${({ theme }) => theme.colors.white};
  border: 1px solid ${({ theme }) => theme.colors.black};
  backdrop-filter: blur(81.55px);

  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 10;
`;
const Message = styled.div`
  margin: 16px;
  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  text-align: center;
  color: ${({ theme }) => theme.colors.black};
`;
const Button = styled.button`
  width: 100%;
  height: 44px;
  background: ${({ theme }) => theme.colors.black};

  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  color: ${({ theme }) => theme.colors.white};
`;
export default Alert;
