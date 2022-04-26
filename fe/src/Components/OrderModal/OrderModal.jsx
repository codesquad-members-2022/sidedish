import styled, { css } from 'styled-components';

import { Colors, Fonts } from '@/Constants';

import { ProductThumbnail } from './ProductThumbnail';

import { DiscountBadge } from '@/Components/Badge';

const ModalBackGround = styled.div`
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.5);
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  z-index: 100;
`;

const OrderModalWrapper = styled.div`
  display: flex;
  flex-direction: column;
  background-color: beige;
  display: flex;
  width: 960px;
`;

const SelectedProduct = styled.section`
  display: flex;
  position: relative;

  margin: 48px;
  margin-top: 76px;
`;

const ProductInfo = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 32px;
`;

const Title = styled.span`
  display: block;
`;

const OriginalPrice = styled.span`
  display: block;
  color: ${Colors.LIGHT_GREY};
  margin-top: 16px;
`;

const ListPrice = styled.div`
  display: block;
  margin-top: 8px;
`;

const Price = styled.span`
  display: inline-block;
  margin-left: 8px;
`;

const RelatedProduct = styled.div``;

const DeliveryInfo = styled.ul`
  display: flex;
  width: 440px;
  margin-top: 24px;

  border-top: 0.5px solid ${Colors.LIGHT_GREY};
  border-bottom: 0.5px solid ${Colors.LIGHT_GREY};
`;

const ProductOrderSpec = styled.div`
  width: 60px;
  display: flex;
  flex-direction: column;
  color: ${Colors.LIGHT_GREY};

  padding-top: 16px;
  padding-bottom: 16px;
  li {
    margin-bottom: 8px;
  }
`;

const ProductOrderInfo = styled.ul`
  display: flex;
  flex-direction: column;

  padding-top: 16px;
  padding-bottom: 16px;
  li {
    margin-bottom: 8px;

    &:last-child {
      margin-bottom: 0;
    }
  }
`;

const AmountButton = styled.button`
  color: ${Colors.GREY};
  width: 24px;
  height: 24px;

  i {
    font-size: 20px;
  }
`;

const TotalAmount = styled.div`
  display: flex;
  width: 60px;
  justify-content: space-between;
  align-items: center;
  margin-left: 6px;
`;

const TotalCost = styled.span`
  display: inline-block;
`;

const CurrentAmount = styled.span``;

const OrderPrice = styled.div`
  display: flex;
  justify-content: space-between;
  width: 440px;
  margin-top: 26px;
`;

const OrderButton = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 16px;
  background-color: black;
  color: white;

  position: absolute;
  width: 440px;
  height: 58px;
  right: 0px;
  bottom: 20px;
`;

const Icon = styled.i`
  color: ${Colors.GREY};
`;

export const OrderModal = () => {
  return (
    <ModalBackGround>
      <OrderModalWrapper>
        <SelectedProduct>
          <ProductThumbnail
            ProductThumbnailData={[
              'https://img.insight.co.kr/static/2019/06/26/700/f31l48lhp1v2tuq7ce8o.jpg',
              'https://img.insight.co.kr/static/2019/06/26/700/5nmluh24cnp5h4rb3vj4.jpg',
              'https://studyforus.com/files/attach/images/1816/212/461/aca7e1aed69a698c8896c641d77085dd.png',
            ]}
          />

          <ProductInfo>
            <Title className={Fonts.LG}>오이피자</Title>
            <OriginalPrice className={Fonts.SM}>15800 원</OriginalPrice>

            <ListPrice>
              <DiscountBadge />
              <Price className={Fonts.LG}>12000 원</Price>
            </ListPrice>

            <DeliveryInfo>
              <ProductOrderSpec>
                <li className={Fonts.XS}>적립금</li>
                <li className={Fonts.XS}>주소</li>
                <li className={Fonts.XS}>배달금</li>
              </ProductOrderSpec>

              <ProductOrderInfo>
                <li className={Fonts.XS}>180 원</li>
                <li className={Fonts.XS}>이곳은 주소입니다</li>
                <li className={Fonts.XS}>3000 원</li>
              </ProductOrderInfo>
            </DeliveryInfo>

            <OrderPrice>
              <TotalAmount>
                <AmountButton>
                  <Icon className={'ic-plus'} aria-label={'상품 추가'} />
                </AmountButton>
                <CurrentAmount>0</CurrentAmount>
                <AmountButton>
                  <Icon className={'ic-minus'} aria-label={'상품 '} />
                </AmountButton>
              </TotalAmount>

              <TotalCost>최종 가격</TotalCost>
            </OrderPrice>
          </ProductInfo>

          <OrderButton>주문하기</OrderButton>
        </SelectedProduct>

        <RelatedProduct></RelatedProduct>
      </OrderModalWrapper>
    </ModalBackGround>
  );
};
