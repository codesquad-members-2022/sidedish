import React from 'react';
import styled from 'styled-components';

const RelatedProductWrap = styled.div`
  width: 100%;
  height: 396px;
  box-sizing: border-box;
  padding: 48px;
  display: flex;
  flex-direction: row;
  justify-content: center;
`;
const TitleAndNavButtons = styled.div`
  /* width: 100%; */
  display: flex;
  justify-content: space-between;
  border: 1px solid black;
`;
const Title = styled.div`
  font-weight: 500;
  font-size: 20px;
  line-height: 30px;
`;
const RelatedProductSlide = styled.div``;
function RelatedProduct(relatedDishes) {
  return (
    <RelatedProductWrap>
      <TitleAndNavButtons>
        <Title>함께하면 더욱 맛있는 상품</Title>
      </TitleAndNavButtons>
      <RelatedProductSlide></RelatedProductSlide>
    </RelatedProductWrap>
  );
}

export default RelatedProduct;
