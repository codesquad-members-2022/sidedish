import { createContext, useState } from 'react';

export const ModalContext = createContext(null);

export const ModalStore = props => {
  const [ModalDisplay, setModalDisplay] = useState(false);
  const [productID, setProductID] = useState(1);
  const [productDetail, setProductDetail] = useState(null);
  const [currentAmount, setCurrentAmount] = useState(1);

  useEffect(() => {
    if (!productID) {
      return;
    }

    fetchData(`/items/${productID}`)
      .then(productData => setProductDetail(productData))
      .catch(err => console.error(err));
  }, [productID]);

  return (
    <ModalContext.Provider
      value={{
        ModalDisplay,
        setModalDisplay,
        setProductID,
        productDetail,
        currentAmount,
        setCurrentAmount,
      }}
    >
      {props.children}
    </ModalContext.Provider>
  );
};
