import styled from "styled-components";

export const Line = styled.div`
  width: 100%;
  height: 1px;
  background: ${({ theme, color }) => theme.colors[color || "Grey4"]};
`;
export const HorizontalLine = styled(Line)`
  position: absolute;
  left: 0vw;
  top: ${({ position }) => `${position}%`};
`;
