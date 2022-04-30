import { useContext, useState } from 'react';
import styled from 'styled-components';

import ModalInfoContextStore from '../../stores/ModalInfoStore';

const ProductImgWrap = styled.div`
  width: 48.5%;
  height: 90%;
  margin-top: 4.5%;
`;

const TopImg = styled.img`
  width: 100%;
  height: 83%;
`;

const ThumbImgWrap = styled.div`
  display: flex;
  width: 100%;

  margin-top: 2%;
  justify-content: flex-start;
  align-items: center;
`;

const ThumbImg = styled.img`
  width: 16.5%;
  height: 92%;
  cursor: pointer;
  margin-right: 4.5%;
`;

const ProductImg = () => {
  const ModalInfo = useContext(ModalInfoContextStore);
  const [mainImageUrl, setMainImageUrl] = useState(ModalInfo.topImg);
  const [thumbImages, setThumbImages] = useState(ModalInfo.thumbImg);

  const handleSubImages = (idx) => {
    const newThumbImages = thumbImages.filter((_, i) => i !== idx);
    setThumbImages([...newThumbImages, mainImageUrl]);
  };

  return (
    <ProductImgWrap>
      <TopImg src={mainImageUrl} />
      <ThumbImgWrap>
        {ModalInfo.thumbImg.map((subImageUrl, idx) => (
          <ThumbImg
            onClick={({ target }) => {
              setMainImageUrl(target.src);
              handleSubImages(idx);
            }}
            key={subImageUrl + idx}
            src={subImageUrl}
          />
        ))}
      </ThumbImgWrap>
    </ProductImgWrap>
  );
};

export default ProductImg;
