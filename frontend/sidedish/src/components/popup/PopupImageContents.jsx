import styled from "styled-components";

const PopupImageContents = ({ images }) => {
  return (
    <>
      <ImageContainer>
        <MainImage src={images[0]}></MainImage>
        <ImageList>
          {images.map((src, key) => (
            <Image src={src} key={key} />
          ))}
        </ImageList>
      </ImageContainer>
    </>
  );
};

const ImageContainer = styled.div`
  display: flex;
  flex-direction: column;
`;

const MainImage = styled.img`
  width: 392px;
  padding-right: 32px;
`;

const ImageList = styled.div`
  display: flex;
`;

const Image = styled.img`
  width: 72px;
  padding: 8px 8px 0 0;
`;

export default PopupImageContents;
