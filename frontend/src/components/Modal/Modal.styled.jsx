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
  float: right;
`;

const InnerModalBlock = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const ProductImages = styled.div`
  width: 392px;
  height: 472px;
  margin-right: 32px;
`;

const MainThumb = styled.img`
  width: 392px;
  height: 392px;
`;

const SubThumb = styled.img`
  width: 72px;
  height: 72px;
`;

const ProductDetails = styled.div`
  display: flex;
  height: 466px;
  flex-direction: column;
  justify-content: space-between;
  margin-top: 30px;
  position: relative;
`;

const ProductInfo = styled.div`
  width: 440px;
  height: 237px;

  &::after {
    content: "";
    display: block;
    position: absolute;
    left: 0;
    width: 440px;
    height: 1px;
    background-color: #ebebeb;
  }
`;

const ProductName = styled.h1`
  font-weight: 500;
  font-size: 20px;
  margin-bottom: 54px;
`;

const PriceBox = styled.div`
  display: flex;
  margin-bottom: 40px;
`;

const ProductPrice = styled.div`
  margin-left: 8px;
  display: flex;

  .discountedPrice {
    font-weight: 500;
    font-size: 20px;
  }
`;

const OrderBox = styled.div`
  display: flex;
`;

const OrderCountBox = styled.div`
  display: flex;
  align-items: center;
  margin-right: 153px;
`;

const TotalPriceBox = styled.div`
  display: flex;
`;

const OrderButton = styled.button`
  width: 440px;
  height: 58px;
  background: #000;
  color: #fff;
  font-weight: 700;
  font-size: 18px;
`;

const TotalPriceTitle = styled.p`
  font-weight: 400;
  font-size: 16px;
  color: #777777;
  line-height: 22px;
  margin-right: 16px;
`;

const TotalPrice = styled.p`
  font-weight: 500;
  font-size: 20px;
`;

const OrderCount = styled.p``;

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
  ProductDetails,
  ProductInfo,
  OrderButton,
  SuccessOrder,
  PriceBox,
  ProductPrice,
  OrderBox,
  TotalPriceBox,
  OrderCountBox,
  TotalPriceTitle,
  TotalPrice,
  OrderCount,
  ProductName,
};
