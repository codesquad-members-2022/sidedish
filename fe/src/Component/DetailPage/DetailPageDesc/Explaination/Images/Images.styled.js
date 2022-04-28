import styled, { css } from "styled-components";

const ImagesDiv = styled.div`
  width: 392px;
`;

const MainImage = styled.img`
  width: 392px;
  height: 392px;
  border-radius: 8px;
`;

const SubImagesArea = styled.div`
  margin-top: 8px;
`;

const SubImage = styled.img`
  ${({ id, imageNumber, theme: { colors } }) => {
    return (
      id === imageNumber &&
      css`
        border: solid 2px ${colors.grey2};
      `
    );
  }}

  cursor: pointer;
  width: 72px;
  margin-right: 8px;
  border-radius: 8px;
`;

export { ImagesDiv, MainImage, SubImagesArea, SubImage };
