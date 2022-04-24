import React from 'react';
import styled from 'styled-components';

import { flexCenter } from '../css/mixins';
import { slideBtn } from '../css/variables';

const Button = ({ icon, onClick }) => {
  return <StyledButton onClick={onClick}>{icon}</StyledButton>;
};

const StyledButton = styled.button`
  ${flexCenter}
  cursor: pointer;
  border: none;
  background-color: transparent;
  font-size: ${slideBtn.size}px;
  margin: 210px ${slideBtn.margin}px 0 0;
  padding: 0px;
  height: 0px;
`;

export default Button;
