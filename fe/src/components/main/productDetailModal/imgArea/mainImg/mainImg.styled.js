import styled from 'styled-components';

export const StyledImg = styled.img`
  ${({ src }) => {
    return `
      src: ${src}
    `;
  }};
  width: 392px;
  height: 392px;
`;
