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
  background: #ffffff;
  border: 1px solid #000000;
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
  color: #010101;
`;
const Button = styled.button`
  width: 100%;
  height: 44px;
  background: #1b1b1b;

  font-weight: 500;
  font-size: 16px;
  line-height: 26px;
  color: #ffffff;
`;
export default Alert;
