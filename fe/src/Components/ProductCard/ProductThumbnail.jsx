import styled from 'styled-components';

import { HoverInfo } from './HoverInfo';

const ProductThumbnailWrapper = styled.div`
  position: relative;
  width: 411px;
  height: 411px;

  .product-img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }

  &:hover {
    .hover-info {
      opacity: 0.8;
    }

    .mask {
      opacity: 1;
    }
  }
`;

const Mask = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  bottom: 0;
  z-index: 1;
  opacity: 0;
  background-color: rgba(0, 0, 0, 0.2);
  transition: opacity 150ms;
`;

export const ProductThumbnail = ({
  imgUrl,
  morningDelivery,
  onclickThumbnail,
}) => {
  return (
    <ProductThumbnailWrapper
      className={'product-thumbnail'}
      onClick={onclickThumbnail}
    >
      {morningDelivery && <HoverInfo />}
      <Mask className={'mask'} />
      <img className={'product-img'} src={imgUrl} alt={'제품사진'} />
    </ProductThumbnailWrapper>
  );
};
