import { createContext, useState, useEffect } from 'react';

import { API_URL } from '@/Env';
import { fetchData } from '@/Utils';
export const ModalContext = createContext(null);

const setUpCost = (discountPolicy, discountRate, originalPrice) => {
  if (!discountPolicy) {
    return originalPrice;
  }
  return originalPrice - originalPrice * discountRate;
};

export const ModalStore = props => {
  const [ModalDisplay, setModalDisplay] = useState(false);
  const [productID, setProductID] = useState(null);
  const [productDetail, setProductDetail] = useState(null);
  const [currentAmount, setCurrentAmount] = useState(1);
  const [totalCost, setTotalCost] = useState(null);
  const [productPrice, setProductPrice] = useState(null);
  const [mainPanelImg, setMainPanelImg] = useState(null);

  const reset = () => {
    setProductID(null);
    setModalDisplay(false);
    setProductDetail(null);
    setCurrentAmount(1);
    setTotalCost(null);
    setProductPrice(null);
    setMainPanelImg(null);
  };

  useEffect(() => {
    if (!productID) {
      return;
    }
    fetchData(`${API_URL}/items/${productID}`)
      .then(productData => {
        const parsedProductData = productData.result_body;
        setProductPrice(parsedProductData.price);
        setProductDetail(parsedProductData);
        setMainPanelImg(parsedProductData.images[0].url);
        setTotalCost(
          setUpCost(
            parsedProductData.discountPolicy,
            parsedProductData.discountRate,
            parsedProductData.price
          )
        );
      })
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
        totalCost,
        setTotalCost,
        productPrice,
        mainPanelImg,
        setMainPanelImg,
        reset,
      }}
    >
      {props.children}
    </ModalContext.Provider>
  );
};
