import styled from "styled-components";
import { ReactComponent as AngleLeftSvg } from "assets/angle-left.svg";
import { ReactComponent as AngleRigthSvg } from "assets/angle-right.svg";

export const Container = styled.div`
  display: flex;
  justify-content: space-around;
  align-items: center;
`;

export const AngleLeft = styled(AngleLeftSvg)`
  &:hover {
    fill: #1b1b1b;
  }
  fill: #bcbcbc;
`;
export const AngleRigth = styled(AngleRigthSvg)`
  &:hover {
    fill: #1b1b1b;
  }
  fill: #bcbcbc;
`;
