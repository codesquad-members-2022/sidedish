import React from 'react';
import styled from 'styled-components';

const ImgWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 32px;

  .first {
    ${({ theme }) => theme.modalImgSize.main};
    margin-bottom: 8px;
  }

  img {
    ${({ theme }) => theme.modalImgSize.side};
    background: ${({ theme }) => theme.colors.gray3};
  }
`;

const Grid = styled.div`
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  grid-column-gap: 8px;
`;

const ModalImgWrapper = ({ title, images }) => {
  const [mainImage, ...subImages] = images;

  return (
    images && (
      <ImgWrapper>
        <img src={mainImage.path} alt={title} className="first" />
        <Grid>
          {subImages.map((image) => (
            <img key={image.id} src={image.path} alt="" />
          ))}
        </Grid>
      </ImgWrapper>
    )
  );
};

export default React.memo(ModalImgWrapper);
