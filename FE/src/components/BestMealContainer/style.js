import styled, { css } from "styled-components";

export const Container = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 16px;
`;

export const Header = styled.header`
  display: flex;
  align-items: flex-start;
  gap: 16px;

  > div {
    width: 76px;
    height: 42px;
    background: ${({ theme }) => theme.color.offWhite};
    border: 2px solid ${({ theme }) => theme.color.black};
    box-sizing: border-box;
    border-radius: 20px;
    line-height: 42px;
    text-align: center;
  }

  > h2 {
    font-size: ${({ theme }) => theme.fontSize.biggest};
    font-weight: ${({ theme }) => theme.fontWeight.display};
  }
`;

export const TitleBadge = styled.div``;

export const Nav = styled.ul`
  display: flex;
  gap: 32px;

  > li {
    cursor: pointer;
  }
`;

export const Divider = styled.div`
  width: 100%;
  height: 1px;
  margin-bottom: 16px;
  background-color: ${({ theme: { color } }) => color.grey4};
  z-index: -1;
`;

export const Tab = styled.li`
  cursor: pointer;
  font-size: ${({ theme: { fontSize } }) => fontSize.large};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.display};
  ${({ isSelected, theme }) =>
    isSelected &&
    css`
      text-decoration: underline;
      text-underline-offset: 16px;
      text-decoration-color: ${theme.color.black};
    `}
`;

export const CardContainer = styled.div`
  display: flex;
  gap: 16px;
`;
