import React, {useState, useEffect} from "react";
import {fetchData, postData} from "utils/utils";
import {serverURL} from "constants/urlPath";
import {
  DarkBackground,
  ModalBlock,
  CloseButton,
  InnerModalBlock,
  ProductImages,
  MainThumb,
  SubThumb,
  Product,
  ProductInfo,
  OrderButton,
  SuccessOrder,
} from "./Modal.styled";

function Modal({visible, onClose, productId}) {
  //const [goodsData, setGoodsData] = useState([]);
  const [orderInfo, setOrderInfo] = useState({id: 0, quantity: 0, price: 0});
  const [orderState, setOrderState] = useState(false);
  const [orderSuccess, setOrderSuccess] = useState(false);

  const fetchAPI = async () => {
    if (!productId) return;
    const data = await fetchData(`${serverURL}/${productId}`);
    console.log(data);
    //setGoodsData(data)
  };

  const handleOrder = () => {
    setOrderState(true);
    setOrderInfo({...orderInfo, id: productId, quantity: 1, price: 100});
  };

  const postAPI = async () => {
    if (!orderState) return;
    const response = await postData(`${serverURL}/order`, orderInfo);
    setOrderSuccess(response);
    if (!response) setOrderState(false);
  };

  useEffect(() => {
    fetchAPI();
  }, [productId]);

  useEffect(() => {
    postAPI();
  }, [orderState]);

  if (!visible) return;
  return (
    <DarkBackground>
      <ModalBlock>
        {orderSuccess ? (
          <SuccessOrder>주문이 완료되었습니다. 잠시후 메인 페이지로 이동합니다.</SuccessOrder>
        ) : (
          <>
            <CloseButton onClick={onClose}>닫기</CloseButton>
            <InnerModalBlock>
              <ProductImages>
                <MainThumb></MainThumb>
                <SubThumb></SubThumb>
              </ProductImages>
              <Product>
                <ProductInfo></ProductInfo>
                <OrderButton onClick={handleOrder}>주문하기</OrderButton>
              </Product>
            </InnerModalBlock>
          </>
        )}
      </ModalBlock>
    </DarkBackground>
  );
}

export {Modal};
