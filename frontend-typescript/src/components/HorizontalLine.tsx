import styled from "styled-components";
import { themeColors } from "../styles/styled";

export const Line = styled.div<{ color?: keyof themeColors }>`
  width: 100%;
  height: 1px;
  background: ${({ theme, color }) => theme.colors[color || "Grey4"]};
`;
export const HorizontalLine = styled(Line)<{ position: number }>`
  position: absolute;
  left: 0vw;
  top: ${({ position }) => `${position}%`};
`;
