import React from 'react';
import styled from 'styled-components';

import { flexCenter } from '../css/mixins';

const Button = ({ className, icon, onClick }) => {
  return (
    <StyledButton className={className} onClick={onClick}>
      {icon}
    </StyledButton>
  );
};

const StyledButton = styled.button`
  ${flexCenter}
  cursor: pointer;
  border: none;
  background-color: transparent;
`;

export default Button;
