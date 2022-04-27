import styled from "styled-components";

export const Container = styled.main`
  width: ${({ theme: { layout } }) => layout.mainWidth};
  margin: 0 auto;
`;
