import { useState } from 'react';
import * as S from './ProductDetailModal.style';

import { IMAGE, DIRECTION } from '../../constants/productDetailModal';

const ProductImages = ({ images }) => {
  const [mainImageId, setMainImageId] = useState(IMAGE.INITIAL_ID);

  const getImageSrc = id =>
    images.reduce((src, image) => {
      if (image.id === id) src = image.src;
      return src;
    }, '');

  return (
    <S.FloatContainer direction={DIRECTION.LEFT}>
      <S.Image src={getImageSrc(mainImageId)} alt='큰이미지' size={IMAGE.SIZE_BIG} />
      <S.ImageList>
        {images.map(({ id, src }) => (
          <li key={id} onClick={() => setMainImageId(id)}>
            <S.Image
              src={src}
              alt={`상품이미지${id}`}
              size={IMAGE.SIZE_SMALL}
              isMain={id === mainImageId}
            />
          </li>
        ))}
      </S.ImageList>
    </S.FloatContainer>
  );
};

export default ProductImages;
