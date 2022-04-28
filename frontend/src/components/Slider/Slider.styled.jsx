import styled, {css} from "styled-components";

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

const PrevButtonIcon = styled.img`
  ${({position}) => {
    return position < 0
      ? css`
          filter: invert(0%) sepia(1%) saturate(4194%) hue-rotate(184deg) brightness(74%) contrast(79%);
        `
      : css`
          filter: invert(77%) sepia(0%) saturate(0%) hue-rotate(150deg) brightness(100%) contrast(87%);
        `;
  }}
`;

const NextButtonIcon = styled.img`
  ${({lastIndex, goodsDataLength}) => {
    return lastIndex === goodsDataLength
      ? css`
          filter: invert(77%) sepia(0%) saturate(0%) hue-rotate(150deg) brightness(100%) contrast(87%);
        `
      : css`
          filter: invert(0%) sepia(1%) saturate(4194%) hue-rotate(184deg) brightness(74%) contrast(79%);
        `;
  }}
`;

export {PrevButton, NextButton, PrevButtonIcon, NextButtonIcon};
