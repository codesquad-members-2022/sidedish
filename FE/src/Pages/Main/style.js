import styled from "styled-components";

export const Container = styled.main`
  width: ${({ theme: { layout } }) => layout.mainWidth};
  padding-top: 140px;
  margin: 0 auto;
`;
