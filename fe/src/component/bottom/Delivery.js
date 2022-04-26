import React from "react";
import { ReactComponent as DeliveryIcon } from "../../asset/deliveryIcon.svg";
import svgStyles from "../../style/svgStyles";
import styled, { css } from "styled-components";

const StyledDeliveryIcon = styled(DeliveryIcon)`
  ${(props) => svgStyles(props)};
  position: absolute;
  right: 10px;
  top: 10px;
  z-index: 99;
  display: none;
  ${(props) =>
    props.size === "small" &&
    css`
      width: 100px;
      height: 100px;
    `}};
`;

export default StyledDeliveryIcon;
