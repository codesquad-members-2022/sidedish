import { ReactComponent as deliveryIcon } from "../../asset/deliveryIcon.svg";
import svgStyles from "../../style/svgStyles";
import styled, { css } from "styled-components";

const DeliveryIcon = styled(deliveryIcon)`
  ${(props) => svgStyles(props)};
  position: absolute;
  right: 10px;
  top: 10px;
  display: none;
  ${({ size }) =>
    size === "small" &&
    css`
      width: 100px;
      height: 100px;
    `}};
`;

export default DeliveryIcon;
