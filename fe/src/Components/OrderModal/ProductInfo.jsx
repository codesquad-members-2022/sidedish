import { useContext } from 'react';
import styled from 'styled-components';

import { Colors, Fonts } from '@/Constants';
import { API_URL } from '@/Env';
import { postData } from '@/Utils';

import { ModalContext } from './ModalContext';
import { ProductAmount } from './ProductAmount';

import { DiscountBadge } from '@/Components/Badge';
import { OrderButton } from '@/Components/Button';

const ProductInfoWrapper = styled.div`
  position: relative;
  display: flex;
  flex-direction: column;
  margin-left: 32px;

  .order-button {
    position: absolute;
    bottom: 1px;
  }
`;

const Title = styled.span`
  display: block;
`;

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

export const ProductInfo = ({
  productData: {
    id,
    title,
    description,
    price,
    accumulate,
    discountPolicy,
    discountRate,
    quantity,
    images,
  },
}) => {
  const { currentAmount } = useContext(ModalContext)

  const deliveryFee = 3000;

  const handleClickOrderButton = () => {
    const requestBody = {
      id,
      quantity: currentAmount
    }
    postData(`${API_URL}/item`, requestBody)
      .then(() => {
        alert('주문 성공');
        window.location.reload();
      })
      .catch((err)=> {
        console.error(err);
        alert('주문 실패');
      })
  }

  return (
    <ProductInfoWrapper>
      <Title className={Fonts.LG}>{title}</Title>
      {discountPolicy ? (
        <>
          <OriginalPrice className={Fonts.SM}>
            {price.toLocaleString()} 원
          </OriginalPrice>
          <ListPrice>
            <DiscountBadge type={discountPolicy} />
            <Price className={Fonts.LG}>
              {(price - price * discountRate).toLocaleString()} 원
            </Price>
          </ListPrice>
        </>
      ) : (
        <Price className={Fonts.LG}>{price.toLocaleString()} 원</Price>
      )}
      <DeliveryInfo className={Fonts.XS}>
        <ProductOrderSpec>
          <li>적립금</li>
          <li>주소</li>
          <li>배달금</li>
        </ProductOrderSpec>

        <ProductOrderInfo>
          <li>{accumulate.toLocaleString()} 원</li>
          <li>이곳은 주소입니다</li>
          <li>{deliveryFee.toLocaleString()} 원</li>
        </ProductOrderInfo>
      </DeliveryInfo>

      <ProductAmount
        priceData={discountPolicy ? price - discountRate * price : price}
      />
      <OrderButton onClick={handleClickOrderButton} disabled={quantity === 0 || quantity < currentAmount}/>
    </ProductInfoWrapper>
  );
};
