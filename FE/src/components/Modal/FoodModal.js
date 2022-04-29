import { useContext, useEffect, useState } from 'react';
import styled from 'styled-components';

import categoriesApi from '../../apis/categoriesApi';
import ModalInfoContextStore from '../../stores/ModalInfoStore';
import ProductDetail from './ProductDetail';
import RelatedProduct from './RelatedProduct';

const FoodModalWrap = styled.div`
  position: relative;
  background-color: white;
  width: 100%;
  height: 100%;
`;

const FoodModal = () => {
  const [relatedProduct, setRelatedProduct] = useState([]);

  const ModalInfo = useContext(ModalInfoContextStore);

  useEffect(() => {
    const fetchRelatedContent = async () => {
      const {
        data: {
          suggestItemList: { content: relatedContents },
        },
      } = await categoriesApi.getRelatedFoodsByFood(ModalInfo.cardInfo.id);
      setRelatedProduct(relatedContents);
    };
    if (ModalInfo.modalDisplay !== 'none') {
      fetchRelatedContent();
    }
  }, [ModalInfo.modalDisplay]);

  return (
    relatedProduct.length && (
      <FoodModalWrap>
        <ProductDetail />
        <RelatedProduct relatedProduct={relatedProduct} />
      </FoodModalWrap>
    )
  );
};

export default FoodModal;
