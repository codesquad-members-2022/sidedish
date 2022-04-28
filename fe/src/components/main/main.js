import { useState } from 'react';
import { BestProduct } from './bestProduct/BestProduct';
import { CategoryArea } from './categoryArea/CategoryArea';
import { ProductDetailModal } from './productDetailModal/productDetailModal';

export function Main() {
  const [modal, setModal] = useState(null);
  return (
    <>
      <BestProduct setModal={setModal} />
      <CategoryArea setModal={setModal} />
      <ProductDetailModal data={modal}></ProductDetailModal>
    </>
  );
}
