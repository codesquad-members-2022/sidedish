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
const TitleAndButtons = styled.div`
  width: 598px;
  display: flex;
  justify-content: space-between;
  border: 1px solid black;
`;
function RelatedProduct(relatedDishes) {
  return (
    <RelatedProductWrap>
      <TitleAndButtons></TitleAndButtons>
    </RelatedProductWrap>
  );
}

export default RelatedProduct;
