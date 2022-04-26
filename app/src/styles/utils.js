import styled from "styled-components";

export const FlexMarginCenter = styled.div`
  display: flex;
  margin: 0 auto;
`;

export const FlexCenter = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

export const Badge = styled.strong`
  box-sizing: border-box;
  display: inline-block;
  margin-right: 0.8rem;
  padding: 0.6rem 1.6rem;
  height: 3rem;
  text-align: center;
  line-height: 1.8rem;
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  border-radius: 99.9rem;
  background-color: ${({ theme, bgColor }) => theme.color[bgColor]};
  color: ${({ theme }) => theme.color.white};
`;

export const Background = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: ${({ theme }) => theme.color.black};
  opacity: 0.5;
  z-index: ${({ zIndex }) => zIndex};
`;
