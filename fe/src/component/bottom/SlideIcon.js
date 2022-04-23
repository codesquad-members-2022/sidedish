import React from "react";
import { ReactComponent as leftIcon } from "../../asset/leftIcon.svg";
import { ReactComponent as rightIcon } from "../../asset/rightIcon.svg";

import styled, { css } from "styled-components";

const StyledleftIcon = styled(leftIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  left: -20px;
  top: 160px;
`;

const StyledrightIcon = styled(rightIcon)`
  ${(props) => svgStyles(props)}
  position: absolute;
  right: 10px;
  top: 160px;
`;

const svgStyles = ({ height, width }) => {
  return css`
    height: ${height};
    width: ${width};
  `;
};

const SlideIcon = () => {
  return (
    <>
      <StyledleftIcon />
      <StyledrightIcon />
    </>
  );
};

export default SlideIcon;
