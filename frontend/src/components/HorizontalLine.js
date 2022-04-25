import styled from "styled-components";

export const HorizontalLine = styled.div`
  position: absolute;
  width: 100%;
  height: 1px;
  left: 0vw;
  ${({ position }) => (position === "top" ? "top: 0px" : "bottom:0px")};
  background-color: ${({ color, theme }) => theme.colors[color]};
`;
