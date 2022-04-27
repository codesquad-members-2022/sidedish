import { useState } from 'react';
import * as S from './ProductDetailModal.style';

const ProductImages = ({ images }) => {
  const INITIAL_MAIN_IMAGE_ID = 1;
  const MAIN_IMAGE_SIZE = 390;
  const IMAGE_WIDTH = 72;
  const LEFT = 'left';

  const [mainImageId, setMainImageId] = useState(INITIAL_MAIN_IMAGE_ID);

  const getImageSrc = id =>
    images.reduce((src, image) => {
      if (image.id === id) src = image.src;
      return src;
    }, '');

  return (
    <S.FloatContainer direction={LEFT}>
      <S.Image src={getImageSrc(mainImageId)} alt='큰이미지' size={MAIN_IMAGE_SIZE} />
      <S.ImageList>
        {images.map(({ id, src }) => (
          <li key={id} onClick={() => setMainImageId(id)}>
            <S.Image
              src={src}
              alt={`상품이미지${id}`}
              size={IMAGE_WIDTH}
              isMain={id === mainImageId}
            />
          </li>
        ))}
      </S.ImageList>
    </S.FloatContainer>
  );
};

export default ProductImages;
