import { useContext, useState } from 'react';
import styled, { css } from 'styled-components';

import { ModalContext } from './ModalContext';

const SubProductList = styled.ul`
  display: flex;
  margin-top: 8px;
  overflow-x: auto;
  width: 392px;

  &::-webkit-scrollbar {
    display: none;
  }

  scrollbar-width: none;
`;

const ProductThumbnailWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const ProductPanel = styled.li`
  width: 392px;
  height: 340px;
  overflow: hidden;
  flex-shrink: 0;
  cursor: pointer;

  ${({ size }) => {
    return size === 'sm'
      ? css`
          width: 72px;
          height: 72px;
          overflow: hidden;

          & + & {
            margin-left: 8px;
          }

          &:hover {
            opacity: 0.6;
          }
        `
      : null;
  }}

  .product-img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
`;

export const ProductThumbnail = ({ ProductThumbnailData }) => {
  const { mainPanelImg, setMainPanelImg } = useContext(ModalContext);
  const onClickSubPanel = e => {
    setMainPanelImg(e.target.src);
  };

  return (
    <ProductThumbnailWrapper>
      <ProductPanel as={'div'} size={'md'}>
        <img className="product-img" src={mainPanelImg} alt="제품 상세 사진" />
      </ProductPanel>
      <SubProductList>
        {ProductThumbnailData.map((productImgData) => (
          <ProductPanel size={'sm'}>
            <img
              src={productImgData.url}
              alt="제품 상세 사진"
              key={productImgData.url.id}
              className="product-img"
              onClick={onClickSubPanel}
            />
          </ProductPanel>
        ))}
      </SubProductList>
    </ProductThumbnailWrapper>
  );
};
