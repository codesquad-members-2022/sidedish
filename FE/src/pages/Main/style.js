import styled from "styled-components";

export const Container = styled.main`
  width: ${({ theme: { layout } }) => layout.mainWidth};
  padding-top: 140px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

export const MoreBtn = styled.button`
  margin-top: 80px;
  padding: 16px 24px;
  width: 153px;
  height: 62px;
  font-size: ${({ theme: { fontSize } }) => fontSize.large};
  border: 1px solid ${({ theme: { color } }) => color.grey4};
  background-color: ${({ theme: { color } }) => color.white};
  border-radius: 10px;

  &:hover {
    background-color: ${({ theme: { color } }) => color.grey4};
  }
`;
