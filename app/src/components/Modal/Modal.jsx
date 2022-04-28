import { useEffect, useState } from "react";
import Carousel from "./Carousel.js";
import ProductDetailModal from "./ProductDetailModal.js";
import Alert from "./Alert.js";
import { Background } from "../../styled-components/utils.js";
import styled from "styled-components";

const Modal = ({ showModalPopup, productHash }) => {
  const [product, setProduct] = useState("");
  const [productImg, setProductImg] = useState("");
  const [count, setCount] = useState(1);
  const [price, setPrice] = useState(0);
  const [showAlert, setShowAlert] = useState(false);

  const COUNT_MIN = 1;
  const COUNT_MAX = 99;
  const PRODUCT_COUNT = 1;
  const totalPrice = count * price;
  const totalPriceText = totalPrice.toLocaleString();

  const isDiscountedProduct = (data) => {
    if (data.prices.length === 1) return true;

    return false;
  };

  const checkPriceLength = (data) => {
    isDiscountedProduct(data)
      ? setPrice(data.prices[0].replace(/\D/g, ""))
      : setPrice(data.prices[1].replace(/\D/g, ""));
  };

  const parseProductData = (data) => {
    setProduct(data);
    setProductImg(data.top_image);
    checkPriceLength(data);
  };

  useEffect(() => {
    (async () => {
      const res = await fetch(
        `https://api.codesquad.kr/onban/detail/${productHash}`
      );
      const resJson = await res.json();
      const data = resJson.data;

      parseProductData(data);
    })();
  }, []);

  const handleMouseOverDetailImg = ({ target }) => {
    setProductImg(target.src);
  };

  const handleClickMinusBtn = () => {
    count > COUNT_MIN ? setCount(count - PRODUCT_COUNT) : setCount(COUNT_MIN);
  };

  const handleClickPlusBtn = () => {
    count < COUNT_MAX ? setCount(count + PRODUCT_COUNT) : setCount(COUNT_MAX);
  };

  const handleClickOrderBtn = () => {
    setShowAlert(!showAlert);
  };

  return (
    <>
      {product && (
        <>
          <Background zIndex={1}></Background>
          <Popup>
            <ProductDetailModal
              product={product}
              productImg={productImg}
              totalPriceText={totalPriceText}
              count={count}
              showModalPopup={showModalPopup}
              handleMouseOverDetailImg={handleMouseOverDetailImg}
              handleClickMinusBtn={handleClickMinusBtn}
              handleClickPlusBtn={handleClickPlusBtn}
              handleClickOrderBtn={handleClickOrderBtn}
            />
            <Carousel />
          </Popup>
          {showAlert && <Alert handleClickOrderBtn={handleClickOrderBtn} />}
        </>
      )}
    </>
  );
};

const Popup = styled.div`
  box-sizing: border-box;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 96rem;
  height: 99.4rem;
  background-color: ${({ theme }) => theme.color.white};
  border: 0.2rem solid ${({ theme }) => theme.color.black};
  z-index: 2;
`;

export default Modal;
