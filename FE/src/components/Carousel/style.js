import styled from "styled-components";
import { ReactComponent as AngleLeftSvg } from "assets/angle-left.svg";
import { ReactComponent as AngleRigthSvg } from "assets/angle-right.svg";

export const Container = styled.div`
  position: relative;
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
`;

export const CarouselContainer = styled.div`
  width: 100%;
  display: flex;
  overflow: hidden;
  justify-content: flex-start;
  gap: ${({ gap }) => gap}px;
`;

export const AngleLeft = styled(AngleLeftSvg)`
  fill: #bcbcbc;
  position: absolute;
  top: 50%;
  left: -20px;
  &:hover {
    fill: #1b1b1b;
  }
`;
export const AngleRigth = styled(AngleRigthSvg)`
  fill: #bcbcbc;
  position: absolute;
  top: 50%;
  right: -20px;
  &:hover {
    fill: #1b1b1b;
  }
`;
