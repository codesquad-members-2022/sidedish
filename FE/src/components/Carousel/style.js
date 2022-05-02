import styled from "styled-components";
import { ReactComponent as AngleLeftSvg } from "assets/angle-left.svg";
import { ReactComponent as AngleRigthSvg } from "assets/angle-right.svg";

export const Container = styled.div`
  position: relative;
  display: flex;
  justify-content: space-around;
  align-items: center;
  width: 100%;
  svg {
    cursor: pointer;
  }
`;

export const CarouselContainer = styled.div`
  width: 100%;
  overflow: hidden;
  ul {
    display: flex;
    justify-content: flex-start;
    transform: translateX(${({ currentDisplay }) => currentDisplay + "px"});
    transition: transform ease-in-out 1s;
    gap: ${({ gap }) => gap}px;
  }
`;

export const IndexStatusContainer = styled.ul`
  position: absolute;
  top: -10%;
  right: ${({ gap }) => gap}px;
  display: flex;
  li {
    background-color: ${({ theme: { color } }) => color.grey4};
    width: 48px;
    height: 20px;
    margin-left: 8px;
    &:nth-child(${({ activeIndex }) => activeIndex + 1}) {
      background-color: ${({ theme: { color } }) => color.grey2};
    }
  }
`;

export const AngleLeft = styled(AngleLeftSvg)`
  fill: #bcbcbc;
  position: absolute;
  top: 50%;
  left: -50px;
  width: 50px;
  height: 50px;
  z-index: 5;
  &:hover {
    fill: #1b1b1b;
  }
`;
export const AngleRight = styled(AngleRigthSvg)`
  fill: #bcbcbc;
  position: absolute;
  top: 50%;
  right: -50px;
  width: 50px;
  height: 50px;
  z-index: 5;
  &:hover {
    fill: #1b1b1b;
  }
`;
