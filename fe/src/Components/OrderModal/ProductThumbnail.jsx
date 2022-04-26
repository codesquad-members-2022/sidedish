import styled, { css } from 'styled-components';

const SubProductList = styled.div`
  display: flex;
`;

const ProductThumbnailWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const ProductPanel = styled.li`
  width: 400px;
  height: 400px;
  overflow: hidden;

  ${({ size }) => {
    return size === 'sm'
      ? css`
          width: 72px;
          height: 72px;
          overflow: hidden;
          margin: 8px 8px 0 0;
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
  return (
    <ProductThumbnailWrapper>
      <ProductPanel size={'md'}>
        <img
          className="product-img"
          src={ProductThumbnailData[0]}
          alt="제품 상세 사진"
        />
      </ProductPanel>
      <SubProductList>
        {ProductThumbnailData.map((imgUrl, idx) => {
          return (
            <ProductPanel size={'sm'}>
              <img
                src={imgUrl}
                alt="제품 상세 사진"
                key={idx}
                className="product-img"
              />
            </ProductPanel>
          );
        })}
      </SubProductList>
    </ProductThumbnailWrapper>
  );
};
