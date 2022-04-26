import React from 'react';
import styled from 'styled-components';

const Button = ({ className, icon, disabled, onClick }) => {
  return (
    <StyledButton disabled={disabled} className={className} onClick={onClick}>
      {icon}
    </StyledButton>
  );
};

const StyledButton = styled.button`
  cursor: pointer;
  border: none;
  background-color: transparent;
`;

export default Button;
