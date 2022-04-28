import styled from 'styled-components';

export const SubImgWrapper = styled.div`
  margin-top: 8px;
  overflow: hidden;
  img {
    margin-right: 8px;
  }
  img:nth-child(5n) {
    margin-right: 0;
  }
`;

export const SubImg = styled.img`
  ${({ src }) => {
    return `
      src: ${src}
    `;
  }};
  width: 72px;
  height: 72px;
`;
