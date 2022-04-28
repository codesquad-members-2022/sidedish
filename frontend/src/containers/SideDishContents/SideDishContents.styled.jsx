import styled from 'styled-components';

const StyledSideDishContents = styled.div`
  margin: 0 auto;
  width: 1280px;
`;

const PrevButton = styled.button`
  position: absolute;
  margin-top: 200px;
  background-color: transparent;
  border: none;

  left: 36px;
`;

const NextButton = styled.button`
  position: absolute;
  margin-top: 200px;
  background-color: transparent;
  border: none;

  right: 36px;
`;

export {StyledSideDishContents, PrevButton, NextButton};
