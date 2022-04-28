import styled from 'styled-components';

import ProductDetail from './ProductDetail';
import RelatedProduct from './RelatedProduct';

const FoodModalWrap = styled.div`
  position: relative;
  background-color: white;
  width: 100%;
  height: 100%;
`;

const FoodModal = () => (
  <FoodModalWrap>
    <ProductDetail />
    <RelatedProduct />
  </FoodModalWrap>
);

export default FoodModal;
