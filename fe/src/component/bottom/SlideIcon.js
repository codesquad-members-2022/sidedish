import React from "react";
import { ReactComponent as leftIcon } from "../../asset/leftIcon.svg";
import { ReactComponent as rightIcon } from "../../asset/rightIcon.svg";

import styled, { css } from "styled-components";

const StyledleftIcon = styled(leftIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  left: 15px;
  top: 100%;
  color: ${({ isleft }) => (isleft ? "black" : "red")};
`;

const StyledrightIcon = styled(rightIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  top: 100%;
  left: 1330px;
  color: ${({ isright }) => (isright ? "black" : "red")};
`;

const svgStyles = ({ height, width }) => {
  return css`
    height: ${height};
    width: ${width};
  `;
};

const SlideIcon = ({
  onSaveClickedDirection,
  onSaveClickedDirection2,
  isright,
  isleft,
}) => {
  return (
    <>
      <StyledleftIcon onClick={onSaveClickedDirection2} isleft={isleft} />
      <StyledrightIcon onClick={onSaveClickedDirection} isright={isright} />
    </>
  );
};

export default SlideIcon;
