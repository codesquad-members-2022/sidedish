import { Badge } from "../../styled-components/utils.js";
import styled from "styled-components";

const ProductDetailModal = ({
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
          <ProductImg src={productImg} alt="상품이미지"></ProductImg>
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

const Container = styled.div`
  padding: 3.2rem 4.8rem 4.8rem;
  border-bottom: 0.2rem solid ${({ theme }) => theme.color.black};
`;

const Header = styled.div`
  display: flex;
  justify-content: flex-end;
`;

const PopupCloseBtn = styled.button`
  color: ${({ theme }) => theme.color.grey2};
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.medium};
  background-color: ${({ theme }) => theme.color.white};
  padding: 0;
  margin: 0;
  border: none;
  cursor: pointer;
  line-height: 2.6rem;
`;

const Content = styled.div`
  margin-top: 1.8rem;
  display: flex;
  gap: 3.2rem;
`;

const ProductImgs = styled.div``;

const ProductImg = styled.img`
  width: 39.2rem;
`;

const DetailImgs = styled.div`
  display: flex;
  height: 7.2rem;
  margin-top: 0.8rem;
  gap: 0.8rem;
`;

const ProductDesc = styled.div`
  width: 100%;
`;

const Title = styled.h2`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
  line-height: 3rem;
`;

const PriceDesc = styled.div`
  margin-top: 1.6rem;
  padding-bottom: 2.4rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.color.grey4};
`;

const Prices = styled.div`
  margin-top: 0.8rem;
  display: flex;
  align-items: center;
  gap: 0.8rem;
`;

const NPrice = styled.div`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.small};
  color: ${({ theme }) => theme.color.grey3};
  line-height: 2.4rem;
  text-decoration: line-through;
`;

const SPrice = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
`;

const DeliveryDesc = styled.dl`
  margin-top: 1.7rem;
  padding-bottom: 0.8rem;
  border-bottom: 0.1rem solid ${({ theme }) => theme.color.grey4};
`;

const DeliveryDescList = styled.div`
  display: flex;
  gap: 1.6rem;
  line-height: 1.8rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.xSmall};
  color: ${({ theme }) => theme.color.black};
  margin-bottom: 0.8rem;
`;

const DeliveryListTerm = styled.dt`
  width: 6rem;
  color: ${({ theme }) => theme.color.grey2};
`;

const PriceCalculator = styled.div`
  margin-top: 2.4rem;
  display: flex;
  justify-content: space-between;
`;

const ProductCounter = styled.div`
  display: flex;
  align-items: center;
  height: 2.6rem;
  line-height: 2.6rem;
`;

const CountBtn = styled.button`
  width: 2.4rem;
  height: 2.4rem;
  padding: 0;
  margin: 0;
  border: none;
  cursor: pointer;
  background-color: ${({ theme }) => theme.color.white};
`;

const CountBtnImg = styled.img`
  width: 2.4rem;
`;

const CountMinusBtn = styled(CountBtn)``;

const CountPlusBtn = styled(CountBtn)``;

const ProductCount = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.medium};
  color: ${({ theme }) => theme.color.black};
  text-align: center;
  width: 4rem;
`;

const ProductTotalPrice = styled.div`
  display: flex;
  align-items: center;
  gap: 1.6rem;
  font-weight: ${({ theme }) => theme.fontWeight.regular};
  font-size: ${({ theme }) => theme.fontSize.medium};
  color: ${({ theme }) => theme.color.grey2};
`;

const PriceNumber = styled.strong`
  font-weight: ${({ theme }) => theme.fontWeight.bold};
  font-size: ${({ theme }) => theme.fontSize.large};
  color: ${({ theme }) => theme.color.black};
`;

const OrderBtn = styled.button`
  box-sizing: border-box;
  width: 100%;
  padding: 1.6rem;
  margin-top: 12.3rem;
  border: none;
  cursor: pointer;
  background-color: ${({ theme }) => theme.color.black};
  color: ${({ theme }) => theme.color.white};
  font-weight: ${({ theme }) => theme.fontWeight.display};
  font-size: ${({ theme }) => theme.fontSize.xMedium};

  &:hover {
    background-color: ${({ theme }) => theme.color.grey1};
  }
`;

export default ProductDetailModal;
