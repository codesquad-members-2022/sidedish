import styled from "styled-components";

export const Header = styled.h2`
  color: ${({ theme: { color } }) => color.grey1};
  font-size: ${({ theme: { fontSize } }) => fontSize.xLarge};
  font-weight: ${({ theme: { fontWeight } }) => fontWeight.bold};
  line-height: 38px;
  letter-spacing: -0.008em;
  margin-bottom: 40px;
`;

export const Container = styled.div`
  /* TODO: figma 값을 그대로 복사했는데 매직넘버는 다시 고려해보기 */
  width: 100%;
  height: 557px;
  margin: 0 auto;
`;
