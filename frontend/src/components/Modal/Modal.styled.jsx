import styled from "styled-components";

const DarkBackground = styled.div`
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(0, 0, 0, 0.8);
`;

const ModalBlock = styled.div`
  width: 912px;
  height: 548px;
  padding: 48px;
  background: #fff;
  border: 2px solid;
`;

const CloseButton = styled.button`
  background: transparent;
  border: none;
`;

const InnerModalBlock = styled.div`
  display: flex;
`;

const ProductImages = styled.div`
  width: 392px;
  height: 472px;
`;

const MainThumb = styled.img`
  width: 392px;
  height: 392px;
`;

const SubThumb = styled.img`
  width: 72px;
  height: 72px;
`;

const Product = styled.div``;

const ProductInfo = styled.div`
  width: 440px;
  height: 237px;
`;

const OrderButton = styled.button`
  width: 440px;
  height: 58px;
  background: #000;
  color: #fff;
  font-weight: 700;
  font-size: 18px;
`;

const SuccessOrder = styled.h1`
  text-align: center;
`;

export {
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
};
