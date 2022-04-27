import { Badge } from "../../styles/utils.js";
import {
  Container,
  Header,
  PopupCloseBtn,
  Content,
  ProductImgs,
  ProductImg,
  DetailImgs,
  ProductDesc,
  Title,
  PriceDesc,
  NPrice,
  Prices,
  SPrice,
  DeliveryDesc,
  DeliveryDescList,
  DeliveryListTerm,
  PriceCalculator,
  ProductCounter,
  CountBtnImg,
  CountMinusBtn,
  CountPlusBtn,
  ProductCount,
  ProductTotalPrice,
  PriceNumber,
  OrderBtn,
} from "../../styles/Modal/Product.js";

const Product = ({
  product,
  productImg,
  totalPriceText,
  count,
  showModalPopup,
  handleDetailImgMouseOver,
  handleMinusBtnClick,
  handlePlusBtnClick,
  handleOrderBtnClick,
}) => {
  const productDeliveryInfo = [
    { id: "point", title: "적립금", desc: product.point },
    { id: "info", title: "배송정보", desc: product.delivery_info },
    { id: "fee", title: "배송비", desc: product.delivery_fee },
  ];

  return (
    <Container>
      <Header>
        <PopupCloseBtn onClick={showModalPopup}>닫기</PopupCloseBtn>
      </Header>
      <Content>
        <ProductImgs>
          <ProductImg src={productImg} alt=""></ProductImg>
          <DetailImgs>
            {product.thumb_images.map((e, i) => (
              <img src={e} onMouseOver={handleDetailImgMouseOver} key={i} />
            ))}
          </DetailImgs>
        </ProductImgs>
        <ProductDesc>
          <Title>{product.product_description}</Title>
          <PriceDesc>
            {product.prices.length === 1 ? (
              <>
                <Prices>
                  <SPrice>{product.prices[0]}</SPrice>
                </Prices>
              </>
            ) : (
              <>
                <NPrice>{product.prices[0]}</NPrice>
                <Prices>
                  <Badge bgColor={"orange"}>런칭특가</Badge>
                  <SPrice>{product.prices[1]}</SPrice>
                </Prices>
              </>
            )}
          </PriceDesc>
          <DeliveryDesc>
            {productDeliveryInfo.map((e) => {
              return (
                <DeliveryDescList key={e.id}>
                  <DeliveryListTerm>{e.title}</DeliveryListTerm>
                  <dd>{e.desc}</dd>
                </DeliveryDescList>
              );
            })}
          </DeliveryDesc>
          <PriceCalculator>
            <ProductCounter>
              <CountMinusBtn>
                <CountBtnImg
                  src={`${process.env.PUBLIC_URL}/images/Minus.svg`}
                  onClick={handleMinusBtnClick}
                ></CountBtnImg>
              </CountMinusBtn>
              <ProductCount>{count}</ProductCount>
              <CountPlusBtn>
                <CountBtnImg
                  src={`${process.env.PUBLIC_URL}/images/Plus.svg`}
                  onClick={handlePlusBtnClick}
                ></CountBtnImg>
              </CountPlusBtn>
            </ProductCounter>
            <ProductTotalPrice>
              총 주문금액 <PriceNumber>{totalPriceText}원</PriceNumber>
            </ProductTotalPrice>
          </PriceCalculator>
          <OrderBtn onClick={handleOrderBtnClick}>주문하기</OrderBtn>
        </ProductDesc>
      </Content>
    </Container>
  );
};

export default Product;
