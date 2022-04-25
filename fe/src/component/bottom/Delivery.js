import React from "react";
import { ReactComponent as DeliveryIcon } from "../../asset/deliveryIcon.svg";
import svgStyles from "../../style/svgStyles";
import styled from "styled-components";

const StyledDeliveryIcon = styled(DeliveryIcon)`
  ${(props) => svgStyles(props)};
  position: absolute;
  right: 10px;
  top: 10px;
  z-index: 99;
  display: none;
  &.active {
    display: block;
  }
`;

export default StyledDeliveryIcon;
