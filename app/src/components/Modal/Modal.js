import { useEffect, useState } from "react";
import Carousel from "./Carousel.js";
import Product from "./Product.js";
import Alert from "./Alert.js";
import { Background } from "../../styles/utils.js";
import { Popup } from "../../styles/Modal/Modal.js";

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

  useEffect(() => {
    (async () => {
      await fetch(`https://api.codesquad.kr/onban/detail/${productHash}`)
        .then((res) => res.json())
        .then(({ data }) => {
          setProduct(data);
          setProductImg(data.top_image);

          data.prices.length === 1
            ? setPrice(data.prices[0].replace(/\D/g, ""))
            : setPrice(data.prices[1].replace(/\D/g, ""));
        });
    })();
  }, []);

  const handleDetailImgMouseOver = ({ target }) => {
    setProductImg(target.src);
  };

  const handleMinusBtnClick = () => {
    count > COUNT_MIN ? setCount(count - PRODUCT_COUNT) : setCount(COUNT_MIN);
  };

  const handlePlusBtnClick = () => {
    count < COUNT_MAX ? setCount(count + PRODUCT_COUNT) : setCount(COUNT_MAX);
  };

  const handleOrderBtnClick = () => {
    setShowAlert(!showAlert);
  };

  return (
    <>
      {product ? (
        <>
          <Background zIndex={1}></Background>
          <Popup>
            <Product
              product={product}
              productImg={productImg}
              totalPriceText={totalPriceText}
              count={count}
              showModalPopup={showModalPopup}
              handleDetailImgMouseOver={handleDetailImgMouseOver}
              handleMinusBtnClick={handleMinusBtnClick}
              handlePlusBtnClick={handlePlusBtnClick}
              handleOrderBtnClick={handleOrderBtnClick}
            />
            <Carousel />
          </Popup>
          {showAlert && <Alert handleOrderBtnClick={handleOrderBtnClick} />}
        </>
      ) : null}
    </>
  );
};

export default Modal;
